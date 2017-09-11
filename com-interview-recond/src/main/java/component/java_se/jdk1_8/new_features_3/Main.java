package component.java_se.jdk1_8.new_features_3;

/**
 * Created by wangjianjun on 2017/9/7.
 */
public class Main {

    public static void main(String[] args) {
//        FunctionInterfaceClass<String,Integer> convert = (from) -> Integer.valueOf(from);
        FunctionInterfaceClass<String,Integer> convert = Integer::valueOf;
        Integer converted = convert.convert("123");
        System.out.println(converted);

    }

}
