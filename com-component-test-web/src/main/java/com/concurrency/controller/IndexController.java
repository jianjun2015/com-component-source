package com.concurrency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangjianjun on 2017/7/21.
 */
@Controller
@RequestMapping("/index")
public class IndexController {


    @RequestMapping("/welcome")
    public String welcome(Model model, HttpServletRequest request){

        System.out.println("welcome");
        model.addAttribute("var_","value_");

        return "main";
    }
}
