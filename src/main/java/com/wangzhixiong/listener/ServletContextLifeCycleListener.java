package com.wangzhixiong.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext对象生命周期监听器
 */
public class ServletContextLifeCycleListener implements ServletContextListener
{
    // 监听ServletContext对象创建的监听方法
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        ServletContext sc = sce.getServletContext();
        System.out.println(sc);
        System.out.println("ServletContext Init...");
    }

    // 监听ServletContext对象销毁的监听方法
    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        ServletContext sc = sce.getServletContext();
        System.out.println(sc);
        System.out.println("ServletContext Destroy...");
    }
}
