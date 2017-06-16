package component.helloworld;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wangjianjun on 2017/5/26.
 */

public class TestHelloWorld {

    @Test
    public void testelloWorld(){

        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try {
            subject.login(token);
            System.out.println("验证成功");
        }catch (AuthenticationException e){
            System.out.println("验证失败");
        }

        Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();
    }
}
