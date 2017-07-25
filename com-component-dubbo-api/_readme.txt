首先搭建zk集群环境
然后配置dubbo-admin管理页面
之后再搭建dubbo 的provider和consume，需要配置注册到zk的service
测试：启动provider之后，再运行consume测试案例，可以在dubbo-admin实时看到当前已经注册的service提供和消费情况

如果配置时使用类组，则需要将dubbo-admin配置如下：
dubbo.registry.address=zookeeper://192.168.66.129:2181
dubbo.registry.group=DemoDGroup
dubbo.admin.root.password=root
dubbo.admin.guest.password=guest