package com.lutton.global;

import java.util.List;

/**
 * @ClassName：MyValueObject
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class MyValueObject {
//    用户的集合
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "MyValueObject{" +
                "userList=" + userList +
                '}';
    }
}
