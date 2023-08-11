package com.wangzhixiong;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 基于注解方式开发Servlet
 */
@WebServlet(urlPatterns = "/ann.do",initParams = {@WebInitParam(name = "name",value = "yunshu"),@WebInitParam(name = "sex",value = "male")},loadOnStartup = 1)

public class AnnotationServlet extends HttpServlet
{
    @Override
    public void init() throws ServletException
    {
        ServletConfig servletConfig = this.getServletConfig();
        String name = servletConfig.getInitParameter("name");
        String sex = servletConfig.getInitParameter("sex");
        System.out.println(name);
        System.out.println(sex);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter pw = resp.getWriter();
        ServletConfig servletConfig = this.getServletConfig();
        String name = servletConfig.getInitParameter("name");
        String sex = servletConfig.getInitParameter("sex");
        pw.println("name = "+name);
        pw.println("sex = "+sex);
        pw.println("Annotation Servlet ....");
        pw.flush();
        pw.close();
    }
}
