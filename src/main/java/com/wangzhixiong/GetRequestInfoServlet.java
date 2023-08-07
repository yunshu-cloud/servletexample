package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取请求信息
 */
public class GetRequestInfoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 获取浏览器发出请求的完整的URL
        String requestURL = req.getRequestURL().toString();

        // 获取请求行中指定资源部分
        String requestURI = req.getRequestURI();

        // 获取发出请求的客户端IP地址
        String remoteAddr = req.getRemoteAddr();

        // 获取服务端IP地址
        String localAddr = req.getLocalAddr();

        // 获取服务端监听端口
        int localPort = req.getLocalPort();

        // 输出
        PrintWriter writer = resp.getWriter();

        writer.println("URL:"+requestURL);
        writer.println("URI:"+requestURI); // 不加主机ip和端口
        writer.println("ClientAddr:"+remoteAddr);
        writer.println("Server:"+localAddr);
        writer.println("Port:"+localPort);

        writer.flush();
        writer.close();



    }
}
