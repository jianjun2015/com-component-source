package component.entity;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class User extends Base {

    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void func(){
        System.out.println("exec func");
    }

    public void func_(String str){
        System.out.println("exec func:"+str);
    }
}
