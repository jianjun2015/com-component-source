package component.authenticate;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by wangjianjun on 2017/5/26.
 */
public class MyRealm_1 implements Realm {

    @Override
    public String getName() {
        return "myRealm_1";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();//得到用户名
        String password = new String((char[])token.getCredentials());

        if (!"zhang".equals(username))
            throw new UnknownAccountException();

        if (!"123".equals(password))
            throw new IncorrectCredentialsException();

        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
