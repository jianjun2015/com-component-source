package component.java_se.jdk1_8.new_features_8;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by wangjianjun on 2017/9/7.
 */
public class Main_2_Predicate {

    public static void main(String[] args) {

        Predicate<String> predicate = (S)->S.length()>0;

        System.out.println(predicate.test("too"));//正常判断
        System.out.println(predicate.negate().test("too"));//取正常判断的相反

        Predicate<Boolean> nonNull = Objects::nonNull;
        System.out.println(nonNull.test(null));
        System.out.println(nonNull.test(true));
        System.out.println(nonNull.test(false));

        Predicate<Boolean> isNUll = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(isNotEmpty.test("oo"));
    }
}
