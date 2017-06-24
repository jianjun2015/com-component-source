package component.hibernate.entity;

/**
 * Created by wangjianjun on 2017/6/21.
 */
public class Student {

    private Integer stuId;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStuId() {

        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }
}
