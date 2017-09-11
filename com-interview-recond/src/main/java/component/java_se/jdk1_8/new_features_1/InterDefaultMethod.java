package component.java_se.jdk1_8.new_features_1;

/**
 * Created by wangjianjun on 2017/9/7.
 */
public interface InterDefaultMethod {

    double calculate(int a);
    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
