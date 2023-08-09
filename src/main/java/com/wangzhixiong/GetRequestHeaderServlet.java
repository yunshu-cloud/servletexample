package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetRequestHeaderServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String headerInfo = req.getHeader("Accept-Encoding");
        PrintWriter pw = resp.getWriter();
        pw.println("HeaderInfo - Accept-Encoding : "+headerInfo);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req,resp);
    }
}
