package component.trans;

/**
 * Created by wangjianjun on 2017/9/14.
 */
public class StringTrans {

    public static void main(String[] args) {
        System.out.println(toBytesWithputEncoding("abcdefg"));
        System.out.println(hashCode("abcdefg"));
    }

    public static byte[] toBytesWithputEncoding(String str){

        int len = str.length();
        int pos = 0;
        byte[] buf = new byte[len<<1];
        for (int i=0;i<len;i++){
            char c = str.charAt(i);
            buf[pos++] = (byte) (c & 0xFF);
            buf[pos++] = (byte) (c >> 8);
        }

        return buf;
    }

    public static int hashCode(String str){
        return str.hashCode();
    }
}
