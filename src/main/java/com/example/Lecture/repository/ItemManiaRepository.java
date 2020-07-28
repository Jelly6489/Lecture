package com.example.Lecture.repository;

import com.example.Lecture.entity.Board;
import com.example.Lecture.entity.ItemMania;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemManiaRepository {
    static final Logger log =
            LoggerFactory.getLogger(ItemManiaRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(ItemMania itemMania) throws Exception {
        log.info("Repository create()");

        String query = "insert into itemMania(" +
                "id, pw, nickname, item, price) values(?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, itemMania.getId(), itemMania.getPw(),
                itemMania.getNickname(), itemMania.getItem(), itemMania.getPrice());
    }

    public List<ItemMania> glist() throws Exception {
        log.info("Repository glist()");

        List<ItemMania> results = jdbcTemplate.query(
                "select id_no, id, pw, nickname, item, " +
                        "price, reg_date from itemMania where id_no > 0 order by " +
                        "id_no desc, reg_date desc",

                new RowMapper<ItemMania>() {
                    @Override
                    public ItemMania mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        ItemMania itemMania = new ItemMania();
                        itemMania.setIdNo(rs.getInt("id_no"));
                        itemMania.setId(rs.getString("id"));
                        itemMania.setPw(rs.getString("pw"));
                        itemMania.setNickname(rs.getString("nickname"));
                        itemMania.setItem(rs.getString("item"));
                        itemMania.setPrice(rs.getString("price"));
                        itemMania.setRegDate(rs.getDate("reg_date"));
                        return itemMania;
                    }
                });

        return results;
    }

    public ItemMania gread(Integer idNo) throws Exception {
        List<ItemMania> results = jdbcTemplate.query(
                "select id_no, id, pw, nickname, item, price, " +
                        "reg_date from itemMania where id_no = ?",
                new RowMapper<ItemMania>() {
                    @Override
                    public ItemMania mapRow(ResultSet rs, int rowNum) throws SQLException {
                        ItemMania itemMania = new ItemMania();

                        itemMania.setIdNo(rs.getInt("id_no"));
                        itemMania.setId(rs.getString("id"));
                        itemMania.setPw(rs.getString("pw"));
                        itemMania.setNickname(rs.getString("nickname"));
                        itemMania.setItem(rs.getString("item"));
                        itemMania.setPrice(rs.getString("price"));
                        itemMania.setRegDate(rs.getDate("reg_date"));

                        return itemMania;
                    }
                }, idNo
        );

        return results.isEmpty() ? null : results.get(0);
    }

    public void gremove(Integer idNo) throws Exception {
        String query = "delete from itemMania where id_no = ?";
        jdbcTemplate.update(query, idNo);
    }

    public void gmodify(ItemMania itemMania) throws Exception {
        String query = "update itemMania set id = ?, pw = ?, " +
                "nickname = ?, item = ?, price = ?" +
                "where id_no = ?";
        jdbcTemplate.update(
                query, itemMania.getId(), itemMania.getPw(),
                itemMania.getNickname(), itemMania.getItem(),
                itemMania.getPrice(), itemMania.getIdNo()
        );
    }
}