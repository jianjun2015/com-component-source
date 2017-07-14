package component.java_se.static_;

/**
 * Created by wangjianjun on 2017/7/14.
 */
public class staticTest {

    public static void main(String[] args) {

        new CT();
        new CT();
        new CT();
        new CT();
        new CT();
        new CT();
    }
}

class CT{
    public static int count = 1;

    public CT() {
        System.out.println("count:"+count++);
    }
}
