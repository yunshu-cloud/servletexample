package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetRequestDataServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 获取用户名
        String username = req.getParameter("username");

        // 获取用户密码
        String userpwd =  req.getParameter("userpwd");

        PrintWriter pw = resp.getWriter();
        pw.println("UserName:"+username);
        pw.println("Password:"+userpwd);
        pw.flush();
        pw.close();
    }
}
