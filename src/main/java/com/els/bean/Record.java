package com.els.bean;

import java.io.Serializable;

public class Record implements Serializable{
    private Integer rid;

    private Integer userId;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}