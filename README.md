# springboot-RabbitMQ
spingboot-RabbitMQ的使用和说明
## windows下安装rabbitamqp的说明
> * 官方说明地址 http://www.rabbitmq.com/install-windows.html
1. 安装Erlang  下载地址http://www.erlang.org/downloads
> **注意**：必须使用管理帐户运行Erlang安装程序，否则RabbitMQ安装程序所需的注册表项将不存在
2. 安装RabbitMQ 下载地址http://www.rabbitmq.com/download.html或着http://www.rabbitmq.com/install-windows.html
3. RabbitMQ安装完以后，以管理员身份运行CMD 进入RabbitMQ目录**C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.12\sbin**
运行如下命令,主要是为了安装在服务中
```text
1. rabbitmq-plugins.bat enable rabbitmq_management 
2. rabbitmq-service.bat start
```
4. 地址栏输入localhost:15672成功进入管理界面。
> 用户名和密码都是guest