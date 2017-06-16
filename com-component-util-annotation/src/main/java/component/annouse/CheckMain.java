package component.annouse;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangjianjun on 2017/6/16.
 * 自定义注解验证数据完整性
 */
public class CheckMain {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        TarResearch tr = new TarResearch();
        tr.setVersion("version");
//        tr.setGrade("grade");

        Class<TarResearch> tarResearchClass = TarResearch.class;
        Field[] fields = tarResearchClass.getDeclaredFields();

        for(int i=0;i<fields.length;i++){
            if (fields[i].getAnnotation(IgnoreProperty.class)!=null){
                continue;
            }

            String fie = fields[i].getName().substring(0,1).toUpperCase()
                    +fields[i].getName().substring(1);
            Method method = tarResearchClass.getMethod("get"+fie);
            Object obj = method.invoke(tr);
            if (obj == null){
                System.out.println(fields[i]+"不能为空");
            }
        }
    }

}
