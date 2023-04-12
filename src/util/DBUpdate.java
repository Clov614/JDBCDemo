package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUpdate {
    public static int executeUpdate(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        int result = 0;
        try {
            conn = DBUtil.getConnection();
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
        return result;
    }

    private static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
