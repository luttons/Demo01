package com.lutton.global;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @ClassName：MyDruidDataSource
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

/**
 *  @PropertySource("classpath:jdbc.properties") 取代导入外部 properties 文件的操作
 *  @Bean("dataSource")  // 把当前方法的返回值：dataSource 返回到配置文件，作为一个 bean 对象
 */


@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {
    @Value("${MYSQL_DRIVER}")
    private String driver;
    @Value("${MYSQL_URL}")
    private String url;
    @Value("${MYSQL_USER}")
    private String username;
    @Value("${MYSQL_PWD}")
    private String password;


    @Bean("dataSource")  // 把当前方法的返回值：dataSource 返回到配置文件，作为一个 bean 对象
    public DataSource getDataSource(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
