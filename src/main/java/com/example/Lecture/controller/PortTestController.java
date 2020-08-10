package com.example.Lecture.controller;

import com.example.Lecture.entity.ItemMania;
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
                        "작성 완료 Success"
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
    public String Login(PortTest portTest, Model model) throws Exception {

        log.info("Login()");

        return "portTest/login";
    }

    @PostMapping("/postLogin")
    public String PostLogin(PortTest portTest, Model model)
            throws Exception {
        log.info("PostLogin()");

        boolean result = service.login(portTest);
        String res;
        if (!result) {
            model.addAttribute(
                    "msg",
                    "로그인 성공!!");

            res = "portTest/psuccess";
        } else {

            model.addAttribute(
                    "msg",
                    "로그인 실패!!");


            res = "portTest/psuccess";
        }
        return res;
    }

    @PostMapping("/idcheck")
    public String Idcheck(PortTest portTest, Model model)
            throws Exception {
        log.info("Idcheck()");

        boolean result = service.idcheck(portTest);
        String res;
        if (!result) {
            model.addAttribute(
                    "msg",
                    "사용 가능!!");

            res = "portTest/psuccess";
        } else {
            model.addAttribute(
                    "msg",
                    "사용 불가!!");

            res = "portTest/psuccess";
        }
        return res;
    }

    @GetMapping("/pread")
    public String pread(int idNo, Model model) throws Exception {
        log.info("pread()");

        model.addAttribute(service.pread(idNo));

        return "portTest/pread";
    }

    @PostMapping("/premove")
    public String premove(int idNo, Model model) throws Exception {
        log.info("premove()");

        service.premove(idNo);

        model.addAttribute("msg",
                "삭제 완료");

        return "portTest/psuccess";
    }

    @GetMapping("/getPModify")
    public String getPModify(int idNo, Model model) throws Exception {
        log.info("getPModify()");

        model.addAttribute(service.pread(idNo));

        return "portTest/pmodify";
    }

    @PostMapping("/postPModify")
    public String postPModify(PortTest portTest, Model model) throws Exception {
        log.info("postPModify()");

        service.pmodify(portTest);

        model.addAttribute("msg",
                "수정 완료"
        );

        return "portTest/psuccess";
    }
}

//    @GetMapping("/getWrite")
//    public String getWrite(PortTest portTest, Model model) throws Exception {
//        log.info("getWrite()");
//
//        return "portTest/write";
//    }
//
//    @PostMapping("/postWrite")
//    public String postWrite(PortTest portTest, Model model) throws Exception {
//        log.info("postWrite()");
//
//        service.write(portTest);
//
//        model.addAttribute(
//                "msg," + "Write Success"
//        );
//
//        return "portTest/psuccess";
//    }


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
