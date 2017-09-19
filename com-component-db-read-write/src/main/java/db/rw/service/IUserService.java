package db.rw.service;


import db.rw.entity.User;

/**
 * Created by wangjianjun on 2017/7/7.
 */
public interface IUserService {

    int insertUser(User user);

    User getUserById(Integer userId);
}
