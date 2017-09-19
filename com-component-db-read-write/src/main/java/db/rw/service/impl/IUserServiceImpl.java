package db.rw.service.impl;

import db.rw.dao.TUserMapper;
import db.rw.entity.User;
import db.rw.module.TUser;
import db.rw.service.IUserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangjianjun on 2017/7/7.
 */
@Service
public class IUserServiceImpl implements IUserService {

    private TUserMapper userWriteMapper;
    private TUserMapper userReadMapper;

    @Resource(name = "sqlSessionMaster")
    public void setUserWriteMapper(SqlSession sqlSession) {
        this.userWriteMapper = sqlSession.getMapper(TUserMapper.class);
    }

    @Resource(name = "sqlSessionSlave")
    public void setUserReadMapper(SqlSession sqlSession) {
        this.userReadMapper = sqlSession.getMapper(TUserMapper.class);
    }

    @Override
    public int insertUser(User user) {

        return userWriteMapper.insert(writeTUser(user));
    }

    @Override
    public User getUserById(Integer userId) {
        return writeUser(userReadMapper.selectByPrimaryKey(userId));
    }


    private TUser writeTUser(User user){

        TUser tUser = new TUser();
        tUser.setUserId(user.getUserId());
        tUser.setUserName(user.getUserName());
        tUser.setUserBirthday(user.getUserBirthday());
        tUser.setUserSalary(user.getUserSalary());

        return tUser;
    }

    private User writeUser(TUser tUser){

        User user = new User();
        user.setUserId(tUser.getUserId());
        user.setUserName(tUser.getUserName());
        user.setUserBirthday(tUser.getUserBirthday());
        user.setUserSalary(tUser.getUserSalary());

        return user;
    }
}
