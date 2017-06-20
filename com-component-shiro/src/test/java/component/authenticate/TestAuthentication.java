package component.authenticate;

import component.common.Common;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by wangjianjun on 2017/5/27.
 */
@Ignore
public class TestAuthentication extends Common{

    @Test
    public void testAllSuccessfulStrategyWithSuccess(){

        login("classpath:shiro-authenticator-all-success.ini");
        Subject subject = SecurityUtils.getSubject();

        //得到一个身份集合，其包含了Realm验证成功的身份信息
        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(2,principalCollection.asList().size());
    }

    @Test(expected = UnknownAccountException.class)
    public void testAllFailStrategyWithSuccess(){

        login("classpath:shiro-authenticator-all-fail.ini");
    }

    @Test
    public void testAtLeastOneSuccessfulStrategyWithSuccess(){

        login("classpath:shiro-authenticator-atLeastOne-success.ini");

        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(2,principalCollection.asList().size());
    }

    @Test
    public void testAtLeastTwoSuccessfulStrategyWithSuccess(){

        login("classpath:shiro-authenticator-atLeastTwo-success.ini");

        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(2,principalCollection.asList().size());
    }

    @Test
    public void testOnlyOneSuccessfulStrategyWithSuccess(){

        login("classpath:shiro-authenticator-onlyone-success.ini");

        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(2,principalCollection.asList().size());
    }

    @Test
    public void testFirstSuccessfulStrategyWithSuccess(){

        login("classpath:shiro-authenticator-first-success.ini");

        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(1,principalCollection.asList().size());
    }
}
