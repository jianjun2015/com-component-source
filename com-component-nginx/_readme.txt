1、下载nginx安装包，安装
2、修改对应的配置文件，配置服务器容器地址(多机器)
3、nginx启动：start nginx
4、修改配置不需要停止nginx，只需要重新加载即可
    nginx -s reload

nginx 服务器重启命令，关闭
nginx -s reload  ：修改配置后重新加载生效
nginx -s reopen  ：重新打开日志文件
nginx -t -c /path/to/nginx.conf 测试nginx配置文件是否正确

关闭nginx：
nginx -s stop  :快速停止nginx
         quit  ：完整有序的停止nginx

其他的停止nginx 方式：

ps -ef | grep nginx

kill -QUIT 主进程号     ：从容停止Nginx
kill -TERM 主进程号     ：快速停止Nginx
pkill -9 nginx          ：强制停止Nginx



启动nginx:
nginx -c /path/to/nginx.conf