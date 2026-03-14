<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String ip = request.getRemoteAddr();
    String serverInfo = application.getServerInfo();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP应用首页</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .info-box { border: 1px solid #ccc; padding: 20px; margin: 20px 0; background-color: #f9f9f9; }
    </style>
</head>
<body>
    <h1>欢迎使用嵌入式JSP应用</h1>
    
    <div class="info-box">
        <h2>服务器信息</h2>
        <p>服务器信息: <%= serverInfo %></p>
        <p>您的IP地址: <%= ip %></p>
        <p>当前时间: <%= new java.util.Date() %></p>
    </div>
    
    <div class="info-box">
        <h2>JSTL 示例</h2>
        <% 
            java.util.List<String> items = new java.util.ArrayList<>();
            items.add("项目1");
            items.add("项目2");
            items.add("项目3");
            request.setAttribute("items", items);
        %>
        <ul>
            <c:forEach var="item" items="${items}">
                <li>${item}</li>
            </c:forEach>
        </ul>
    </div>
    
    <a href="/hello">访问Hello Servlet</a>
</body>
</html>