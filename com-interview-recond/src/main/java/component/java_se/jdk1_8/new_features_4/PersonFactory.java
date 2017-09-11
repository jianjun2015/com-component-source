package component.java_se.jdk1_8.new_features_4;

/**
 * Created by wangjianjun on 2017/9/7.
 */
public interface PersonFactory<P extends Person> {

    P create(String firstName,String lastName);
}
