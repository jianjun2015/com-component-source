package component.java_se.jdk1_8.new_features_1;

/**
 * Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法
 * Created by wangjianjun on 2017/9/7.
 */
public class MainTest {

    public static void main(String[] args) {

        InterDefaultMethod method = new InterDefaultMethod() {
            @Override
            public double calculate(int a) {
                return 0;
            }
        };

        System.out.println(method.sqrt(2));
        System.out.println(method.calculate(3));
    }
}
