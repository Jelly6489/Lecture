package com.example.Lecture.service;

import com.example.Lecture.entity.Board;

import java.util.List;

public interface BoardService {
    public void register(Board board) throws Exception;
    public List<Board> list() throws Exception;

}
