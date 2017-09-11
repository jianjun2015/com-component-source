package com.concurrency.controller;

import com.util.encrypt.rsa.RSAUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

/**
 * Created by wangjianjun on 2017/7/21.
 */
@Controller
public class LoginController {

    @RequestMapping("/loginPage")
    public String loginPage(Model model) throws Exception {
//        model.addAttribute("reqPublicKey",RSAUtil.getKeyPair().getPublic());
        return "login";
    }

    @RequestMapping("/login")
    public String loginSys(HttpServletRequest request, Model model) throws Exception {

        String userName = request.getParameter("userName");
        String passwd = request.getParameter("passwd");

        System.out.println(userName+":"+passwd);

        String result = request.getParameter("passwd");
        System.out.println("原文加密后为：");
        System.out.println(result);
        byte[] en_result = new BigInteger(result, 16).toByteArray();
        System.out.println("转成byte[]"+new String(en_result));
        byte[] de_result = RSAUtil.decrypt(RSAUtil.getKeyPair().getPrivate(),en_result);
        System.out.println("还原密文：");

        System.out.println(new String(de_result));
        StringBuffer sb = new StringBuffer();
        sb.append(new String(de_result));
        System.out.println(sb.reverse().toString());

        return "result/success";
    }
}
