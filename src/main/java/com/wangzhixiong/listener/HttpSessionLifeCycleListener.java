package com.wangzhixiong.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听HttpSession生命周期的监听器
 */
public class HttpSessionLifeCycleListener implements HttpSessionListener
{
    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
        System.out.println("Session Created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        System.out.println("Session Destroyed");
    }
}
