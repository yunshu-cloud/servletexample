package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 当客户端浏览器第一次访问Servlet时响应“您好，欢迎您第一次访问！”，第二次访问时响应“欢迎您回来！”
 * 使用session实现 注：使用非默认浏览器访问
 */
public class WelcomeSessionServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(false);

        boolean flag = true;
        if(session == null)
        {
            flag = false;
            req.getSession();
        }
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(flag)
        {
            pw.println("欢迎您回来！");
            System.out.println("return ");
        }
        else
        {
            pw.println("您好，欢迎您第一次访问！");
            System.out.println("first");

        }
    }
}
