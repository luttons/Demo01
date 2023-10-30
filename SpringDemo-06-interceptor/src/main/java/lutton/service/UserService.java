package com.lutton.service;

import com.lutton.domain.User;

public interface UserService {
    User doLogin(String username, String password);
}
