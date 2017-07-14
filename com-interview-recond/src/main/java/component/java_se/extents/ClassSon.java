package component.java_se.extents;

/**
 * Created by wangjianjun on 2017/7/14.
 */
public class ClassSon extends ClassParent {

    static {
        System.out.println("ClassSon static");
    }

    public ClassSon() {
        System.out.println("ClassSon");
    }
}
