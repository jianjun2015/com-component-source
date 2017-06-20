package component.form2list;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class BaiscDataUtil {

    /**
     * 将页面元素自动封装成bean，而且是多个bean
     * @param request
     * @param c
     * @return
     * @throws Exception
     * @throws NoSuchFieldException
     */
    public static List<?> assembleObjectList(HttpServletRequest request, Class<?> c)
            throws Exception, NoSuchFieldException {
        Object[] objArray = null;
        //1.获取页面元素(关于这个bean的页面元素)
        Map<String, String[]> fieldValues = getFieldValues(request, c);
        List objList = null;
        if(fieldValues != null) {
            //2.获取bean的数量
            int objLength = getParameterLenth(request, c);
            objArray = new Object[objLength];
            objList = new ArrayList();
            //3.生成实例
            for(int i=0; i<objLength; i++) {
                objArray[i] = c.newInstance();
                objList.add(objArray[i]);
            }
            //为每个实例的每个元素赋值(如果页面有该参数数组)
            Iterator<String> keyIt = fieldValues.keySet().iterator();
            while(keyIt.hasNext()) {
                String fieldName = keyIt.next();
                Field field = c.getDeclaredField(fieldName); //获取参数对应的字段
                String[] fieldValue = fieldValues.get(fieldName); //获取参数数组
                if(fieldValue != null) {
                    for(int i=0; i<objArray.length; i++) { //循环：为每个对象的字段，附上参数数组的值(通过set方法)
                        //1.准备字段的Set方法
                        Method m = BeanReflectUtil.assembleSetMethod(c, field);
                        //2.页面的值(String类型)转变为该字段对应类型的值
                        Object fieldObj = BeanReflectUtil.toTypeValue(field, fieldValue[i]);
                        //3.调用Set方法
                        m.invoke(objArray[i], fieldObj); //为对象objArray[i]调用set方法，为上文中的field字段附上fieldObj这个值
                    }
                }
            }
        }

        //  return objArray;
        return objList;
    }

    /***
     * 从页面取关于这个bean的元素数组
     * 页面与类的字段名称必须一致
     * @param c 要从页面中获取哪个类的信息
     * return Map 字段名，字段值数组
     */
    public static Map<String, String[]> getFieldValues(HttpServletRequest request, Class<?> c) {
        Map<String, String[]> fieldValues = new HashMap<String, String[]>();
        //这个类有哪些属性
        String[] fieldNames = BeanReflectUtil.getDeclaredFieldNames(c);
        for(int i=0; i<fieldNames.length; i++) {
            //循环属性，获取页面相应参数数组
            String[] values = request.getParameterValues(fieldNames[i]);
            fieldValues.put(fieldNames[i], values);
        }
        return fieldValues;
    }

    /**
     * 返回潜在对象可能的个数
     * 本方法假定假设以下条件成立
     * 1.页面的参数可能不会有对象的所有属性，但至少存在1个，
     * 即Person{name, age, birthday}在页面中，至少有<input type="text" name="age" value="20" />（以文本框为例，不一定是文本框）
     * 2.在存在的前提下，不同属性的参数个数一样
     * 即<input type="text" name="age" id="age1" />  <input type="text" name="name" id="name1" />
     * <input type="text" name="age" id="age2" /> <input type="text" name="name" id="name2" />
     * 其他特殊情况恕不支持，如：
     * <input type="text" name="age" id="age1" />  <input type="text" name="name" id="name1" /> <input type="text" name="birthday" id="birthday1" />
     * <input type="text" name="age" id="age2" /> <input type="text" name="name" id="name2" /> <!--有2个age，name，却只有1个birthday-->
     * @return
     */
    public static int getParameterLenth(HttpServletRequest request, Class<?> c) {

        int parameterLenth = 0;
        String[] fieldNames = BeanReflectUtil.getDeclaredFieldNames(c);
        for(int i=0; i<fieldNames.length; i++) {
            String[] values = request.getParameterValues(fieldNames[i]);
            if(values != null) {
                parameterLenth = values.length;
                break;
            }
        }
        return parameterLenth;
    }
}
