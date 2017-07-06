package component.module.mybatis.entity;

/**
 * Created by wangjianjun on 2017/7/6.
 */
public class Teacher {

    private int id;
    private String name;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
