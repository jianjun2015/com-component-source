package component.string;

import java.lang.reflect.Field;

/**
 * Created by wangjianjun on 2017/8/16.
 */
public class StringBufBui{

    public static void main(String[] args) {
        try {
            funChangeStr();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        funStringBuffer();
        funStringBuilder();
    }

    private static void funChangeStr() throws NoSuchFieldException, IllegalAccessException {

        String str = "hello world";

        //通过反射来改变  获取string对象的value --参数必须为value
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);//修改权限

        char[] valueQ = (char[]) field.get(str);
        valueQ[6] = 'n';
        valueQ[7] = 'n';
        valueQ[8] = 'n';
        valueQ[9] = 'n';
        valueQ[10] = 'n';

        System.out.println("经过反射修改:"+str);
    }

    /**
     * 方法原型带有synchronized，则表示线程安全
     */
    private static void funStringBuffer(){
        StringBuffer sb = new StringBuffer();

        sb.append(111);

        System.out.println(sb.toString());
    }

    /**
     * 方法原型没有synchronized，则表示线程不安全
     */
    private static void funStringBuilder(){

        StringBuilder sbd = new StringBuilder();

        sbd.append(111);

        System.out.println(sbd.toString());
    }
}
