package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LanguageExampleServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String language = req.getHeader("Accept-Language");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(language.startsWith("zh-CN"))
        {
            pw.println("你好，中国人");
        }
        else if (language.startsWith("en-US"))
        {
            pw.println("Hello, American!");
        }
        else
        {
            pw.println("不是中国，也不是美国人！");
        }
        pw.flush();
        pw.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req,resp);
    }
}
