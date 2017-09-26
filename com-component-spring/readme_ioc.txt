1 bean常见的配置项，如下：
    Id
    Class
    Scope
    Constructor arguments
    Properties
    Autowiring mode
    lazy-initialization mode
    Initialization/destruction method

2 bean的作用域
    singleton: 单列
    prototype每次使用都会创建新实例
    request :每次http请求创建一个实例，仅在当前　request有效
    session ： 当前session有效

3 bean的自动装配（Autowiring）

  No: 不做任何操作
  byname:根据属性名自动装配
  byType:如果容器存在一个与指定类型相同的bean，则自动装配，如果存在多个，则抛出异常。
  constructor:与 byType类似，不同之处它在于构造器的参数。

4 注解
  @Configuration
  @Bean
  @Import
  @DependsOn

  @Component 是一个通用注解，应用于任何bean
  @Reposity注解DAO
  @Service注解service
  @Controller注解controller

5 Autowired
  @Autowired可以用于setter方法上
  可以用于成员变量
  可以用于构造器

