package component.java_se.jdk1_8.new_features_8;

import java.util.Optional;

/**
 * Created by wangjianjun on 2017/9/7.
 */
public class Main_7_Optional {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");
        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }
}
