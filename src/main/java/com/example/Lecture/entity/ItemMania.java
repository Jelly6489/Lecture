package com.example.Lecture.entity;

import java.util.Date;

// 1. MySQL에 Table을 작성한다.
//    (Entity: ItemMania
//     id, pw, nickname, item, price)
public class ItemMania {
        private int idNo;
        private int pw;
        private String nickname;
        private String item;
        private int price;
        private Date regDate;

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
