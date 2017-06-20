package component.proxy;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class TestReflect {

    public static void main(String[] args) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        Subject subject = (Subject) myInvocationHandler.bind(new RealSubject_());
        String info = subject.say("Rollen",20);

        System.out.println(info);
    }
}
