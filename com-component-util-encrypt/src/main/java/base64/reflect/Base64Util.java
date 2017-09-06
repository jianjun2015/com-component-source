package base64.reflect;

import java.lang.reflect.Method;

/**
 * Created by wangjianjun on 2017/9/6.
 */
public class Base64Util {

    public static String encodeBase64(byte[] input) throws Exception{
        Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method method = clazz.getMethod("encode",byte[].class);
        method.setAccessible(true);
        Object retObj = method.invoke(null,new Object[]{input});
        return (String) retObj;
    }

    public static byte[] decodeBase64(String input) throws Exception{
        Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method method = clazz.getMethod("decode",String.class);
        method.setAccessible(true);
        Object retObj = method.invoke(null,input);
        return (byte[]) retObj;
    }

    public static void main(String[] args) throws Exception {
        String str = "abcdefg123     cd .,lclkdc";
        String strBase64 = encodeBase64(str.getBytes());
        byte[] result = decodeBase64(strBase64);
        String retStr = new String(result);

        System.out.println(strBase64);
        System.out.println(retStr);
    }
}
