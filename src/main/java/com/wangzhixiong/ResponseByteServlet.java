package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节型响应
 */
public class ResponseByteServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 给定读取响应图片的路径 此图片在我本机上 同好们可选择自己本机上的随意一张图片
        File file = new File("/Users/wangzhixiong/Pictures/sakura.jpg");

        // 创建读取图片的IO流对象
        InputStream is = new FileInputStream(file);

        // 创建图片缓冲区，即byte字节的数组
        byte[] buff = new byte[is.available()];

        // 将图片放入字节数组中
        is.read(buff);

        // 产生响应类型
        resp.setContentType("image/jpeg");

        // 产生字节型响应
        ServletOutputStream os = resp.getOutputStream();

        os.write(buff);
        os.flush();
        os.close();


    }
}
