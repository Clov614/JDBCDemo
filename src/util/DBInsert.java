package util;

import java.sql.*;

public class DBInsert {
    public static int executeInsert(String sql, Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            result = pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            // ����������ͻ�����
            if (e instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("�����ظ����ݣ����Դ���");
            } else {
                e.printStackTrace();
            }
        } finally {

        }
        return result;
    }

    // ʡ�� closeResultSet��closePreparedStatement �� closeConnection ����
    // ...
}
