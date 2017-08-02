备注：这里使用的cas-server-webapp-4.2.7.war
修改对应的端口号
修改 D:\software\apache-tomcat-8.5.4\webapps\cas\WEB-INF\classes\services\HTTPSandIMAPS-10000001.json 加上http即可通过http访问(也可以直接配置https)
修改 D:\software\apache-tomcat-8.5.4\webapps\cas\WEB-INF\cas.propertise 文件对应的端口号为可tomcat访问端口号
启动tomcat  则认证中心搭建完成

如果配置数据库验证，则需要添加对应jar:
    cas-server-support-jdbc-4.2.7.jar(注意版本)
    mysql-connector-Java-5.1.38.jar

    修改WEB-INF/deployerConfigContext.xml
        <!--<alias name="acceptUsersAuthenticationHandler" alias="primaryAuthenticationHandler" /> -->
            <bean id="dataSource"
              class="com.mchange.v2.c3p0.ComboPooledDataSource"
              p:driverClass="com.mysql.jdbc.Driver"
              p:jdbcUrl="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull"
              p:user="root"
              p:password="root"
              p:initialPoolSize="6"
              p:minPoolSize="6"
              p:maxPoolSize="18"
              p:maxIdleTimeExcessConnections="120"
              p:checkoutTimeout="10000"
              p:acquireIncrement="6"
              p:acquireRetryAttempts="5"
              p:acquireRetryDelay="2000"
              p:idleConnectionTestPeriod="30"
              p:preferredTestQuery="select 1" />
            <alias name="queryDatabaseAuthenticationHandler" alias="primaryAuthenticationHandler" />
            <alias name="dataSource" alias="queryDatabaseDataSource" />

C:\Windows\System32\drivers\etc\hosts 在文件末端添加下面三条信息：

127.0.0.1 sso.jianjun.com
127.0.0.1 client1.jianjun.com
127.0.0.1 client2.jianjun.com

安全证书配置：
1、打开cmd命令窗口
2、生成证书，在cmd窗口输入以下命令：
keytool -genkey -alias ssodemo -keyalg RSA -keysize 1024 -keypass zhoubang -validity 365 -keystore c:\zhoubang.keystore -storepass zhoubang
    【说明】：-alias后面的别名可以自定义，-keypass指定证书密钥库的密码, -storepass和前面keypass密码相同,否则下面tomcat 配置https 会访问失败 -keystore指定证书的位置,这里指定放在c盘根目录,密钥库名称可以自定义，这里是zhoubang.keystore
3. 命令输入完成，回车之后，会提示你输入一些资料
    【注意】：第一个让你输入的“您的名字与姓氏是什么”，请必须输入在C:\Windows\System32\drivers\etc\hosts文件中加入的服务端的域名。
我这里也就是server.zhoubang85.com，为何这么做？
首先cas只能通过域名来访问，不能通过ip访问，同时上方是生成证书，所以要求比较严格，所以如果不这么做的话，及时最终按照教程配置完成，cas也可以正常访问,访问一个客户端应用虽然能进入cas验证首页，但是，当输入信息正确后，cas在回调转入你想访问的客户端应用的时候，会出现No subject alternative names present错误异常信息，这个错误也就是在上面输入的第一个问题答案不是域名导致、或者与hosts文件配置的不一致导致。
4.导出证书：
  在cmd窗口继续输入以下命令，导出证书:
keytool -export -alias ssodemo -keystore c:\zhoubang.keystore -file c:\ssodemo.crt -storepass zhoubang
    【说明】：-alias后面的名称要与生成证书的命令里面的alias的名称一致. –keystore后面指定证书存放的位置，这里我放在C盘根目录，同时证书名称要与【生成证书】对应的命令里的keystore名称一致.这里是zhoubang.keystore，-file后面才crt路径，我也指定在c盘根目录. –storepass的证书密码要与上面输入的密码一致.
我们再看看c盘下面是否生成crt文件:
5.客户端导入证书
    在cmd窗口输入命令:
keytool -import -keystore %JAVA_HOME%\jre\lib\security\cacerts -file c:\ ssodemo.crt -alias ssodemo
【说明】：-file指定证书的位置，也就是上一步导出证书的位置，即c:\ ssodemo.crt 命令中指定了JAVA_HOME，意思是将证书导入到客户端证书库，也就是jdk证书库中.因为客户端应用运行在本地，需要jdk的支持。
回车之后，会让你输入密钥库口令，注意，这里的密码必须要输入changeit，不能输入上面指定的密码zhoubang，切记，否则导入客户端证书会有问题，如果是多台机器演示，需要在每一台客户端导入该证书，步骤都是一样的。当看到提示“是否信任此证书”，输入y回车即可，见下图：(说明，命令中的-alias后面的别名可以自定义,如果出现【证书未导入，别名<***>已经存在】的错误，该意思是说客户端的密钥库中已经存在该别名证书了，重新指定其他别名即可.)





至此，CAS所需的证书环境，已经配置好。