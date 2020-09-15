package com.example.Lecture.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Search {
    private String findType;
    private String keyword;

    @Override
    public String toString() {
        return super.toString() + " Search" + "[findType="
                + findType + ", keyword=" + keyword + "]";
    }
}
