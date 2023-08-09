package com.wangzhixiong;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 全局容器的使用
 */
public class GlobalContainerServlet extends HttpServlet
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
        String name = (String) servletContext.getAttribute("name");
        String sex = (String) servletContext.getAttribute("sex");
        String hobby = (String) servletContext.getAttribute("hobby");
        String country = (String) servletContext.getAttribute("country");
        PrintWriter pw = resp.getWriter();
        pw.println("name:"+name);
        pw.println("sex:"+sex);
        pw.println("hobby:"+hobby);
        pw.println("country:"+country);
        pw.flush();
        pw.close();
    }

    /**
     * 向ServletContext对象中添加初始化数据
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException
    {
        // 获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("name","yunshu");
        servletContext.setAttribute("sex","male");
        servletContext.setAttribute("country","china");
        servletContext.setAttribute("hobby","jogging");
    }
}
