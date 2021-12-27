package com.bayi.entity;

import java.util.Date;

public class Goods {
    private String sub;//订单号
    private String userName; //用户名
    private Date sPate; //订购日期
    private String address;//地址
    private String payment;//支付方式
    private String photo;//电话
    private String carry;//运送方式

    public Goods(String sub, String userName, Date sPate, String address, String payment, String photo, String carry) {
        this.sub = sub;
        this.userName = userName;
        this.sPate = sPate;
        this.address = address;
        this.payment = payment;
        this.photo = photo;
        this.carry = carry;
    }

    public Goods(String userName, Date sPate, String address, String payment, String photo, String carry) {
        this.userName = userName;
        this.sPate = sPate;
        this.address = address;
        this.payment = payment;
        this.photo = photo;
        this.carry = carry;
    }

    public Goods() {
        super();
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getsPate() {
        return sPate;
    }

    public void setsPate(Date sPate) {
        this.sPate = sPate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCarry() {
        return carry;
    }

    public void setCarry(String carry) {
        this.carry = carry;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "sub='" + sub + '\'' +
                ", userName='" + userName + '\'' +
                ", sPate=" + sPate +
                ", address='" + address + '\'' +
                ", payment='" + payment + '\'' +
                ", photo='" + photo + '\'' +
                ", carry='" + carry + '\'' +
                '}';
    }
}
