package util;

import java.sql.*;

public class DataAccessHelper {
    public Connection conn = null;


    public void displayError(SQLException ex) {
        System.out.println("Error Message: " + ex.getMessage());
        System.out.println("Error state: " + ex.getSQLState());
        System.out.println("Error Code: " + ex.getErrorCode());
    }

    public void open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager
//                    .getConnection("jdbc:mysql://remotemysql.com:3306/7jjFv7zPcq", "7jjFv7zPcq", "Eba3hfJfFj");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/doanjava", "root", "123123Mau");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if(conn != null) {
                conn.close();
            }
        }catch (SQLException ex) {
            displayError(ex);
        }
    }

    public ResultSet excuteQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            displayError(ex);
        }
        return rs;
    }

    public int excuteUpdate(String sql) {
        int rs = -1;
        try {
            Statement statement = conn.createStatement();
            rs = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            displayError(ex);
        }

        return rs;
    }

}
