package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 设置字符型响应
 */
public class ResponseCharacterServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 响应类型默认为text/html 设置为text/plain就是纯文本输出
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html lang=en>");
        pw.println("<head>");
        pw.println("<meta charset=UTF-8>");
        pw.println("<title>Document</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<font color=blue>百战程序员</font>");
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();;
    }
}
