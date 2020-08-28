package com.example.Lecture.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class RankHome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rankHomeSeq;

    @Column(length = 20, nullable = false)
    private String rankHomeNo;

    @Column(length = 2000, nullable = false)
    private String image;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String address;

    @Builder
    public RankHome(String rankHomeNo, String address, String title, String image) {
        this.rankHomeNo = rankHomeNo;
        this.title = title;
        this.address = address;
        this.image = image;
    }
}
