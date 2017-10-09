package com.els.bean;

import java.io.Serializable;

public class Clickrate implements Serializable{
    private Integer cid;

    private Long clickRate;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Long getClickRate() {
        return clickRate;
    }

    public void setClickRate(Long clickRate) {
        this.clickRate = clickRate;
    }
}