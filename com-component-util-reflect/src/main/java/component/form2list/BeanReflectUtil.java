package component.form2list;

import component.string.StringsUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class BeanReflectUtil {

    /**
     * set 方法
     * @param c
     * @param field
     * @return
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
    public static Method assembleSetMethod(Class<?> c, Field field)
            throws SecurityException, NoSuchMethodException {
        String methodName = "set" + StringsUtil.upperFirst(field.getName());
        Class<?>[] parameterClasses = new Class[]{field.getType()}; // Tell the Java  set Method parameter types
        return c.getDeclaredMethod(methodName, parameterClasses);
    }

    public final static Map<String, String> toTypeMethods;
    static {
        //支持的转换类型：暂时为boolean,byte,char,int,long,float,double及他们的包装类 + String,java.util.Date,BigDecimal这几种类型
        toTypeMethods = new HashMap<String, String>();
        toTypeMethods.put("boolean", "toBoolean");
        toTypeMethods.put("byte", "toByte");
        toTypeMethods.put("char", "toString");
        toTypeMethods.put("character", "toString");
        toTypeMethods.put("string", "toString");
        toTypeMethods.put("int", "toInteger");
        toTypeMethods.put("integer", "toInteger");
        toTypeMethods.put("long", "toLong");
        toTypeMethods.put("float", "toFloat");
        toTypeMethods.put("double", "toDouble");
        toTypeMethods.put("date", "toDate");
        toTypeMethods.put("bigdecimal", "toBigDecimal");
    }

    /**
     * 这个方法的作用是：告诉我对象的属性、字符串，
     * 这样我就可以将字符串转化成属性对应的数据类型的值了。
     * 例如：在类中Person的birthday定义为Date，
     * 我就会把"2010-10-01"转为整形的Date类型的2010-10-01
     * 如果你把birthday定义为int，并传入了"2010-10-01"，我的转换方法会返回null，
     * 你也可以抛出异常，这个关键是看转换的方法实现，你可以按自己的要求更改
     * @param field 对象的属性
     * @param string 页面的参数
     */
    public static Object toTypeValue(Field field, String string)
            throws Exception{
        String fieldTypename = field.getType().getSimpleName(); //属性的类型(不包含报名)
        //通过属性的类型，从map中找到要调用的方法的名字，这些方法是将一个String的值转化成我们需要的数据类型的值
        String methodName = toTypeMethods.get(fieldTypename.toLowerCase());
        //获取方法
        Method method =
                BeanReflectUtil.class.
                        getDeclaredMethod(methodName, string.getClass());
        //调用方法，返回属性类型的值
        return method.invoke(null, string); //如果底层方法是静态的，那么可以忽略指定的 obj 参数。该参数可以为 null。
    }

    //下面这些小方法是为了将一个String的值转化成我们需要的数据类型的值
    @SuppressWarnings("unused")
    private static Boolean toBoolean(final String s) {
        return NumberUtil.toBoolean(s, true);
    }
    @SuppressWarnings("unused")
    private static Byte toByte(final String s) {
        return NumberUtil.toByte(s, (byte)0);
    }

    @SuppressWarnings("unused")
    private static String toString(final String s) {
        return s;
    }

    @SuppressWarnings("unused")
    private static Integer toInteger(final String s) {
        return NumberUtil.toInt(s, 0);
    }
    @SuppressWarnings("unused")
    private static Long toLong(final String s) {
        return NumberUtil.toLong(s, 0l);
    }
    @SuppressWarnings("unused")
    private static Float toFloat(String s) {
        return NumberUtil.toFloat(s, (float)0);
    }
    @SuppressWarnings("unused")
    private static Double toDouble(String s) {
        return NumberUtil.toDouble(s, 0.0);
    }
    @SuppressWarnings("unused")
    private static Date toDate(String s) { //支持部分日期格式
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
        } catch(Exception e1) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(s);
            }catch(Exception e2) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd").parse(s);
                } catch (Exception e3) {
                    return null;
                }
            }
        }
    }


    /**
     * 获取类中所以属性名称
     * @param c
     * @return
     */
    public static String[] getDeclaredFieldNames(Class<?> c) {

        Field[] fields=c.getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }
}
