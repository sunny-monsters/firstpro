package com.bayi.entity;

public class Login {
    private int uid;
    private String uname;
    private String upwd;

    public Login(int uid, String uname, String upwd) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
    }

    public Login(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public Login() {
        super();
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
