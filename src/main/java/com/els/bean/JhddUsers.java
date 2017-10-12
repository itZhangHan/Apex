package com.els.bean;

public class JhddUsers {
    private Integer userid;

    private String username;

    private String userportrait;

    private Boolean usersex;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserportrait() {
        return userportrait;
    }

    public void setUserportrait(String userportrait) {
        this.userportrait = userportrait == null ? null : userportrait.trim();
    }

    public Boolean getUsersex() {
        return usersex;
    }

    public void setUsersex(Boolean usersex) {
        this.usersex = usersex;
    }
}