package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class GetRequestDataServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 获取用户名
        String username = req.getParameter("username");

        // 获取用户密码
        String userpwd =  req.getParameter("userpwd");

        // 获取复选框的值
        String[] hobby = req.getParameterValues("hobby");
        List<String> list = Arrays.asList(hobby);


        PrintWriter pw = resp.getWriter();
        pw.println("UserName:"+username);
        pw.println("Password:"+userpwd);
        pw.println("Hobby:"+list);

        pw.flush();
        pw.close();
    }
}
