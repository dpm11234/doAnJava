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

//    public static void main(String[] args) {
//        DataAccessHelper helper = new DataAccessHelper();
//        helper.open();
//        try {
//            ResultSet rs = helper.excuteQuery("SELECT * FROM NHAXE");
//            while (rs.next()) {
//                System.out.println(rs.getString(1)+" "+rs.getString(2) + " " + rs.getString(3)+" "+rs.getString(4));
//            }
//        } catch (SQLException ex) {
//            helper.displayError(ex);
//        }
//        helper.close();
//    }

}
