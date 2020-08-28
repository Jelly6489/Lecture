package com.example.Lecture.repository;

import com.example.Lecture.entity.RankNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankNewsRepository extends JpaRepository<RankNews, Long> {
    public RankNews findByRankNewsNo(String rankNewsNo);
}
