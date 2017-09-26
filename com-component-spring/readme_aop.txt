AOP中的概念通知、切点、切面
1、为什么要用AOP
1）就是为了方便，看一个国外很有名的大师说，编程的人都是“懒人”，因为他把自己做的事情都让程序去做了。用了AOP能让你少写很多代码，这点就够充分了吧。
2）就是为了更清晰的逻辑，可以让你的业务逻辑去关注自己本身的业务，而不去想一些其他的事情。这些其他的事情包括：安全，事物，日志等等。
2、那些AOP术语
        初看这么多术语，一下子都不好接受，慢慢来，很快就会搞懂。
        通知、增强处理（Advice） 就是你想要的功能，也就是上说的安全、事物、日子等。你给先定义好，然后再想用的地方用一下。包含Aspect的一段处理代码
        连接点（JoinPoint） 这个就更好解释了，就是spring允许你是通知（Advice）的地方，那可就真多了，基本每个方法的钱、后（两者都有也行），或抛出异常是时都可以是连接点，spring只支持方法连接点。其他如AspectJ还可以让你在构造器或属性注入时都行，不过那不是咱们关注的，只要记住，和方法有关的前前后后都是连接点。
        切入点（Pointcut） 上面说的连接点的基础上，来定义切入点，你的一个类里，有15个方法，那就有十几个连接点了对吧，但是你并不想在所有方法附件都使用通知（使用叫织入，下面再说），你只是想让其中几个，在调用这几个方法之前、之后或者抛出异常时干点什么，那么就用切入点来定义这几个方法，让切点来筛选连接点，选中那几个你想要的方法。
        切面（Aspect） 切面是通知和切入点的结合。现在发现了吧，没连接点什么事，链接点就是为了让你好理解切点搞出来的，明白这个概念就行了。通知说明了干什么和什么时候干（什么时候通过方法名中的befor，after，around等就能知道），二切入点说明了在哪干（指定到底是哪个方法），这就是一个完整的切面定义。
        引入（introduction） 允许我们向现有的类添加新方法属性。这不就是把切面（也就是新方法属性：通知定义的）用到目标类中吗
        目标（target） 引入中所提到的目标类，也就是要被通知的对象，也就是真正的业务逻辑，他可以在毫不知情的情况下，被咋们织入切面。二自己专注于业务本身的逻辑。
        代理（proxy） 怎么实现整套AOP机制的，都是通过代理，这个一会儿给细说。
        织入（weaving） 把切面应用到目标对象来创建新的代理对象的过程。有三种方式，spring采用的是运行时，为什么是运行时，在上一文《Spring AOP开发漫谈之初探AOP及AspectJ的用法》中第二个标提到。
        目标对象 – 项目原始的Java组件。
        AOP代理  – 由AOP框架生成java对象。
        AOP代理方法 = advice +　目标对象的方法。
3.看一段代码：
@Aspect //声明切面，标记类
public class Audience {

    @Pointcut("execution(* *.perform(..))") //定义切点，标记方法
    public void performance() {}

    @Before("performance()")  //切点之前执行
    public ....

    @AfterReturning("performance()")  //切点之后执行
    public ...

    @AfterThrowing("performance()")  //切点抛出异常后执行
    public ...
}

<aop:config>
<aop:aspect ref="audience">  //切面代码Bean，标记类
<aop:pointcut id="performance" expression="excution(* *.performance(..))"  />   //定义切点，标记方法

<aop:before  method="..."  pointcut-ref="performance" />  //前后通知babalalal
<aop:after-returnning  method="..."  pointcut-ref="performance" />
<aop:after-throwing  method="..."  pointcut-ref="performance" />

</aop:aspect>
</aop:config>

4.主要功能：
  日志记录
  性能统计
  安全控制
  事物处理
  异常处理

5.advice类型：
  前置通知(before advice)
  返回后通知(after returning advice)
  抛出异常后通知(after throwing advice)
  后通知(after advice)
  环绕通知(around advice)
