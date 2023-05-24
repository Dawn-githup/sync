# CKB-DEV 同步脚本使用说明

本脚本用于在 CKB（Nervos网络）节点之间进行数据同步。以下是使用说明和步骤：

## 准备

在开始同步之前，请确保您已经完成以下准备工作：

1. 确保您已经安装了所需的软件和依赖项，包括 Bash、curl、tar、jq 等。

2. 在要同步的dev 版本的 CKB 节点上，执行prepare_tar脚本,该目录下必须包含如下文件：

    - `ckb`：CKB 可执行文件
    - `ckb.toml`：CKB 的配置文件
    - `default.db-options`：CKB 的数据库配置文件
    - `ckb-miner.toml`：CKB 的矿工配置文件
    - `specs`：CKB 的规格文件目录

3. 确保您有一个可用的 CKB 同步节点（Sync Node）的 RPC URL。您可以从该节点获取同步所需的数据。

## 步骤

按照以下步骤执行同步脚本：

1. 打开 `prepare_tar.sh` 脚本文件，并根据需要进行以下修改：

    - 如果您希望清空配置文件中的 `bootnodes`，请注释掉第 17 行（添加 `#` 符号）。
    - 如果您希望将 `listen_addresses` 修改为指定的 P2P 端口，请将第 20 行的 `__P2P_PORT__` 替换为您希望的 P2P 端口。
    - 如果您希望将 `listen_address` 修改为指定的 RPC 端口，请将第 23 行的 `__RPC_PORT__` 替换为您希望的 RPC 端口。

   在要同步的ckb节点下 运行以下命令来准备 CKB 数据目录和打包文件：

   ```shell
   $ chmod +x prepare_tar.sh  # 添加执行权限
   $ ./prepare_tar.sh
   ```

   运行以上命令后，将生成一个名为 `ckb.tar.gz` 的打包文件，其中包含了要同步的 CKB 数据。

2. 打开 `start.sh` 脚本文件，并根据需要进行以下修改：

    - 如果您希望修改默认的 RPC 端口，请使用 `-r` 或 `--rpc-port` 选项，后跟您希望使用的 RPC 端口号。例如：`./start.sh --rpc-port 8114`
    - 如果您希望修改默认的 P2P 端口，请使用 `-p` 或 `--p2p-port` 选项，后跟您希望使用的 P2P 端口号。例如：`./start.sh --p2p-port 8025`
    - 如果您希望使用自定义的链配置数据文件，请使用 `-c` 或 `--config-data` 选项，后跟您的链配置数据文件的路径。例如：`./start.sh --config-data ckb.tar.gz`


- 如果您希望修改默认的同步节点 RPC URL，请使用 `-u` 或 `--sync-rpc-url` 选项，后跟您希望使用的同步节点的 RPC URL。例如：`./start.sh --sync-rpc-url http://my-sync-node:8024`
- 如果您希望修改默认的同步数据目录，请使用 `-d` 或 `--sync-data` 选项，后跟您希望使用的同步数据目录的路径。例如：`./start.sh --sync-data my_sync_data`

运行以下命令来启动 CKB 同步：

   ```shell
   $ chmod +x start.sh  # 添加执行权限
   $ ./start.sh
   ```

脚本将执行以下操作：

- 解压 `ckb.tar.gz` 打包文件，并将其中的数据目录移动到指定的同步数据目录。
- 将同步数据目录中的配置文件中的 RPC 端口和 P2P 端口修改为指定的端口号。
- 向配置文件中添加同步节点的地址。

完成后，您的 CKB 节点将开始与同步节点进行数据同步。

同步之后可以使用[log-comparison-tool](log-comparison-tool)来解析同步的日志

以上是使用 CKB 同步脚本的基本步骤和说明。根据您的需求，可以根据提示进行必要的修改和自定义。如有其他问题，请随时提问。