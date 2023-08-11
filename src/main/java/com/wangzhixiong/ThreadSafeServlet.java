package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet线程安全
 */
public class ThreadSafeServlet extends HttpServlet
{
    private PrintWriter pw;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String name = req.getParameter("name");

        synchronized (this) // this指当前的servlet对象
        {
            // 多线程运行时，不同客户端浏览器对应不同的resp,之后请求的浏览器会覆盖之前的浏览器获取的pw
            pw = resp.getWriter();

            try
            {
                Thread.sleep(5000);
                pw.println(name);
                pw.flush();
                pw.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
