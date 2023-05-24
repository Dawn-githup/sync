import os
import re
import json
import plotly.graph_objects as go
from datetime import datetime
from flask import Flask, render_template, request
from werkzeug.utils import secure_filename
LOG_PATTERN = r'(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}\.\d+) \+\d{2}:\d{2}.*block: (\d+).*'

app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = 'uploads'
app.config['ALLOWED_EXTENSIONS'] = {'txt','log'}

def allowed_file(filename):
    return '.' in filename and \
           filename.rsplit('.', 1)[1].lower() in app.config['ALLOWED_EXTENSIONS']

@app.route('/')
def index():
    return render_template('index.html')


def get_txt_files():
    files = os.listdir(app.config['UPLOAD_FOLDER'])
    print(files)
    txt_files = [f for f in files]
    return txt_files

@app.route('/plot', methods=['GET', 'POST'])
def plot():
    if request.method == 'POST':
        # 检查是否有文件被上传
        if 'files' not in request.files:
            return render_template('plot.html', error='No files uploaded')

        files = request.files.getlist('files')
        timestamps = []
        block_numbers = []

        for file in files:
            # 检查文件名和文件类型是否合法
            if file.filename == '':
                return render_template('plot.html', error='No file selected')

            if not allowed_file(file.filename):
                return render_template('plot.html', error='Invalid file type')

            # 将上传的文件保存到本地
            filename = secure_filename(file.filename)
            file_path = os.path.join(app.config['UPLOAD_FOLDER'], filename)
            file.save(file_path)

            # 处理日志文件
            pattern = r'(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}\.\d+) \+\d{2}:\d{2}.*block: (\d+).*'
            with open(file_path, 'r') as log_file:
                log = log_file.read()
                matches = re.findall(pattern, log)

            # 提取时间戳和块号
            timestamps_file = []
            block_numbers_file = []

            for match in matches:
                timestamp = datetime.strptime(match[0], "%Y-%m-%d %H:%M:%S.%f")
                block_number = int(match[1])
                timestamps_file.append(timestamp)
                block_numbers_file.append(block_number)

            timestamps.append(timestamps_file)
            block_numbers.append(block_numbers_file)

        # 创建交互式折线图
        fig = go.Figure()

        for i in range(len(files)):
            fig.add_trace(go.Scatter(x=timestamps[i], y=block_numbers[i], mode='lines', name=f'Log {i+1}'))

        fig.update_layout(
            title='Block Number vs. Timestamp',
            xaxis=dict(title='Timestamp'),
            yaxis=dict(title='Block Number'),
        )

        plot_div = fig.to_html(full_html=False)

        return render_template('plot.html', plot_div=plot_div)

    return render_template('plot.html')


@app.route('/compare', methods=['GET', 'POST'])
def compare():

    log_files = os.listdir(app.config['UPLOAD_FOLDER'])
    log_files.sort()

    if request.method == 'POST':
        selected_files = request.form.getlist('log_files')
        timestamps = []
        block_numbers = []

        for file in selected_files:
            file_path = os.path.join(app.config['UPLOAD_FOLDER'], file)

            # 处理日志文件
            with open(file_path, 'r') as log_file:
                log = log_file.read()
                matches = re.findall(LOG_PATTERN, log)

            # 提取时间戳和块号
            timestamps_file = []
            block_numbers_file = []

            for match in matches:
                timestamp = datetime.strptime(match[0], "%Y-%m-%d %H:%M:%S.%f")
                block_number = int(match[1])
                timestamps_file.append(timestamp)
                block_numbers_file.append(block_number)

            timestamps.append(timestamps_file)
            block_numbers.append(block_numbers_file)

        # 创建交互式折线图
        fig = go.Figure()

        for i in range(len(selected_files)):
            fig.add_trace(go.Scatter(x=timestamps[i], y=block_numbers[i], mode='lines', name=f'Log {i+1}'))

        fig.update_layout(
            title='Block Number vs. Timestamp',
            xaxis=dict(title='Timestamp'),
            yaxis=dict(title='Block Number'),
        )

        plot_div = fig.to_html(full_html=False)
        return render_template('compare.html', log_files=log_files, plot_div=plot_div)

    return render_template('compare.html', log_files=log_files)


if __name__ == '__main__':
    app.run(debug=True)
