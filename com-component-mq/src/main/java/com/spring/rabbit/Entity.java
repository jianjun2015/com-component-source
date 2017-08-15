package com.spring.rabbit;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangjianjun on 2017/8/15.
 */
public class Entity implements Serializable {
    private static final long serialVersionUID = -1077533746391198188L;

    private Long id;
    private String spitter;
    private String message;
    private Date postedTime;

    public Entity(Long id, String spitter, String message, Date postedTime) {
        this.id = id;
        this.spitter = spitter;
        this.message = message;
        this.postedTime = postedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpitter() {
        return spitter;
    }

    public void setSpitter(String spitter) {
        this.spitter = spitter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(Date postedTime) {
        this.postedTime = postedTime;
    }
}
