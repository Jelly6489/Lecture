package com.example.Lecture.repository;


import com.example.Lecture.entity.Member;
import com.example.Lecture.entity.PortTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findByUserId(String userId);

    @Query("select m.userNo, m.userPw, m.userName, m.regDate from Member m")
    public List<Object[]> listAllMember();

//    public boolean idcheck(Member member);
}
