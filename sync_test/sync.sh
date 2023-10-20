#!/bin/sh

path="/home/ckb/ckb.v0.108/ckb_v0.112.0-rc1_x86_64-unknown-linux-gnu"
paths="/home/ckb/ckb.v0.108"

killckb() {
  PROCESS=`ps -ef|grep /ckb|grep -v grep|awk '{print $2}' | sed -n '2,10p'`
  for i in $PROCESS
  do
    echo "killed the ckb $i"
    sudo kill -9 $i
  done
}

# Stop any running CKB processes
killckb

# Delete node information
cd $paths
sudo rm -rf ckb_v0.112.0-rc1_x86_64-unknown-linux-gnu
sleep 1m
tar -xzvf ckb_v0.112.0-rc1_x86_64-unknown-linux-gnu.tar.gz
sleep 1m

# Initialize nodes
cd $path
./ckb init
sleep 1m

# Write configuration information
# Specify the path to the configuration file
config_file="/home/ckb/ckb.v0.108/ckb_v0.112.0-rc1_x86_64-unknown-linux-gnu/ckb.toml"

# New listen_address configuration value
new_listen_address="0.0.0.0:8114"

# Define the module to add
new_module="\"Indexer\""

# Define the configuration content to be added
config_content="
[metrics.exporter.prometheus]
target = { type = \"prometheus\", listen_address = \"0.0.0.0:8100\" }

# # Experimental: Monitor memory changes.
[memory_tracker]
# # Seconds between checking the process, 0 is disable, default is 0.
interval = 5
"

# Check if the configuration file exists
if [ -f "$config_file" ]; then
  # Use the sed command to add the new listen_address configuration value to the configuration file
  sed -i "s/^listen_address = .*/listen_address = \"$new_listen_address\"/" "$config_file"

  echo "listen_address has been added to $new_listen_address"

  # Use the sed command to add the new module to the configuration file
  sed -i "/^modules = .*/s/\]/, $new_module\]/" "$config_file"

  echo "$new_module has been added to the configuration file $config_file"

  # Append the configuration content to the configuration file
  echo "$config_content" >> "$config_file"

  echo "The configuration content has been added to $config_file"
else
  echo "The configuration file $config_file does not exist. Please confirm the file path is correct."
fi

# Wait for 1 minute
sleep 1m

# Start CKB minnet
cd $path
sudo nohup ./ckb run &
echo "CKB started mainnet..."

# Wait for 23 hours
sleep 23h

# Stop CKB again after 23 hours
killckb
echo "CKB stopped..."

# Wait for 30m
sleep 30m

# Delete node information
cd $paths
sudo rm -rf ckb_v0.112.0-rc1_x86_64-unknown-linux-gnu
sleep 1m
tar -xzvf ckb_v0.112.0-rc1_x86_64-unknown-linux-gnu.tar.gz
sleep 1m

# Initialize nodes
cd $path
./ckb init --chain testnet
sleep 1m

# Write configuration information
# Specify the path to the configuration file
config_file="/home/ckb/ckb.v0.108/ckb_v0.112.0-rc1_x86_64-unknown-linux-gnu/ckb.toml"

# New listen_address configuration value
new_listen_address="0.0.0.0:8114"

# Define the module to add
new_module="\"Indexer\""

# Define the configuration content to be added
config_content="
[metrics.exporter.prometheus]
target = { type = \"prometheus\", listen_address = \"0.0.0.0:8100\" }

# # Experimental: Monitor memory changes.
[memory_tracker]
# # Seconds between checking the process, 0 is disable, default is 0.
interval = 5
"

# Check if the configuration file exists
if [ -f "$config_file" ]; then
  # Use the sed command to add the new listen_address configuration value to the configuration file
  sed -i "s/^listen_address = .*/listen_address = \"$new_listen_address\"/" "$config_file"

  echo "listen_address has been added to $new_listen_address"

  # Use the sed command to add the new module to the configuration file
  sed -i "/^modules = .*/s/\]/, $new_module\]/" "$config_file"

  echo "$new_module has been added to the configuration file $config_file"

  # Append the configuration content to the configuration file
  echo "$config_content" >> "$config_file"

  echo "The configuration content has been added to $config_file"
else
  echo "The configuration file $config_file does not exist. Please confirm the file path is correct."
fi

# Wait for 1 minute
sleep 1m

# Start CKB testnet
cd $path
sudo nohup ./ckb run &
echo "CKB started testnet..."

# Wait for 23 hours
sleep 23h

# Stop CKB again after 23 hours
killckb
echo "CKB stopped..."

#PROCESS=`ps -ef|grep /ckb|grep -v grep|awk '{print $2}' | sed -n '2,10p'`
#for i in $PROCESS
#do
  #echo "killed the ckb $i"
 # sudo kill -9 $i
#done

# sh /home/baoleiji/yace/run_yace.sh