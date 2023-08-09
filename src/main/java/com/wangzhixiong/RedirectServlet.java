package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 重定向响应(无感知)
 */
public class RedirectServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 设置请求编码
        req.setCharacterEncoding("utf-8");

        // 获取搜索数据
        String search = req.getParameter("search");
        // 产生重定向响应
        /**
         * 产生状态码302 发生两次请求两次响应
         * 重定向的URL是由客户端浏览器发送的
         * 浏览器地址栏会有变化
         */
        resp.sendRedirect("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd="+ URLEncoder.encode(search,"utf-8"));
    }
}
