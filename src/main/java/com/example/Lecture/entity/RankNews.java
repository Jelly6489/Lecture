package com.example.Lecture.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class RankNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rankNewsSeq;

    @Column(length = 20, nullable = false)
    private String rankNewsNo;

    @Column(length = 200, nullable = false)
    private String date;

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
    public RankNews(String date, String value, String team, String games,
                    String win, String draw, String lose, String wp, String lp,
                    String difference, String gp, String address) {
        this.date = date;
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
        this.address = address;
    }
}
