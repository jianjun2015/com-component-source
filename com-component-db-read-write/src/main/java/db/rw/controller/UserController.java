package db.rw.controller;

import db.rw.entity.User;
import db.rw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by wangjianjun on 2017/7/7.
 */
@Controller
@RequestMapping("/userInfo")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/addPage")
    public String addUserPage(){
        return "user/add";
    }

    @RequestMapping("/add")
    public String addUser(User user, HttpServletRequest request){

        user.setUserBirthday(new Date());
        user.setUserSalary(101d);
        int ret = iUserService.insertUser(user);
        request.getSession().setAttribute("uId",ret);

//        return "redirect:/user/show";//跳转controller -全路径-新的资源 重定向改变url
        return "forward:show";//当前controller 的映射 -相对当前路径 改变url
    }

    @RequestMapping("/show")
    public String showUser(HttpServletRequest request,Model model){

        Object idOjb = request.getSession().getAttribute("uId");
        int id = 0;
        if (idOjb != null)
            id = Integer.parseInt(idOjb.toString());

        User user = iUserService.getUserById(id);
        model.addAttribute("user",user);
        return "user/show";
    }

    @RequestMapping("/get/{id}")
    public String getUser(@PathVariable("id") int id, Model model){

        User user = iUserService.getUserById(id);
        model.addAttribute("user",user);
        return "user/show";
    }
}
