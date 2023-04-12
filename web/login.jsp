<%--
  Created by IntelliJ IDEA.
  User: Hongyi
  Date: 2023/4/12
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<%@ page import="util.DBInsert" %>
<%@ page import="util.DBSelect" %>
<%@ page import="util.DBUtil" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String action = request.getParameter("action");
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        // 测试数据库连接
        conn = DBUtil.getConnection();
        if (conn != null) {
            System.out.println("数据库连接成功！");
        } else {
            System.out.println("数据库连接失败！");
        }
//        conn = DBUtil.getConnection();
        if ("login".equals(action)) {
            rs = DBSelect.executeQuery("SELECT * FROM user_table WHERE username=? AND password=?",username,password);
//            stmt = conn.prepareStatement("SELECT * FROM user_table WHERE username=? AND password=?");
//            stmt.setString(1, username);
//            stmt.setString(2, password);
//            rs = stmt.executeQuery();
            if (rs.next()) {
                // 登录成功

                response.sendRedirect("success.jsp"+"?username="+username);
            } else {
                // 登录失败
                response.sendRedirect("fail.jsp");
            }
        } else if ("register".equals(action)) {
            int result = DBInsert.executeInsert("INSERT INTO user_table (username, password) VALUES (?, ?)",username,password);
//            stmt = conn.prepareStatement("INSERT INTO user_table (username, password) VALUES (?, ?)");
//            stmt.setString(1, username);
//            stmt.setString(2, password);
//            int result = stmt.executeUpdate();
            if (result > 0) {
                // 注册成功
                response.sendRedirect("index.jsp");
            } else {
                // 注册失败
                response.sendRedirect("register.jsp"+"?err=sign up error!");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // TODO
    }
%>
