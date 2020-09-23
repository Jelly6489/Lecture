package com.example.Lecture.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rankSeq;

    @Column(length = 20, nullable = false)
    private String rankNo;

    @Column(length = 20, nullable = false)
    private String value;

    @Column(length = 200, nullable = false)
    private String team;

    @Column(length = 200, nullable = false)
    private String games;

    @Column(length = 100, nullable = false)
    private String win;

    @Column(length = 100, nullable = false)
    private String draw;

    @Column(length = 100, nullable = false)
    private String lose;

    @Column(length = 300, nullable = false)
    private String wp;

    @Column(length = 300, nullable = false)
    private String lp;

    @Column(length = 200, nullable = false)
    private String difference;

    @Column(length = 300, nullable = false)
    private String gp;

    @Column(length = 500, nullable = false)
    private String address;

    @Builder
    public Rank(String rankNo, String value, String team, String games,
                String win, String draw, String lose, String wp, String lp,
                String difference, String gp, String address) {
        this.rankNo = rankNo;
        this.address = address;
        this.value = value;
        this.team = team;
        this.games = games;
        this.win = win;
        this.draw = draw;
        this.lose = lose;
        this.wp = wp;
        this.lp = lp;
        this.difference = difference;
        this.gp = gp;
    }
/*
    private Long rankSeq;
    private String rankNo;
    private String value;
    private String team;
    private String games;
    private String win;
    private String draw;
    private String lose;
    private String wp;
    private String lp;
    private String difference;
    private String gp;
    private String address;

    public Long getRankSeq() {
        return rankSeq;
    }

    public void setRankSeq(Long rankSeq) {
        this.rankSeq = rankSeq;
    }

    public String getRankNo() {
        return rankNo;
    }

    public void setRankNo(String rankNo) {
        this.rankNo = rankNo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getLose() {
        return lose;
    }

    public void setLose(String lose) {
        this.lose = lose;
    }

    public String getWp() {
        return wp;
    }

    public void setWp(String wp) {
        this.wp = wp;
    }

    public String getLp() {
        return lp;
    }

    public void setLp(String lp) {
        this.lp = lp;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    public String getGp() {
        return gp;
    }

    public void setGp(String gp) {
        this.gp = gp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }*/
}
