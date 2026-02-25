package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <title>Hello Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>你好，这是Hello Servlet!</h1>");
        out.println("    <p>当前时间: " + new java.util.Date() + "</p>");
        out.println("    <a href='/'>返回首页</a>");
        out.println("</body>");
        out.println("</html>");
    }
}