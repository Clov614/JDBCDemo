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
        // �������ݿ�����
        Connection conn = DBUtil.getConnection();
        if (conn != null) {
            System.out.println("���ݿ����ӳɹ���");
        } else {
            System.out.println("���ݿ�����ʧ�ܣ�");
        }

        // ���Բ�������
        String insertSql = "INSERT INTO user_table (username, password) VALUES (?, ?)";
        try {

            int result = DBInsert.executeInsert(insertSql,"zhytest","1234");
            if (result > 0) {
                System.out.println("�������ݳɹ���");
            } else {
                System.out.println("��������ʧ�ܣ�");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // ���Բ�ѯ����
        String selectSql = "SELECT * FROM user_table WHERE username=? AND password=?";
        try {
            ResultSet rs = DBSelect.executeQuery(selectSql,"zhytest","1234");
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("�û�����" + username + "�����룺" + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // ���Ը�������
//        String updateSql = "UPDATE user_table SET password = 114514 WHERE username = 123";
//        try {
//
//            int result = DBUpdate.executeUpdate(updateSql);
//            if (result > 0) {
//                System.out.println("�������ݳɹ���");
//            } else {
//                System.out.println("��������ʧ�ܣ�");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        // ����ɾ������
        String deleteSql = "DELETE FROM user_table WHERE username = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(deleteSql);
            stmt.setString(1, "zhytest");
            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("ɾ�����ݳɹ���");
            } else {
                System.out.println("ɾ������ʧ�ܣ�");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // �ر����ݿ�����
        DBUtil.closeConnection(conn);
    }
}
