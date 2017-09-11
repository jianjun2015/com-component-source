package component.java_se.jdk1_8.new_features_8;

import java.util.function.Function;

/**
 * Created by wangjianjun on 2017/9/7.
 */
public class Main_3_Function {

    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("123"));     // "123"
    }
}
