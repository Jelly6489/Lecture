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
    public String glist(Model model) throws Exception {
        log.info("glist()");

        model.addAttribute(
                "glist",
                service.glist());

        return "game/glist";
    }

    @GetMapping("/gread")
    public String gread(int idNo, Model model) throws Exception {
        log.info("gread()");

        model.addAttribute(service.gread(idNo));

        return "game/gread";
    }

    @PostMapping("gremove")
    public String gremove(int idNo, Model model) throws Exception {
        log.info("gremove()");

        service.gremove(idNo);

        model.addAttribute("msg",
                "Success Delete!");

        return "game/success";
    }

    @GetMapping("/getGModify")
    public String gmodify(int idNo, Model model) throws Exception {
        log.info("getGModify()");

        model.addAttribute(service.gread(idNo));

        return "game/gmodify";
    }

    @PostMapping("/postGModify")
    public String gmodify(ItemMania itemMania, Model model) throws Exception {
        log.info("postGModify()");

        service.gmodify(itemMania);

        model.addAttribute("msg",
                "Modify Success"
        );

        return "game/success";
    }

}
