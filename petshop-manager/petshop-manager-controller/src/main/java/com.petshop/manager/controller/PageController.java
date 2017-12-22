package com.petshop.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by songyangguang on 2017/12/21.
 */
@Controller
public class PageController {
    /**
     * 打开首页
     */
    @RequestMapping(value = "/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping(value = "/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

}
