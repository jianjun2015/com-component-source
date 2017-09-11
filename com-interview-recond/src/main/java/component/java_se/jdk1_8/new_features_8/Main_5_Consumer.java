package component.java_se.jdk1_8.new_features_8;

import component.java_se.jdk1_8.new_features_4.Person;

import java.util.function.Consumer;

/**
 * Created by wangjianjun on 2017/9/7.
 */
public class Main_5_Consumer {

    public static void main(String[] args) {
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));
    }
}
