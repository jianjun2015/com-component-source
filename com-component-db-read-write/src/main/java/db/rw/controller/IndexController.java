package db.rw.controller;

import db.rw.componennt.DataSourcesPropsUtil;
import db.rw.entity.DsInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangjianjun on 2017/7/21.
 */
@Controller
@RequestMapping("/index")
public class IndexController {


    @RequestMapping("/welcome")
    public String welcome(Model model, HttpServletRequest request){

        DsInfo dsInfo = DataSourcesPropsUtil.getDsInfoByName("local");
        List<DsInfo> dsInfos = DataSourcesPropsUtil.getAll();

        System.out.println("welcome");
        model.addAttribute("var_","value_");

        return "main";
    }
}
