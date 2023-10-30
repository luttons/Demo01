package com.lutton.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @ClassName：Listener01
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class Listener01 implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    public Listener01() {
    }

    @Override // 全局作用域对象在 被创建的时候执行 （Tomcat 启动的时候）
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("全局作用于对象被创建了");
    }

    @Override // 全局作用域对象在 被销毁的时候执行（Tomcat 关闭的时候）
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("全局作用于对象被销毁了");
    }

    /**
     * 以下的方法 和上述两个方法 同样的用法
     */



//    @Override
//    public void attributeAdded(HttpSessionBindingEvent se) {
////        HttpSessionAttributeListener.super.attributeAdded(se);
//    }
//
//    @Override
//    public void attributeRemoved(HttpSessionBindingEvent se) {
////        HttpSessionAttributeListener.super.attributeRemoved(se);
//    }
//
//    @Override
//    public void attributeReplaced(HttpSessionBindingEvent se) {
////        HttpSessionAttributeListener.super.attributeReplaced(se);
//    }
//
//    @Override
//    public void sessionCreated(HttpSessionEvent se) {
////        HttpSessionListener.super.sessionCreated(se);
//    }
//
//    @Override
//    public void sessionDestroyed(HttpSessionEvent se) {
////        HttpSessionListener.super.sessionDestroyed(se);
//    }




}
