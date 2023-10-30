package com.lutton.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @ClassName：MyDruidDataSource
 * @Description： TODO      相当于取代了配置文件中： id="dataSource" 的配置
 * @Author： Lut_Ton@GitHub
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
