package first.method;

import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * Created by wangjianjun on 2017/8/2.
 */
public class ServiceClient {

    public static void main(String[] args) throws ServiceException, RemoteException, DocumentException {

        String endpoint = "http://localhost:9000/HelloWorld?wsdl";

        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(endpoint);

//        String result = funHelloWorld(call);
//        String result = funHelloWorld2(call);
        String result = funCalc(call);

        // 给方法传递参数，并且调用方法
        System.out.println(result);

//        Document document = DocumentHelper.parseText(result);
//        Element root = document.getRootElement();
//        System.out.println("name:"+root.elements());

    }

    private static String funHelloWorld(Call call) throws RemoteException {
        call.setOperationName(new QName("http://example/","sayHelloWorldFrom"));// WSDL里面描述的接口名称
        call.addParameter("arg0", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数 备注：arg0 不能写对应的参数名称
        call.setReturnType(XMLType.XSD_STRING);
        String result = (String) call.invoke(new Object[]{"XX"});
        return result;
    }

    private static String funHelloWorld2(Call call) throws RemoteException {
        call.setOperationName(new QName("http://example/","sayHelloWorldFroms"));// WSDL里面描述的接口名称
        call.addParameter("arg0", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数 备注：arg0 不能写对应的参数名称
        call.addParameter("arg1", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数 备注：arg0 不能写对应的参数名称
        call.setReturnType(XMLType.XSD_STRING);
        String result = (String) call.invoke(new Object[]{"XX","YY"});
        return result;
    }

    //传输int、Integer类型会出现结果为 -- 0
    private static String funCalc(Call call) throws RemoteException {
        call.setOperationName(new QName("http://example/","calc"));// WSDL里面描述的接口名称
        call.addParameter("arg0", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数 备注：arg0 不能写对应的参数名称
        call.addParameter("arg1", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数 备注：arg0 不能写对应的参数名称
        call.setReturnType(XMLType.XSD_STRING);
        String result = (String) call.invoke(new Object[]{"3","2"});
        return result;
    }
}
