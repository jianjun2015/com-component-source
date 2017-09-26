http://blog.csdn.net/forezp/article/details/61472644

linux常见命令
1 命令的基本格式
    [root@localhost~]
    root为用户名
    ～表示当前所在位置
    localhost主机名
    ‘#’超级用户
    ‘$” 普通用户

2 查询目录的内容
    ls [选项][文件或目录]
    选项：
    -a 所有文件
    -l 查看详情
    -d查看目录属性
    -h显示文件大小

3 文件处理命令
    建立目录
        mkdir -p [目录名]
        -p表述递归建文件夹
    切换目录
        cd [目录]
        简化操作：
        cd~ 进入当前用户目录
        cd- 上次目录
        cd.. 进入上一级目录
        pwd查看当前目录所在位置
    删除目录
        rmdir [目录]
        rm -rf [目录]
    复制目录
        cp[选项][原文件目录][目标目录]
        选项：
        -r复制目录
        -p连文件属性一起复制
        -a 相当于-pdr
    剪切、改名
        mv[原文件目录][目标文件目录]
    常见目录作用
        / 根目录
        /bin 命令保存目录
        /boot 启动目录
        /dev 设备文件命令
        /etc 配置文件保存目录
        /home 家目录
        /lib 系统库保存命令
        /mnt 系统挂载目录

4 文件搜索命令
    locate
        locate [文件名]
    命令搜索
        whereis [选项] [命令名]
        或者
        which [选项][命令名]
        选项：
        -b 只查找可执行文件
        -m 只查找帮助文件
    文件搜索
        find [搜索范围][选项][条件]
            find  /  -name install.log       在根目录下查找名为install.log文件
            find /root  -inname install.log            忽略大小写查找文件
            find /var/log -mtime +10
                其中-mtime 文件修改时间
                -atime 文件访问时间
                -ctime 改变文件属性时间
                +10 10天前
                10  10天
                -10 10天内
            find /etc -size +20M            查找文件大于20M的文件
5 压缩与解压缩命令
    zip格式
        //压缩文件
        zip [压缩文件名][原文件]
        //压缩目录
        zip -r  [压缩文件名][原文件]
        #解压：
        unzip [压缩文件名]
    gz格式
        # 压缩为gz格式，原文件不保留
        gzip [原文件]
        #压缩.gz格式，原文件保留
        gzip -c 原文件 > 压缩文件
        # 压缩目录：
        gzip -r  目录
        解压：
        guzip [文件]
        guzip -r [目录]
    tar
        # 打包
        tar -cvf  打包文件名 原文件
        # 解压
        tar -xvf jp.tar
    tar.gz
        #打包
        tar -zcvf 压缩包名.tar.gz  原文件
        #解压
        tar -zxvf  压缩包名.tar.gz
6 查看用户信息
  w
  who
  last
  lastlog

7 输出重定向

  命令>文件   以覆盖的方式，把正确的命令输出到指定文件
  命令>>文件  以追加的方式，把正确的命令输出到指定文件、
  错误命令 2> 文件  以覆盖的方式把错误的命令覆盖到指定文件
  错误命令 2>> 文件  以追击的方式把错误的命令覆盖到指定文件

   命令>>文件 2>&1  同时追加正确命令和错误命令到 指定文件
  命令 >>文件1 2>>文件2   把正确的命令输出到文件1错误的文件2