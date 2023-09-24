
## 前端运行

```bash
# 进入项目目录（vscode进入项目目录）
cd vue

# 安装依赖(node.js推荐用16.12.0，确保所有依赖按照成功)
npm install

# 更改后端接口地址
文件vue.config.js中的devServer中的target要根据后端具体ip地址和端口进行修改

# 启动服务
npm run dev --port = 8888
```

浏览器访问 [http://localhost:8888](http://localhost:8888)

- 登录界面可以直接登录即可
- 登录界面之后就是Home界面
- 在保证后端程序接口正常运行情况下，从导航栏进入Upload分别上传三个文件之后
- 即可从导航栏分别进入Map Area 和 Indicator Area即可显示出具体结果
