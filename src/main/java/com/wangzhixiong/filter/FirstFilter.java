package com.wangzhixiong.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 第一个Filter案例
 */
public class FirstFilter implements Filter
{
    /**
     * 当Filter对象被实例化后，会立即调用的一个方法
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("Init...");
    }

    /**
     * 过滤请求与响应
     * @param servletRequest
     * @param servletResponse
     * @param filterChain 对请求放行
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        // 在servlet处理之前可以做的操作
        System.out.println("previous");
        // 对请求做放行
        filterChain.doFilter(servletRequest,servletResponse);

        // 在servlet处理之后做的操作
        System.out.println("later");
    }

    /**
     * 当filter对象在销毁之前会调用一次此方法
     */
    @Override
    public void destroy()
    {
        Filter.super.destroy();
    }
}
