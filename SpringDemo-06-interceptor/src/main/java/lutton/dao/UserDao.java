package com.lutton.dao;

import com.lutton.domain.User;

public interface UserDao {
    User loginCheck(String username, String password);
}
