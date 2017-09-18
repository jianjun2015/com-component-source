package component.protostuff.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjianjun on 2017/9/18.
 */
public class User {

    private String name;
    private int age;
    private List<Integer> listInt;
    private Map<String,String> mapStr;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, List<Integer> listInt, Map<String, String> mapStr) {
        this.name = name;
        this.age = age;
        this.listInt = listInt;
        this.mapStr = mapStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getListInt() {
        return listInt;
    }

    public void setListInt(List<Integer> listInt) {
        this.listInt = listInt;
    }

    public Map<String, String> getMapStr() {
        return mapStr;
    }

    public void setMapStr(Map<String, String> mapStr) {
        this.mapStr = mapStr;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", listInt=" + listInt +
                ", mapStr=" + mapStr +
                '}';
    }
}
