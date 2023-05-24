#!/bin/bash

# Default values
RPC_PORT=8114
P2P_PORT=8025
CHAIN_CONFIG_DATA="ckb.tar.gz"
SYNC_RPC_URL="http://18.162.180.86:8024"
SYNC_DATA="ckb2"

# Help message
display_help() {
    echo "Usage: ./setup.sh [OPTIONS]"
    echo "Options:"
    echo "  -r, --rpc-port <port>        Specify the RPC port (default: 8114)"
    echo "  -p, --p2p-port <port>        Specify the P2P port (default: 8025)"
    echo "  -c, --config-data <file>     Specify the chain config data file (default: ckb.tar.gz)"
    echo "  -u, --sync-rpc-url <url>     Specify the sync node RPC URL (default: http://18.162.180.86:8120)"
    echo "  -d, --sync-data <dir>        Specify the sync data directory (default: ckb2)"
    echo "  -h, --help                   Display this help message"
}

# Parse command line arguments
while [[ $# -gt 0 ]]; do
    key="$1"
    case $key in
        -r|--rpc-port)
            RPC_PORT="$2"
            shift
            shift
            ;;
        -p|--p2p-port)
            P2P_PORT="$2"
            shift
            shift
            ;;
        -c|--config-data)
            CHAIN_CONFIG_DATA="$2"
            shift
            shift
            ;;
        -u|--sync-rpc-url)
            SYNC_RPC_URL="$2"
            shift
            shift
            ;;
        -d|--sync-data)
            SYNC_DATA="$2"
            shift
            shift
            ;;
        -h|--help)
            display_help
            exit 0
            ;;
        *)
            echo "Unknown option: $1"
            display_help
            exit 1
            ;;
    esac
done

# get sync node url
node_id=`curl ${SYNC_RPC_URL} -X POST -H "Content-Type: application/json" -d '{"jsonrpc": "2.0", "method":"local_node_info", "params": [], "id": 1}' | jq -r '.result.node_id'`
node_port=$(echo `curl ${SYNC_RPC_URL} -X POST -H "Content-Type: application/json" -d '{"jsonrpc": "2.0", "method":"local_node_info", "params": [], "id": 1}' | jq -r '.result.addresses[0].address'` | awk -F'/' '{print $NF}')
ip=$(echo "$SYNC_RPC_URL" | sed -n 's/.*\/\/\([^:]*\):.*/\1/p')
echo "IP:${ip},node_id:${node_id}"
# tar >> SYNC_DATA
tar -zxvf ckb.tar.gz
mv ckb_data ${SYNC_DATA}
# change config RPC_PORT && P2P_PORT
sed -i -e "s/__P2P_PORT__/${P2P_PORT}/g" ${SYNC_DATA}/ckb.toml
sed -i -e "s/__RPC_PORT__/${RPC_PORT}/g" ${SYNC_DATA}/ckb.toml
# add node
BOOTNODES_DATA="[\"\/ip4\/${ip}\/tcp\/${node_port}\/p2p\/${node_id}\""
echo ${BOOTNODES_DATA}
sed -i '' 's/^bootnodes = \[/bootnodes = '"${BOOTNODES_DATA}"'/g' "${SYNC_DATA}/ckb.toml"
# start