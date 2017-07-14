package component.java_se.static_;

/**
 * Created by wangjianjun on 2017/7/14.
 */
public class StaticBolockTest {

    static {
        System.out.println("static");
    }

    {
        System.out.println("bolock");
    }

    public StaticBolockTest() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        new StaticBolockTest();
    }
}
