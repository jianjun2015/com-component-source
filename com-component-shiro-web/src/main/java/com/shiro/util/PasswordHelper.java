package com.shiro.util;

import com.shiro.entity.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by wangjianjun on 2017/6/1.
 */
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator
            =new SecureRandomNumberGenerator();

    private String algoritheName = "md5";
    private final int hashIterations = 2;

    public void encrypPassword(User user){

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algoritheName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getLoginName()+user.getSalt()),
                hashIterations
        ).toHex();

        user.setPassword(newPassword);
    }

    public Boolean checkOnlyPassword(User user,String passwd){

        String checkPassword = new SimpleHash(
                algoritheName,
                passwd,
                ByteSource.Util.bytes(user.getLoginName()+user.getSalt()),
                hashIterations
        ).toHex();

        if (user.getPassword().equals(checkPassword))
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        PasswordHelper helper = new PasswordHelper();

        User user = new User();
        user.setLoginName("zhangsan");
        user.setUserName("zhangsan");
        user.setPassword("123456");

        helper.encrypPassword(user);

        System.out.println(user.getPassword());
    }
}
