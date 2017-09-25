package com.concurrency.controller;

import com.concurrency.componennt.DataSourcesPropsUtil;
import com.concurrency.entity.DsInfo;
import com.concurrency.entity.LoginInfo;
import com.concurrency.logger.LoggerManage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjianjun on 2017/7/21.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    private final Gson gson = new GsonBuilder().setDateFormat("yyyyMMddHHmmss").create();

    @RequestMapping("/welcome")
    public String welcome(Model model, HttpServletRequest request){

        model.addAttribute("var_","value_");
        return "login";
    }

    @RequestMapping("/login")
    @LoggerManage(description="登录")
    public ModelAndView login(HttpServletRequest request,LoginInfo loginInfo){
        System.out.println("userNumber *****"+request.getSession().getAttribute("userNumber"));

        ModelAndView mv = new ModelAndView();
        DsInfo dsInfo = DataSourcesPropsUtil.getDsInfoByName("local");
        List<DsInfo> dsInfos = DataSourcesPropsUtil.getAll();

        LoginInfo user = null;
        Object userObj = request.getSession().getAttribute("user");
        if(userObj != null)
            user = gson.fromJson(request.getSession().getAttribute("user").toString(), LoginInfo.class);

        if (user != null && user.getUsername().equals(loginInfo.getUsername())){
            mv.setViewName("main");
            return mv;
        }

        if (loginInfo != null && "admin".equals(loginInfo.getUsername()) && "admin".equals(loginInfo.getPassword())){
            request.getSession().setAttribute("user",gson.toJson(new LoginInfo(loginInfo.getUsername(),"123456")));
            mv.setViewName("main");
            return mv;
        }

        mv.addObject("loginMsg","error");
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest request){

        return "login";
    }
}
