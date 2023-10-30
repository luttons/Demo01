package com.lutton.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName：SpringConfiguration
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */



@Configuration   // 标注当前类为核心配置文件类
@ComponentScan("com.lutton")  // 配置 要扫描的注解的路径
// 导入一个配置文件
@Import(DataSourceConfiguration.class)   // 导入其他的 配置文件类
// 导入多个配置文件
//@Import( {DataSourceConfiguration.class,   ,      ,    , } )
public class SpringConfiguration {
}
