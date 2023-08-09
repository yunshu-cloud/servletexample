package com.wangzhixiong;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 使用ServletConfig读取servlet配置信息
 */
public class GetServletConfig extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 获取ServletConfig对象
        ServletConfig servletConfig = this.getServletConfig();

        // 获取配置信息
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        PrintWriter pw = resp.getWriter();
        while(initParameterNames.hasMoreElements())
        {
            String key = initParameterNames.nextElement();
            String value = servletConfig.getInitParameter(key);
            pw.println("Key:"+key+" = "+"Value:"+value);
        }
        pw.flush();
        pw.close();
    }
}
