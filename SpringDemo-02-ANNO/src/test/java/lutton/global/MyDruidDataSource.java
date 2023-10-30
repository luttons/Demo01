package com.lutton.global;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @ClassName：MyDruidDataSource
 * @Description： TODO      相当于取代了配置文件中： id="dataSource" 的配置
 * @Author： Lut_Ton@GitHub
 */
@Component("myDruidDataSource")
public class MyDruidDataSource{
    @Value("${MYSQL_DRIVER}")
    private String driver;
    @Value("${MYSQL_URL}")
    private String url;
    @Value("${MYSQL_USER}")
    private String username;
    @Value("${MYSQL_PWD}")
    private String password;

    public DataSource getDataSource(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
