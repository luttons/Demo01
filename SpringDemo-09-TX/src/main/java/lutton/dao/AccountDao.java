package com.lutton.dao;

/**
 * @ClassName：AccountDao
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public interface AccountDao {
    void out(String outName, int money);
    void in(String inName, int money);
}
