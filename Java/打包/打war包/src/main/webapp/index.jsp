<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ip = request.getRemoteAddr();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
    <h1>你好</h1>
    <p>您的IP地址是: <%= ip %></p>
</body>
</html>
