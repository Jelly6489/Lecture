package com.example.Lecture.controller;

import com.example.Lecture.entity.Rank;
import com.example.Lecture.entity.RankHome;
import com.example.Lecture.entity.RankNews;
import com.example.Lecture.service.RankCrawlService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
//@RequestMapping("")
@CrossOrigin(origins = "http://localhost:8080/", allowedHeaders = "*")
public class RankController {
    @Autowired
    RankCrawlService rankCrawler;

//    @GetMapping("{value}")
    @RequestMapping("{value}")
    public List<Rank> rankCrawling(@PathVariable String value) {
        log.info("rankCrawling(): " + value);

        rankCrawler.mainRank(value);
        return rankCrawler.rankFindAll();
    }

//    @GetMapping("rank")
    @RequestMapping("rank")
    public List<RankHome> findRankHome() {
        log.info("findRankHome()");

        rankCrawler.crawlingRankHome();
        return rankCrawler.rankHomeFindAll();
    }

//    @GetMapping("rank/{rankNo}")
    @RequestMapping("rank/{rankNo}")
    public RankNews crawlingRank(@PathVariable String rankNo) {
        log.info("crawlingRank(): " + rankNo);

        return rankCrawler.crawlingRank(rankNo);
    }
}


