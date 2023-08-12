package com.wangzhixiong.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * ServletContext属性操作监听器
 */
public class ServletContextAttrListener implements ServletContextAttributeListener
{
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae)
    {
        System.out.println("------- Start attributeAdded -----------");
        System.out.println("Name: "+scae.getName()+"  Value:"+scae.getValue());
        System.out.println(scae.getServletContext());
        System.out.println("------- End attributeAdded -----------");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae)
    {
        System.out.println("------- Start attributeRemoved -----------");
        System.out.println("Name: "+scae.getName()+"  Value:"+scae.getValue());
        System.out.println(scae.getServletContext());
        System.out.println("------- End attributeRemoved -----------");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae)
    {
        System.out.println("------- Start Replaced -----------");
        System.out.println("Name: "+scae.getName()+"  Value:"+scae.getValue());
        System.out.println(scae.getServletContext());
        System.out.println("------- End Replaced -----------");
    }
}
