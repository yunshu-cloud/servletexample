package com.wangzhixiong;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext属性监听器测试Servlet
 */
@WebServlet("/attr.do")
public class ServletContextAttrServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("key","yunshu");
        servletContext.setAttribute("key","wangzhixiong");
        servletContext.removeAttribute("key");
    }
}
