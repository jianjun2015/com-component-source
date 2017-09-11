package component.java_se.jdk1_8.new_features_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wangjianjun on 2017/9/7.
 */
public class LambdaExpression {

    public static void main(String[] args) {

        //jdk1.8-
        List<String> names = Arrays.asList("peter","anna","mike","xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(names);

        //jdk1.8+
        List<String> names1 = Arrays.asList("peter","anna","mike","xenia");
        Collections.sort(names1,(String a,String b)->{
            return b.compareTo(a);
        });
        System.out.println(names1);

        //jdk1.8+ 简洁写法
        List<String> names2 = Arrays.asList("peter","anna","mike","xenia");
        Collections.sort(names2,(String a,String b)->(b.compareTo(a)));
        System.out.println(names2);

        //jdk1.8+ 简洁写法-Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型
        List<String> names3 = Arrays.asList("peter","anna","mike","xenia");
        Collections.sort(names3,(a,b)->(b.compareTo(a)));
        System.out.println(names3);
    }
}
