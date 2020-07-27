package com.example.Lecture.controller;

import com.example.Lecture.entity.ItemMania;
import com.example.Lecture.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemManiaController {
    private static final Logger log =
            LoggerFactory.getLogger(ItemManiaController.class);

    @Autowired
    private ItemService service;

    @GetMapping("/getGRegister")
    public String getGRegister(ItemMania itemMania, Model model) throws Exception {
        log.info("getGRegister()");

        return "game/gregister";
    }

    @PostMapping("/postGRegister")
    public String postGRegister(ItemMania itemMania, Model model) throws Exception {
        log.info("postGRegister()");

        service.gregister(itemMania);

        model.addAttribute(
                "msg," +
                "Register Success"
        );

        return "game/success";
    }

    @GetMapping("/glist")
    public String list(Model model) throws Exception {
        log.info("glist()");

        // 속성 추가(이름: list)
        // Controller -> Service -> Repository 방식으로
        // 동작하게 설계되어 있다.
        model.addAttribute(
                // DB에서 읽어온 정보가 list에 있음
                "glist",
                service.glist());

        // HTML 파일
        return "game/glist";
    }
}
