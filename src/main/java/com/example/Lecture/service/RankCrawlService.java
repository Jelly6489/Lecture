package com.example.Lecture.service;


import com.example.Lecture.entity.Rank;
import com.example.Lecture.entity.RankHome;
import com.example.Lecture.entity.RankNews;
import com.example.Lecture.repository.RankHomeRepository;
import com.example.Lecture.repository.RankNewsRepository;
import com.example.Lecture.repository.RankRepository;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Log
public class RankCrawlService {

    @Autowired
    RankRepository rankRepository;

    @Autowired
    RankHomeRepository rankHomeRepository;

    @Autowired
    RankNewsRepository rankNewsRepository;

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

    public List<Rank> rankFindAll() {
        log.info("rankFindAll()");

        return rankRepository.findAll();
    }

    public List<RankHome> rankHomeFindAll() {
        log.info("rankHomeFindAll()");

        return rankHomeRepository.findAll();
    }

    public void crawlingRankHome() {
        log.info("crawlingRankHome()");

        rankHomeRepository.deleteAll();
        document = connectUrl("https://www.goal.com/kr/");

        Elements total = document.select("div.text_area>strong.title");
        Elements image = document.select("li.today_item>a.link_today>div.image.area");

        RankHome rankHome = null;

        for (int i = 0; i < total.size(); i++) {
            rankHome = new RankHome();
            rankHome.setRankHomeNo(String.valueOf(i + 1));
            rankHome.setTitle(total.get(i).text());
            rankHome.setAddress(total.get(i).attr("href"));
            rankHome.setImage(image.get(i).attr("src"));
            rankHomeRepository.save(rankHome);
        }
    }

    public void mainRank(String value) {
        log.info("mainRank(): " + value);

        document = connectUrl("https://www.goal.com/kr/" + value);
        //log.info("document:" + document);
        rankRepository.deleteAll();


        rankedNews(document.select("table.p0c-competition-tables__table>tbody>" +
                "tr.p0c-competition-tables__row.p0c-competition-tables__row-rank-status p0c-competition-table__row--rank-status-1"), value);
    }

    public void rankedNews(Elements elements, String value) {
        log.info("RankNews(): elements - " + elements + ", value - " + value);

//        Rank rank = null;

        for (int i = 0; i < elements.size(); i++) {

            Element el = elements.get(i);

            Rank rank = new Rank();

            String rNum = el.select("td").text();
            String rTeam = el.select("td.p0c-competition-tables__team>a>abbr.p0c-competition-tables__team--short-name").text();
            String rGame = el.select("td.p0c-competition-tables__matches-played").text();
            String rWin = el.select("td.p0c-competition-tables__matches-won").text();
            String rDraw = el.select("td.p0c-competition-tables__matches-drawn").text();
            String rLose = el.select("td.p0c-competition-tables__matches-lost").text();
            String rWp = el.select("td.p0c-competition-tables__goals-for").text();
            String rLp = el.select("td.p0c-competition-tables__goals-against").text();
            String rD = el.select("td.p0c-competition-tables__goals-diff").text();
            String rGp = el.select("td.p0c-competition-tables__pts").text();

            rank.setRankNo(rNum);
            rank.setTeam(rTeam);
            rank.setGames(rGame);
            rank.setWin(rWin);
            rank.setDraw(rDraw);
            rank.setLose(rLose);
            rank.setWp(rWp);
            rank.setLp(rLp);
            rank.setDifference(rD);
            rank.setGp(rGp);

            rankRepository.save(rank);

//            log.info("번호" + rank.getRankNo());
//            log.info("팀" + rTeam);
//            log.info("경기" + rGame);
//            log.info("승" + rWin);

            /*rank = new Rank();

            rank.setRankNo(String.valueOf(rankRepository.findAll().size() + 1));
            rank.setAddress(elements.get(i).attr("href"));
            rank.setDifference(elements.get(i).text());
            rank.setDraw(elements.get(i).text());
            rank.setGames(elements.get(i).text());
            rank.setGp(elements.get(i).text());
            rank.setLose(elements.get(i).text());
            rank.setLp(elements.get(i).text());
            rank.setTeam(elements.get(i).text());
            rank.setValue(value);
            rank.setWin(elements.get(i).text());
            rank.setWp(elements.get(i).text());*/

//            rankRepository.save(rank);
        }
    }

    public RankNews crawlingRank(String rankNo) {
        log.info("crawlingRank(): " + rankNo);

        Rank rank = rankRepository.findByRankNo(rankNo);

        RankNews rankNews = new RankNews();

        rankNews.setTeam(rank.getTeam());
        rankNews.setGames(rank.getGames());
        rankNews.setWin(rank.getWin());
        rankNews.setDraw(rank.getDraw());
        rankNews.setLose(rank.getLose());
        rankNews.setWp(rank.getWp());
        rankNews.setLp(rank.getLp());
        rankNews.setDifference(rank.getDifference());
        rankNews.setGp(rank.getGp());
        rankNews.setValue(rank.getValue());
        rankNews.setAddress(rank.getAddress());
        rankNews.setRankNewsNo(String.valueOf(rankNewsRepository.findAll().size() + 1));

        document = connectUrl(rankNews.getAddress());

        rankNews.setDate(document.select("span.num_date").text());
        rankNews.setGames(document.select("div.article_view>section>:not(figure)").text());

        rankNewsRepository.save(rankNews);

        return rankNews;
    }
}
