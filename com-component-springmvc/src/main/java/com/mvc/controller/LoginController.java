package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangjianjun on 2017/7/21.
 */
@Controller
public class LoginController {

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/login")
    public String loginSys(HttpServletRequest request, Model model){

        String userName = request.getParameter("userName");
        String passwd = request.getParameter("passwd");

        System.out.println(userName+":"+passwd);

        return "result/success";
    }
}
