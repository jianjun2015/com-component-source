package component.mybatis.controller;

import component.mybatis.entity.User;
import component.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by wangjianjun on 2017/7/7.
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

        user.setUserBirthday(new Date());
        user.setUserSalary(101d);
        userService.insertUser(user);

//        return "redirect:/user/show";//跳转controller -全路径-新的资源 重定向改变url
        return "forward:show";//当前controller 的映射 -相对当前路径 改变url
    }

    @RequestMapping("/show")
    public String showUser(){

        return "user/show";
    }
}
