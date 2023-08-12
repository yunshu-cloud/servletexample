package com.wangzhixiong.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * 基于注解式开发Filter
 */

@WebFilter(urlPatterns = "/*",initParams = {@WebInitParam(name="name",value = "yunshu")})
public class AnnotationFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println(filterConfig.getInitParameter("name"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("Annotation Filter ...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy()
    {
        Filter.super.destroy();
    }
}
