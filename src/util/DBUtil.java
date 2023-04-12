package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static String username = "root";
    private static String password = "i614614.";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/db";
    static {
        try {
            Class.forName(driverName);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化连接错误");
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL,username,password);
    }
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("数据库连接已关闭！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
