package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自启动Servlet
 */
public class AutoStartServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter pw = resp.getWriter();
        pw.println("AutoServlet....");
        pw.flush();
        pw.close();
    }

    @Override
    public void init() throws ServletException
    {
        System.out.println("AutoStartServlet Init....");
    }
}
