package dao;

import dto.TuyenDTO;
import util.DataAccessHelper;

import java.sql.*;
import java.util.ArrayList;

public class TuyenDAO {

    public static ArrayList<TuyenDTO> getAll() {
        ArrayList<TuyenDTO> danhSachTuyen = new ArrayList<>();
        String sql = "select * from TUYEN";
        DataAccessHelper helper = new DataAccessHelper();

        helper.open();
        ResultSet resultSet = helper.excuteQuery(sql);
        try {

            while (resultSet.next()) {
                TuyenDTO tuyen = new TuyenDTO(
                        resultSet.getString("MANX"),
                        resultSet.getString("MATUYEN"),
                        resultSet.getString("DIEMDEN"),
                        resultSet.getString("DIEMXUATPHAT"),
                        resultSet.getDate("TGKHOIHANH"),
                        resultSet.getInt("TONGGHE"),
                        resultSet.getString("BSX"),
                        resultSet.getInt("SOLUONG"),
                        resultSet.getInt("GIA")
                );
                danhSachTuyen.add(tuyen);
            }
        } catch (SQLException ex) {

        } finally {
            helper.close();
        }

        return danhSachTuyen;
    }

}
