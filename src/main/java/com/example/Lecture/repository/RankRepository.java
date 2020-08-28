package com.example.Lecture.repository;

import com.example.Lecture.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<Rank, Long> {
    public Rank findByRankNo(String rankNo);
}
