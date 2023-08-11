package com.wangzhixiong;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * 文件上传
 */
@WebServlet("/fileUpload.do")
@MultipartConfig // 开启part组件 将web页面上传的字节类型的文件转化为字符型 ，令其可以由HttpServletRequest接收
public class FileUploadServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        // 获取文件描述信息
        String desc = req.getParameter("desc");
        // 获取上传文件
        Part file = req.getPart("file");

        // 生成唯一的文件名
        String newName = UUID.randomUUID().toString() + file.getSubmittedFileName().substring(file.getSubmittedFileName().lastIndexOf("."));

        // 路径转换
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("image/" + newName);

        // realPath应是部署到tomcat中webApps目录下的
        System.out.println(realPath);
        // 文件保存
        file.write(realPath);

        // 响应给客户端文件描述信息
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(desc);
        pw.flush();
        pw.close();

    }
}
