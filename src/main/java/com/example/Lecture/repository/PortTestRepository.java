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
                "id, pw, nickname, name, age, phone, gender, title, text) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, portTest.getId(), portTest.getPw(),
                portTest.getNickname(), portTest.getName(), portTest.getAge(),
                portTest.getPhone(), portTest.getGender(),
                portTest.getTitle(), portTest.getText());
    }

    public List<PortTest> plist() throws Exception {
        log.info("Repository plist()");

        List<PortTest> results = jdbcTemplate.query(
                "select id_no, id, pw, title, nickname, reg_date, name, age, " +
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
                        portTest.setTitle(rs.getString("title"));
                        portTest.setNickname(rs.getString("nickname"));
                        portTest.setRegDate(rs.getDate("reg_date"));
                        portTest.setName(rs.getString("name"));
                        portTest.setAge(rs.getInt("age"));
                        portTest.setPhone(rs.getInt("phone"));
                        portTest.setGender(rs.getString("gender"));
                        return portTest;
                    }
                });
        return results;
    }

    public boolean login(PortTest portTest) {

        String query = "select id, pw from portTest where id=? and pw=?";

        List<PortTest> list = jdbcTemplate.query(query, new RowMapper<PortTest>() {
            @Override
            public PortTest mapRow(ResultSet rs, int rowNum) throws SQLException {
                PortTest pt = new PortTest();
                pt.setId(rs.getString("id"));
                pt.setPw(rs.getString("pw"));

                return pt;
            }
        }, portTest.getId(), portTest.getPw());

        boolean result = list.isEmpty() ? true : false;
        return result;
    }

    public boolean idcheck(PortTest portTest) {

        String query = "select id from portTest where id=?";

        List<PortTest> list = jdbcTemplate.query(query, new RowMapper<PortTest>() {
            @Override
            public PortTest mapRow(ResultSet rs, int rowNum) throws SQLException {
                PortTest pt = new PortTest();
                pt.setId(rs.getString("id"));
                return pt;
            }
        }, portTest.getId());

        boolean result = list.isEmpty() ? false : true;
        return result;
    }

    public PortTest pread(Integer idNo) throws Exception {
        List<PortTest> results = jdbcTemplate.query(
                "select id_no, id, pw, nickname, name, age, " +
                        "phone, gender, title, reg_date, text " +
                        "from portTest where id_no = ?",
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
                        portTest.setTitle(rs.getString("title"));
                        portTest.setRegDate(rs.getDate("reg_date"));
                        portTest.setText(rs.getString("text"));

                        return portTest;
                    }
                }, idNo
        );

        return results.isEmpty() ? null : results.get(0);
    }

    public void premove(Integer idNo) throws Exception {
        String query = "delete from portTest where id_no = ?";
        jdbcTemplate.update(query, idNo);
    }

    public void pmodify(PortTest portTest) throws Exception {
        String query = "update portTest set id = ?, pw = ?, " +
                "nickname = ?, name = ?, age = ?, phone = ?, gender = ? " +
                "title = ?, reg_date = ?, text = ? where id_no = ?";
        jdbcTemplate.update(
                query, portTest.getId(), portTest.getPw(),
                portTest.getNickname(), portTest.getName(),
                portTest.getAge(), portTest.getPhone(), portTest.getGender(),
                portTest.getTitle(), portTest.getRegDate(),
                portTest.getText(), portTest.getIdNo()
        );
    }
}


