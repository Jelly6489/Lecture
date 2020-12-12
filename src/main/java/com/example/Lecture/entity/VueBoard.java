package com.example.Lecture.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString // 자동으로 만들어줌
public class VueBoard {
    private long boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}

//create table cafe_board(
// board_no int primary key auto_increment, title varchar(32) not null,
// content varchar(100) not null, writer varchar(16),
// reg_date timestamp default current_timestamp on update current_timestamp);