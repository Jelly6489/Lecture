package com.example.Lecture.controller;

import com.example.Lecture.entity.PortTest;
import com.example.Lecture.service.PortTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PortTestController {
    private static final Logger log =
            LoggerFactory.getLogger(PortTestController.class);

    @Autowired
    private PortTestService service;

    @GetMapping("/getJoin")
    public String getJoin(PortTest portTest, Model model) throws Exception {
        log.info("getJoin()");

        return "portTest/join";
    }

    @PostMapping("/postJoin")
    public String postJoin(PortTest portTest, Model model) throws Exception {
        log.info("postJoin()");

        service.join(portTest);

        model.addAttribute(
                "msg," +
                        "Register Success"
        );

        return "portTest/psuccess";
    }

    @GetMapping("/plist")
    public String plist(Model model) throws Exception {
        log.info("plist()");

        model.addAttribute(
                "plist",
                service.plist());

        return "portTest/plist";
    }

    @GetMapping("/login")
    public boolean Login(PortTest portTest, Model model) throws Exception {
        log.info("Login()");

        model.addAttribute(service.login(portTest));

        return true;
    }

}



//    create table ItemMania( id_no int not null auto_increment,
//    id varchar(30) not null,
//    pw varchar(50) not null,
//    nickname varchar(100) not null,
//    item varchar(200) not null,
//    price varchar(200) not null,
//    reg_date timestamp not null default now(),
//    primary key(id_no) );

// create table PortTest( id_no int not null auto_increment,
//         id varchar(30) not null,
//         pw varchar(50) not null,
//         nickname varchar(100) not null,
//         name varchar(100) not null,
//         age int(11) not null,
//         phone int(11) not null,
//         gender varchar(30) not null,
//         primary key(id_no) );

// describe PortTest;
// select * from PortTest;
