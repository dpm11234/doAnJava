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

//    public static void main(String[] args) {
//        DataAccessHelper helper = new DataAccessHelper();
//        String sql = "insert into TUYEN values('0002', '0002N2', 'Tp.HCM', N'Đồng Nai', '2019-05-24 14:00:00', 16, '60N2-7249', 2, 95000)";
//        helper.open();
////            ResultSet rs = helper.excuteQuery("SELECT * FROM NHAXE");
////            while (rs.next()) {
////                System.out.println(rs.getString(1)+" "+rs.getString(2) + " " + rs.getString(3)+" "+rs.getString(4));
////            }
//
//        int rs = helper.excuteUpdate(sql);
//
//        System.out.println(rs);
//
//        helper.close();
//    }

}
