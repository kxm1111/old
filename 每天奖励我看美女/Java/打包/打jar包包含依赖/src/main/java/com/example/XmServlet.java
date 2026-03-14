package com.example;

import com.alibaba.fastjson.JSON;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class XmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用fastjson创建JSON数据 {name:"小美"}
        Map<String, String> data = new HashMap<>();
        data.put("name", "小美");

        // 转换为JSON字符串
        String jsonString = JSON.toJSONString(data);

        // 设置响应内容类型和编码
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // 输出JSON到页面
        PrintWriter out = resp.getWriter();
        out.print(jsonString);
        out.flush();
    }
}
