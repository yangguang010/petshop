package com.petshop.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by songyangguang on 2018/1/24.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }
}
