package com.concurrency.controller;

import com.concurrency.entity.User;
import com.concurrency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by wangjianjun on 2017/9/8.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addPage")
    public String addUserPage(){
        return "user/add";
    }

    @RequestMapping("/add")
    public String addUser(User user){

        user.setUserName("lisi");
        user.setUserAge(26);
        user.setUserBirthday(new Date());
        user.setUserSalary(101d);
        userService.insertUser(user);

//        return "redirect:/user/show";//跳转controller -全路径-新的资源 重定向改变url
        return "forward:show";//当前controller 的映射 -相对当前路径 改变url
    }

    @RequestMapping("/show/{id}")
    public String showUser(Model model,@PathVariable("id") Integer id){

        User user = userService.getUserByName(id);
        model.addAttribute("user",user);

        return "user/show";
    }
}