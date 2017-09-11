package component.java_se.jdk1_8.new_features_8;

import component.java_se.jdk1_8.new_features_4.Person;

import java.util.Comparator;

/**
 * Created by wangjianjun on 2017/9/7.
 */
public class Main_6_Comparator {

    public static void main(String[] args) {
        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        int r1 = comparator.compare(p1, p2);             // > 0
        int r2 = comparator.reversed().compare(p1, p2);  // < 0

        System.out.println(r1+":"+r2);
    }
}
