package com.example.Lecture.controller;

import com.example.Lecture.entity.*;
import com.example.Lecture.service.RankCrawlService;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/ranked")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RankController {
    @Autowired
    RankCrawlService rankCrawler;

    private Document document;

    public Document connectUrl(String url) {
        log.info("connectUrl(): " + url);

        try {
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20100101 " +
                            "Firefox/10.0 AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/51.0.2704.103 Safari/537.36")
                    .execute();

            document = homepage.parse();
        } catch (Exception e) {
            System.out.println("Error in mainRank");
        }

        return document;
    }


    @GetMapping("/{value}")
//    public List<Rank> rankCrawling(@PathVariable String value) {
//    @RequestMapping("{value}")
    public ResponseEntity<List<Rank>> rankCrawling(@PathVariable String value) throws Exception {
        log.info("rankCrawling(): " + value);

        if("프리미어리그".equals(value)) {
            document = connectUrl("프리미어-리그/순위/2kwbbcootiqqgmrzs6o5inle5");
        } else if("프리메라리가".equals(value)) {
            document = connectUrl("프리메라-리가/순위/34pl8szyvrbwcmfkuocjm3r6t");
        } else if("분데스리가".equals(value)) {
            document = connectUrl("분데스리가/5c96g1zm7vo5ons9c42uy2w3r");
        } else if("세리에a".equals(value)) {
            document = connectUrl("세리에-a/순위/1r097lpxe0xn03ihb7wi98kao");
        } else if("k리그1".equals(value)) {
            document = connectUrl("k리그-1/순위/avs3xposm3t9x1x2vzsoxzcbu");
        } else if ("리게앙".equals(value)) {
            document = connectUrl("리게-앙/순위/dm5ka0os1e3dxcp3vh05kmp33");
        }

        rankCrawler.mainRank(value);
//        return rankCrawler.rankFindAll();
        return new ResponseEntity<>(rankCrawler.rankFindAll(), HttpStatus.OK);
    }


    @GetMapping("rank")
//    public List<RankHome> findRankHome() {
//    @RequestMapping("rank")
    public ResponseEntity<List<RankHome>> findRankHome(@PathVariable String value) throws Exception {
        log.info("findRankHome()");

        rankCrawler.crawlingRankHome();
//        return rankCrawler.rankHomeFindAll();
        return new ResponseEntity<>(rankCrawler.rankHomeFindAll(), HttpStatus.OK);
    }



    @GetMapping("rank/{rankNo}")
//    public RankNews crawlingRank(@PathVariable String rankNo) {
//    @RequestMapping("rank/{rankNo}")
    public ResponseEntity<RankNews> crawlingRank(@PathVariable String rankNo) throws Exception {
        log.info("crawlingRank(): " + rankNo);

//        return rankCrawler.crawlingRank(rankNo);
        return new ResponseEntity<>(rankCrawler.crawlingRank(rankNo), HttpStatus.OK);
    }
}


