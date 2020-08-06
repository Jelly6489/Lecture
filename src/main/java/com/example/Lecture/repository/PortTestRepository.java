package com.example.Lecture.repository;

import com.example.Lecture.entity.PortTest;
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
public class PortTestRepository {
    static final Logger log =
            LoggerFactory.getLogger(PortTest.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void join(PortTest portTest) throws Exception {
        log.info("Repository join()");

        String query = "insert into portTest(" +
                "id, pw, nickname, name, age, phone, gender) " +
                "values(?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, portTest.getId(), portTest.getPw(),
                portTest.getNickname(), portTest.getName(), portTest.getAge(),
                portTest.getPhone(), portTest.getGender());
    }

    public List<PortTest> plist() throws Exception {
        log.info("Repository plist()");

        List<PortTest> results = jdbcTemplate.query(
                "select id_no, id, pw, nickname, name, age, " +
                        "phone, gender from portTest where id_no > 0 order by " +
                        "id_no desc",

                new RowMapper<PortTest>() {
                    @Override
                    public PortTest mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        PortTest portTest = new PortTest();
                        portTest.setIdNo(rs.getInt("id_no"));
                        portTest.setId(rs.getString("id"));
                        portTest.setPw(rs.getString("pw"));
                        portTest.setNickname(rs.getString("nickname"));
                        portTest.setName(rs.getString("name"));
                        portTest.setAge(rs.getInt("age"));
                        portTest.setPhone(rs.getInt("phone"));
                        portTest.setGender(rs.getString("gender"));
                        return portTest;
                    }
                });
        return results;
    }

//    public boolean login(PortTest portTest) throws Exception {
//                log.info("Repository plogin()");
//
//        List<PortTest> results = jdbcTemplate.query(
//                "select id, pw from where id = ?, pw = ?",
//
//                new RowMapper<PortTest>() {
//                @Override
//                public PortTest mapRow(ResultSet rs, int rowNum)
//                        throws SQLException {
//                    PortTest portTest = new PortTest();
//                    portTest.setId(rs.getString("id"));
//                    portTest.setPw(rs.getString("pw"));
//                    return portTest;
//                }
//            });
//        return results;
//    }
}

