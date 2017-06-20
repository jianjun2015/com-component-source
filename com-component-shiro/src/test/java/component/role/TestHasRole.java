package component.role;

import component.common.Common;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangjianjun on 2017/5/27.
 */
@Ignore
public class TestHasRole extends Common{

    @Test
    public void testRole() {
        super.login("classpath:shiro-role.ini","zhang","123");

        Assert.assertTrue(subject().hasRole("role1"));

        //拥有所有权限
        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1","role2")));

        //是否拥有每一个权限
        boolean[] result = subject().hasRoles(Arrays.asList("role1","role2","role3"));
        Assert.assertTrue(result[0]);
        Assert.assertTrue(result[1]);
        Assert.assertFalse(result[2]);
    }

    @Test
    public void testCheckRole(){
        login("classpath:shiro-role.ini", "zhang", "123");
        //断言拥有角色：role1
        subject().checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        subject().checkRoles("role1", "role3");
    }
}
