package info;

import util.DBInsert;
import util.DBSelect;
import util.DBUpdate;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtilTest {
    public static void main(String[] args) throws SQLException {
        // 测试数据库连接
        Connection conn = DBUtil.getConnection();
        if (conn != null) {
            System.out.println("数据库连接成功！");
        } else {
            System.out.println("数据库连接失败！");
        }

        // 测试插入数据
        String insertSql = "INSERT INTO user_table (username, password) VALUES (?, ?)";
        try {

            int result = DBInsert.executeInsert(insertSql,"zhytest","1234");
            if (result > 0) {
                System.out.println("插入数据成功！");
            } else {
                System.out.println("插入数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 测试查询数据
        String selectSql = "SELECT * FROM user_table WHERE username=? AND password=?";
        try {
            ResultSet rs = DBSelect.executeQuery(selectSql,"zhytest","1234");
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("用户名：" + username + "，密码：" + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 测试更新数据
//        String updateSql = "UPDATE user_table SET password = 114514 WHERE username = 123";
//        try {
//
//            int result = DBUpdate.executeUpdate(updateSql);
//            if (result > 0) {
//                System.out.println("更新数据成功！");
//            } else {
//                System.out.println("更新数据失败！");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        // 测试删除数据
        String deleteSql = "DELETE FROM user_table WHERE username = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(deleteSql);
            stmt.setString(1, "zhytest");
            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("删除数据成功！");
            } else {
                System.out.println("删除数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 关闭数据库连接
        DBUtil.closeConnection(conn);
    }
}
