package com.wangzhixiong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GetRequestDataServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 设置请求编码 控制台输出乱码解决
        req.setCharacterEncoding("utf-8");

        // 获取用户名
        String username = req.getParameter("username");
        System.out.println(username);

        // 获取用户密码
        String userpwd =  req.getParameter("userpwd");

        // 获取复选框的值
        String[] hobby = req.getParameterValues("hobby");
        List<String> list = Arrays.asList(hobby);

        // 获取所有提交数据的key
        Enumeration<String> parameterNames = req.getParameterNames();
        List<String> paraList = new ArrayList<>();
        while(parameterNames.hasMoreElements())
        {
            paraList.add(parameterNames.nextElement());
        }

        // 使用Map结构获取提交数据
        Map<String, String[]> parameterMap = req.getParameterMap();
        Iterator<Map.Entry<String,String[]>> iterator = parameterMap.entrySet().iterator();


        PrintWriter pw = resp.getWriter();
        pw.println("UserName:"+username);
        pw.println("Password:"+userpwd);
        pw.println("Hobby:"+list);
        pw.println("Names:"+paraList);

        while(iterator.hasNext())
        {
            Map.Entry<String,String[]> entry = iterator.next();
            String key = entry.getKey();
            String[] value = entry.getValue();
            pw.println(key+" = "+ Arrays.asList(value));

        }

        pw.flush();
        pw.close();
    }
}
