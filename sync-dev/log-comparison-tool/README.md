# 日志比较工具

这个项目是一个简单的日志比较工具，它可以读取上传的日志文件，并绘制块号随时间变化的折线图。

## 功能

- 上传日志文件
- 绘制多个日志文件的块号随时间变化的折线图
- 比较选择的日志文件的折线图

## 安装

1. 克隆本仓库到本地计算机：

```
git clone https://github.com/Dawn-githup/sync.git
```

2. 进入项目目录：

```
cd sync/sync-dev/log-comparison-tool
```

3. 创建和激活虚拟环境（可选，但建议）：

```
python3 -m venv venv
source venv/bin/activate
```

4. 安装依赖：

```
pip install -r requirements.txt
```

## 使用

1. 运行应用程序：

```
python app.py
```

2. 打开浏览器，访问 http://localhost:5000

3. 上传日志
4. 在首页上传日志文件，单击 "Compare" 按钮进行比较。

## 示例日志格式

日志文件应符合以下格式：

```
2023-05-24 09:54:37.766 +00:00 ChainService INFO ckb_chain::chain  block: 2950, hash: 0x65e7360b4efb974995f40c78016e04bb9fb39dcebfc724309c73bc321ba1d322, epoch: 2(150/1800), total_diff: 0x63730, txs: 753
2023-05-24 09:54:37.771 +00:00 ChainService INFO ckb_chain::chain  block: 2951, hash: 0x42b069798da0597e6a1edefa143a1750a172efbd0fcd895fa2b76f20cabd0f4b, epoch: 2(151/1800), total_diff: 0x637c0, txs: 1
...
```

日志行应包含时间戳和块号信息。

## Contributing

欢迎贡献代码，提出问题或建议。请提交问题和建议的 Issue，或者通过 Pull Request 提交代码更改。

## License

这个项目基于 [MIT License](LICENSE) 开源。
```

这个示例的 `README.md` 文件提供了项目的概述、安装说明、使用说明和许可证信息。您可以根据自己的项目进行适当的修改和补充，以便清晰地传达有关您的项目的信息和指南。