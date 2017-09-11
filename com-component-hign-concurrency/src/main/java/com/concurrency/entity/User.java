package com.concurrency.entity;

import java.util.Date;

/**
 * Created by wangjianjun on 2017/7/7.
 */
public class User {

    private Integer userId;
    private String userName;
    private Integer userAge;
    private Date userBirthday;
    private Double userSalary;

    public User() {
    }

    public User(String userName, Date userBirthday, Double userSalary) {
        this.userName = userName;
        this.userBirthday = userBirthday;
        this.userSalary = userSalary;
    }

    public User(Integer userId, String userName, Date userBirthday, Double userSalary) {
        this.userId = userId;
        this.userName = userName;
        this.userBirthday = userBirthday;
        this.userSalary = userSalary;
    }

    public User(String userName, Integer userAge, Date userBirthday, Double userSalary) {
        this.userName = userName;
        this.userAge = userAge;
        this.userBirthday = userBirthday;
        this.userSalary = userSalary;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Double getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(Double userSalary) {
        this.userSalary = userSalary;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userBirthday=" + userBirthday +
                ", userSalary=" + userSalary +
                '}';
    }
}
