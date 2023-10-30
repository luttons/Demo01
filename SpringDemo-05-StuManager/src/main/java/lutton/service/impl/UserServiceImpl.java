package com.lutton.service.impl;

import com.lutton.dao.UserDao;
import com.lutton.domain.User;
import com.lutton.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    @Override
    public User doLogin(String username, String password) {
        System.out.println("11");
        User user = userDao.loginCheck(username, password);
        System.out.println(user);
        System.out.println("22");
        return user;
    }
}
