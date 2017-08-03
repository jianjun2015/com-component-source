package com.base.util.entity;

/**
 * Created by houjun on 2016-5-10.
 */
public class Entity implements HasId {

    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
