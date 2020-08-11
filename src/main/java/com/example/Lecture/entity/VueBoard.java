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
