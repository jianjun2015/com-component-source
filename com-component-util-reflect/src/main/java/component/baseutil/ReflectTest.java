package component.baseutil;

import component.entity.User;

import java.io.Serializable;
import java.lang.reflect.*;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class ReflectTest implements Serializable{


    private static final long serialVersionUID = -3991546804202868672L;

    //根据对象得到类名
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        try {
            func_fieldAddValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void func_(){
        ReflectTest reflectTest = new ReflectTest();
        System.out.println(reflectTest.getClass().getName());
    }

    //得到全类目
    public static void func_reflect() throws ClassNotFoundException {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;

        //一般采用这种方式
        class1 = Class.forName("component.baseutil.ReflectTest");
        class2 = new ReflectTest().getClass();
        class3 = ReflectTest.class;

        System.out.println(class1);
        System.out.println(class2);
        System.out.println(class3);
    }

    //得到对象的父类和实现的接口
    public static void func_impls() throws ClassNotFoundException {

        Class<?> clazz = Class.forName("component.baseutil.ReflectTest");

        Class<?> parentClass = clazz.getSuperclass();
        System.out.println("父类:"+parentClass);

        Class<?> intes[] = clazz.getInterfaces();
        System.out.println("实现接口:");
        for (int i=0;i<intes.length;i++){
            System.out.println((i+1)+":"+intes[i]);
        }
    }

    //得到全部构造函数
    public static void func_constructor() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class<?> clazz = Class.forName("component.entity.User");

        //第一种方法 实例化默认构造方法
        User user = (User) clazz.newInstance();
        user.setName("zhang");
        user.setAge(14);

        //第二种方法  构造器 及参数列表
        Constructor<?> cons[] = clazz.getConstructors();
        for (int i=0;i<cons.length;i++){
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.print("cons["+i+"](");
            for (int j=0;j<clazzs.length;j++){
                if (j == clazzs.length-1){
                    System.out.print(clazzs[j].getName());
                }else {
                    System.out.print(clazzs[j].getName()+",");
                }
            }
            System.out.println(")");
        }

        User user2 = (User) cons[1].newInstance("zhangs",11);
        System.out.println(user2);
    }

    /**
     * 获得全部属性
     */
    public static void func_fields() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("component.entity.User");

        //getDeclaredFields()只能获取自己声明的各种字段，包括public，protected，private。
        Field[] fields = clazz.getDeclaredFields();
        for (int i=0;i<fields.length;i++){
            //得到修饰符
            int mo = fields[i].getModifiers();
            String priv = Modifier.toString(mo);

            //属性类型
            Class<?> type = fields[i].getType();
            System.out.println(priv+" "+type.getName()+" "+fields[i].getName()+";");
        }

        System.out.println("==========实现的接口或者父类的属性==========");
        // 取得实现的接口或者父类的属性 getFields()只能获取public的字段，包括父类的
        Field[] filed1 = clazz.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + "  " + type.getName() + " " + filed1[j].getName() + ";");
        }
    }

    public static void func_method() throws ClassNotFoundException {

        Class<?> clazz = Class.forName("component.entity.User");

        Method[] methods = clazz.getMethods();

        for (int i=0;i<methods.length;++i){
            Class<?> returnType = methods[i].getReturnType();
            Class<?> para[] = methods[i].getParameterTypes();
            int temp = methods[i].getModifiers();

            System.out.print(Modifier.toString(temp)+" ");
            System.out.print(returnType.getName()+" ");
            System.out.print(methods[i].getName()+" ");
            System.out.print("(");
            for (int j=0;j<para.length;++j){
                System.out.print(para[j].getName()+" "+"arg"+j);
                if (j<para.length-1){
                    System.out.print(",");
                }
            }

            Class<?> exec[] = methods[i].getExceptionTypes();
            if (exec.length>0){
                System.out.print(") throws ");
                for (int k=0;k<exec.length;++k){
                    System.out.print(exec[k].getName()+" ");
                    if (k<exec.length-1)
                        System.out.print(",");
                }
            }else {
                System.out.print(")");
            }
            System.out.println();
        }
    }

    //通过反射调用类的方法
    public static void func_execMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class<?> clazz = Class.forName("component.entity.User");

        Method method = clazz.getMethod("func");
        method.invoke(clazz.newInstance());

        method = clazz.getMethod("func_",String.class);
        method.invoke(clazz.newInstance(),"zhang");
    }


    //通过反射给属性设值 private也可以
    public static void func_fieldAddValue() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> clazz = Class.forName("component.entity.User");

        Object object = clazz.newInstance();
        User user = (User) object;//可以进行强转
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);//当类中的成员变量为private时 必须设置此项

        field.set(object,"java反射机制");
        System.out.println(field.get(object));
    }
}
