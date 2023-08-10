package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 创建Cookie对象
 */
public class CreateCookieServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 创建Cookie对象
        Cookie cookie = new Cookie("name", "yunshu");

        // 指定失效时间 一旦指定失效时间，cookie变为持久化cookie
        cookie.setMaxAge(60);
        // 将Cookie写回客户端
        resp.addCookie(cookie);

        PrintWriter pw = resp.getWriter();
        pw.println("Create Cookie Successfully!");
        pw.flush();
        pw.close();
    }
}
