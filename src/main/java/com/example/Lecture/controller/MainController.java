package com.example.Lecture.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

// RestController vs Controller
// DemoApplication에 main()이 동작하면서 자바 코드가 동작한다.
// 아래와 같은 Annotation이 붙어있으면
// 자동으로 스프링 프레임웍이 URL 맵핑을 제어하는 제어유닛으로 바라본다.

@Controller // 사용자 요청 분석
public class MainController {
    static final Logger log =
            LoggerFactory.getLogger(MainController.class);

    // localhost:8080/으로 접속하면
    // 제어 유닛이 아래 코드를 실행시킨다.
    // localhost:8080 <-- 아이피 주소와 포트 번호
    @GetMapping("/") //
    public String index(Locale locale, Model model) {
        log.info("index()");

        // 현재 날짜를 받아온다.
        Date date = new Date();
        // DateFormat.getDateTimeInstance를 통해
        // 연월일 시간 정보의 지역 정보를 출력하도록 한다.
        // 형식 지정자
        DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG, locale
        );

        // 위의 정보를 문자열로 만들어야 하므로 dateFormat.format을 사용함
        // 주어진 형식대로 서식이 있는 날짜 형태의 문자를 만든다.
        String formattedDate = dateFormat.format(date);
        // 최종적으로 만든 정보를 servTime 속성에 전달한다.
        model.addAttribute("servTime", formattedDate);

        // 변수 - 메모리상에 올라가는 모든 것
        // Model - 데이터(or 객체)
        // View - 화면(보는거): HTML
        // Controller - RestController & Controller
        // Controller -> 사용자가 url 요청이 들어왔을 때 적절한 응답을 해줌

        // index.html을 보여준다.
        return "index";
    }
}