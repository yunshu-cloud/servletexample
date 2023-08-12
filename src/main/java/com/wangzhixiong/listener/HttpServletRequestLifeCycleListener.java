package com.wangzhixiong.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 监听HttpServletRequest生命周期的监听器
 */
public class HttpServletRequestLifeCycleListener implements ServletRequestListener
{
    @Override
    public void requestDestroyed(ServletRequestEvent sre)
    {
        System.out.println("------------ Start requestDestroyed ------------");
        System.out.println((HttpServletRequest)sre.getServletRequest());
        System.out.println("------------ End requestDestroyed ------------");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre)
    {
        System.out.println("------------ Start requestInitialized ------------");
        System.out.println((HttpServletRequest)sre.getServletRequest());
        System.out.println("------------ End requestInitialized ------------");
    }
}
