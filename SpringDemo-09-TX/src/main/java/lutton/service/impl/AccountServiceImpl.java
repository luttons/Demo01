package com.lutton.service.impl;

import com.lutton.dao.AccountDao;
import com.lutton.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName：AccountServiceImpl
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional   // 事务处理，可以有参数
    public void transfer(String outName, String inName, int money) {
        accountDao.out(outName, money);
        int num = 3077 / 0;
        accountDao.in(inName, money);
    }
}
