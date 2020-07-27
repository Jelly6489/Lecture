package com.example.Lecture.service;

import com.example.Lecture.entity.Board;
import com.example.Lecture.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 클래스 implements 인터페이스
// Service 어노테이션
// Spring <<- Event Driven 방식으로 동작을 하고 있음
@Service
public class BoardServiceImpl implements BoardService{
    // 클래스 사용할 때 ? 객체가 필요하다.
    // new를 해야 한다는 의미
    // Autowired가 붙으면 이것을 자동으로 해줌
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void register(Board board) throws Exception {
        boardRepository.create(board);
    }

    @Override
    public List<Board> list() throws Exception {
        return boardRepository.list();
    }
}
