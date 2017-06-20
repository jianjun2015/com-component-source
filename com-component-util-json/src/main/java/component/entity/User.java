package component.entity;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class User {
    private String name;
    private Integer age;
    private String addr;
    private Integer grade;

    public User() {
    }

    public User(String name, Integer age, String addr, Integer grade) {
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.grade = grade;
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

    public Integer getAge() {
        return age;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getAddr() {
        return addr;
    }

    public Integer getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", grade=" + grade +
                '}';
    }
}
