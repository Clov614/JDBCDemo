<%--
  Created by IntelliJ IDEA.
  User: Hongyi
  Date: 2023/4/12
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>登录</title>
</head>
<body>
<h1>用户登录</h1>
<form method="post" action="login.jsp">
  <label>用户名：</label>
  <input type="text" name="username" /><br />
  <label>密码：</label>
  <input type="password" name="password" /><br />
  <input type="hidden" name="action" value="login" /> <!-- 添加隐藏的 input 标签来传递 action 参数 -->
  <input type="submit" value="登录" />
  <a href="register.jsp">注册</a>
</form>
</body>
</html>

