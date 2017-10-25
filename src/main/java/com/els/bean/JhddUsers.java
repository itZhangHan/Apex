package com.els.bean;

public class JhddUsers {
    private Integer userid;

    private String username;

    private String userportrait;

    private Integer usersex;

    private String openid;

    private String city;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(Object object) {
        this.username = object == null ? null : ((String) object).trim();
    }

    public String getUserportrait() {
        return userportrait;
    }

    public void setUserportrait(String userportrait) {
        this.userportrait = userportrait == null ? null : userportrait.trim();
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer object) {
        this.usersex = (Integer) object;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }
}