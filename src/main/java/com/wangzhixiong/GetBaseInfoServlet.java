package com.wangzhixiong;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取容器附加信息
 */
public class GetBaseInfoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 获取ServletContext对象
        ServletContext servletContext = this.getServletContext();

        // 获取容器信息
        String serverInfo = servletContext.getServerInfo();

        // 获取容器支持Servlet的主版本号
        int majorVersion = servletContext.getMajorVersion();

        // 获取容器支持Servlet的副板本号
        int minorVersion = servletContext.getMinorVersion();

        // 设置响应编码
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("容器基本信息："+serverInfo);
        pw.println("容器支持Servlet的版本号为："+ majorVersion+"."+minorVersion);
        pw.flush();
        pw.close();
    }
}
