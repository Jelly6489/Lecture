package com.example.Lecture.service;


import com.example.Lecture.entity.MemberAuth;
import com.example.Lecture.repository.MemberAuthRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class MemberAuthService {
    @Autowired
    MemberAuthRepository authRepository;

    public MemberAuth read(Long userNo) throws Exception {
        log.info("MemberAuth Service read()");

        return authRepository.checkAuth(userNo);
    }
}