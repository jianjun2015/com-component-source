package component.java_se.jdk1_8.new_features_4;

/**
 * 方法与构造函数引用
 * Created by wangjianjun on 2017/9/7.
 */
public class Main {

    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("peter","pek");
        System.out.println(person);
    }
}
