package component.hibernate.entity;

import java.util.List;

/**
 * Created by wangjianjun on 2017/6/21.
 */
public class Class {

    private Integer classId;
    private String name;
    private List<Student> students;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
