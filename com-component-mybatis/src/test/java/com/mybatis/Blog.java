package com.mybatis;

/**
 * @Author: JianJun
 * @Description:
 * @Date: Created in 15:23 2018/7/25
 * @Modify:
 * @Version:
 */
public class Blog {

    private int id;
    private String name;
    private String homeWeb;

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

    public String getHomeWeb() {
        return homeWeb;
    }

    public void setHomeWeb(String homeWeb) {
        this.homeWeb = homeWeb;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homeWeb='" + homeWeb + '\'' +
                '}';
    }
}
