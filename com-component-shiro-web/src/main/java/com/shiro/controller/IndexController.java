package com.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangjianjun on 2017/7/21.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/welcomePage")
    public String welcomPage(){
        return "/login.jsp";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model, HttpServletRequest request){

        System.out.println("welcome");
        model.addAttribute("var_","value_");

        return "main";
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public ModelAndView logout() {

        ModelAndView mv= new ModelAndView("main");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return mv;
    }
}
