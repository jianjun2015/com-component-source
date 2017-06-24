package component.hibernate.entity;

import java.util.Date;

/**
 * Created by wangjianjun on 2017/6/21.
 */
public class Dbuser {

    private Integer userId;
    private String username;
    private String createBy;
    private Date createDate;

    public Dbuser() {
    }

    public Dbuser(Integer userId) {
        this.userId = userId;
    }

    public Dbuser(Integer userId, String username, String createBy, Date createDate) {
        this.userId = userId;
        this.username = username;
        this.createBy = createBy;
        this.createDate = createDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Dbuser{" +
                "createDate=" + createDate +
                ", createBy='" + createBy + '\'' +
                ", username='" + username + '\'' +
                ", userId=" + userId +
                '}';
    }
}
