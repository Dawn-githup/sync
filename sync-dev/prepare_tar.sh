mkdir ckb_data
cp ckb ckb_data
cp ckb.toml ckb_data
cp default.db-options ckb_data
cp ckb-miner.toml ckb_data
cp -r specs ckb_data

CONFIG_FILE="ckb_data/ckb.toml"

# 1. 将配置文件里的bootnodes清空
sed -i '/bootnodes = \[/c\bootnodes = []' "$CONFIG_FILE"

# 2. 将listen_addresses修改为listen_addresses = ["/ip4/0.0.0.0/tcp/__P2P_PORT__"]
sed -i 's/^listen_addresses = .*/listen_addresses = ["\/ip4\/0.0.0.0\/tcp\/__P2P_PORT__"]/g' "$CONFIG_FILE"

# 3. 将 listen_address 修改为 listen_address = "0.0.0.0:__RPC_PORT__"
sed -i 's/^listen_address = .*/listen_address = "0.0.0.0:__RPC_PORT__"/g' "$CONFIG_FILE"
tar -zcvf ckb.tar.gz ckb_data
