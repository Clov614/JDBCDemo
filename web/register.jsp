    <%--
      Created by IntelliJ IDEA.
      User: Hongyi
      Date: 2023/4/12
      Time: 8:58
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>注册</title>
    </head>
    <body>
    <h1>用户注册</h1>
    <form method="post" action="login.jsp">
        <%
            String err = request.getParameter("err");
            if (err != null) {
                out.println("请重新登录：<font color=\"red\">"+err+"</font><br>");
            }

        %>
        <label>用户名：</label>
        <input type="text" name="username" /><br />
        <label>密码：</label>
        <input type="password" name="password" /><br />
        <input type="hidden" name="action" value="register" /> <!-- 添加隐藏的 input 标签来传递 action 参数 -->
        <input type="submit" value="注册" />
        <a href="index.jsp">返回登录</a>
    </form>
    </body>
    </html>

