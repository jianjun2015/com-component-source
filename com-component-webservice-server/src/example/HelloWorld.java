package example;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by wangjianjun on 2017/8/1.
 */
@WebService()
public class HelloWorld {
  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }

  @WebMethod
  public String sayHelloWorldFroms(String from,String from2) {
    String result = "Hello, world, from " + from+","+from2;
    System.out.println(result);
    return result;
  }

  @WebMethod
  public String calc(String num1,String num2) {
    System.out.println(num1);
    System.out.println(num2);

    String result = "计算: " + (Integer.parseInt(num1)+Integer.parseInt(num2));
    System.out.println(result);
    return result;
  }
  public static void main(String[] argv) {
    Object implementor = new HelloWorld ();
    String address = "http://localhost:9000/HelloWorld";
    Endpoint.publish(address, implementor);
  }
}
