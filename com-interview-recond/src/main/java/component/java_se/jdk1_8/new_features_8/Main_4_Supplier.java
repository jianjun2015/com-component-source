package component.java_se.jdk1_8.new_features_8;

import component.java_se.jdk1_8.new_features_4.Person;

import java.util.function.Supplier;

/**
 * Created by wangjianjun on 2017/9/7.
 */
public class Main_4_Supplier {

    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;
        Person person = personSupplier.get();
        System.out.println(person);   // new Person
    }
}
