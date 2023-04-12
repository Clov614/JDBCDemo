<%--
  Created by IntelliJ IDEA.
  User: Hongyi
  Date: 2023/4/12
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h1>登录成功</h1>
<p>欢迎您，<%= request.getParameter("username") %>！</p>
<a href="index.jsp">返回首页</a>
</body>
</html>

