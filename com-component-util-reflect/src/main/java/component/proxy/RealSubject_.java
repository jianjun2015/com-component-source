package component.proxy;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class RealSubject_ implements Subject {

    @Override
    public String say(String name, int age) {
        return name + " and "+ age;
    }
}
