package com.example.Lecture.controller;

import com.example.Lecture.entity.*;
import com.example.Lecture.service.RankCrawlService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/rank")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RankController {
    @Autowired
    RankCrawlService rankCrawler;


//    @RequestMapping("{value}")
//    public List<Rank> rankCrawling(@PathVariable String value) {
    @GetMapping("{value}")
    public ResponseEntity<List<Rank>> rankCrawling(@PathVariable String value) throws Exception {
        log.info("rankCrawling(): " + value);

        rankCrawler.mainRank(value);
//        return rankCrawler.rankFindAll();
        return new ResponseEntity<>(rankCrawler.rankFindAll(), HttpStatus.OK);
    }

//    @RequestMapping("rank")
//    public List<RankHome> findRankHome() {
    @GetMapping("ranks")
    public ResponseEntity<List<RankHome>> findRankHome(@PathVariable String value) throws Exception {
        log.info("findRankHome()");

        rankCrawler.crawlingRankHome();
//        return rankCrawler.rankHomeFindAll();
        return new ResponseEntity<>(rankCrawler.rankHomeFindAll(), HttpStatus.OK);
    }


//    @RequestMapping("rank/{rankNo}")
//    public RankNews crawlingRank(@PathVariable String rankNo) {
    @GetMapping("ranks/{rankNo}")
    public ResponseEntity<RankNews> crawlingRank(@PathVariable String rankNo) throws Exception {
        log.info("crawlingRank(): " + rankNo);

//        return rankCrawler.crawlingRank(rankNo);
        return new ResponseEntity<>(rankCrawler.crawlingRank(rankNo), HttpStatus.OK);
    }
}


