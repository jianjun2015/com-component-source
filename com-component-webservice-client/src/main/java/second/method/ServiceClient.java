package second.method;

/**
 * Service编程实现服务端调用
 * Created by wangjianjun on 2017/8/1.
 */
public class ServiceClient {

    public static void main(String[] args) throws Exception {

        HelloWorldService service = new HelloWorldService();
        HelloWorld helloWorld = service.getHelloWorldPort();
        String result = helloWorld.sayHelloWorldFrom("zhangsan");
        System.out.println(result);
    }
}
