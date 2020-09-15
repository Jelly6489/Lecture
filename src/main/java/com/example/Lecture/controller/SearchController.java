package com.example.Lecture.controller;

import com.example.Lecture.entity.Search;
import com.example.Lecture.service.VueBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/fbbs/*")
public class SearchController {
    private static final Logger log =
            LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private VueBoardService vbs;

    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public void list(@ModelAttribute
        ("search")Search search, Model model) throws Exception {
        log.info("search.toString()");

        model.addAttribute("list", vbs.list());

    }
}
