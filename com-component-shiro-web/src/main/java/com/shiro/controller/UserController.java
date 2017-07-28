package com.shiro.controller;

import com.shiro.entity.entity.User;
import com.shiro.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by wangjianjun on 2017/7/26.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(User user){
        ModelAndView mv = new ModelAndView("main");

        try {
            userService.login(user);
        }catch (Exception e){
            mv = new ModelAndView("common/error");
        }


        return mv;
    }
}
