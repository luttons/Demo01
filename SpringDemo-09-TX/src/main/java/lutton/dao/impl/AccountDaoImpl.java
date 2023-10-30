package com.lutton.dao.impl;

import com.lutton.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName：AccountDaoImpl
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(String outName, int money) {
        int rows = jdbcTemplate.update("update `account` set money=money-? where name=?", money, outName);

        System.out.println("out is running!..... rows = " + rows);
    }

    @Override
    public void in(String inName, int money) {
        int rows = jdbcTemplate.update("update `account` set money=money+? where name=?", money, inName);

        System.out.println("in is running!..... rows = " + rows);
    }
}
