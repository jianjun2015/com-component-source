package base64.codec;

import org.apache.commons.codec.binary.Base64;

/**
 * 推荐实现
 * Created by wangjianjun on 2017/9/6.
 */
public class Base64Util {

    public static byte[] decode(final byte[] bytes){
        return Base64.decodeBase64(bytes);
    }

    public static String encode(final byte[] bytes){
        return new String(Base64.encodeBase64(bytes));
    }

    public static void main(String[] args) {
        String str = "abcdefg123     cd .,lclkdc";
        String strBase64 = encode(str.getBytes());
        byte[] result = decode(strBase64.getBytes());
        String retStr = new String(result);

        System.out.println(strBase64);
        System.out.println(retStr);
    }
}
