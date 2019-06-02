package dao;

import dto.TuyenDTO;
import util.DataAccessHelper;
import static util.Session.*;

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
                        resultSet.getTimestamp("TGKHOIHANH"),
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

    public static ArrayList<TuyenDTO> getAllByMaNX() {
        ArrayList<TuyenDTO> danhSachTuyen = new ArrayList<>();
        String sql = "select * from TUYEN WHERE MANX = " + ssNhaXe.getMaNX();
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
                        resultSet.getTimestamp("TGKHOIHANH"),
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

    public static int addTicket(TuyenDTO tuyen) {
        String sql = "INSERT INTO TUYEN VALUES ('" + tuyen.getMaNX() + "', '" + tuyen.getMaTuyen() + "', N'" + tuyen.getDiemXuatPhat() + "', N'" + tuyen.getDiemDen() + "', '" + tuyen.getThoiGianKhoiHanh() + "'," + tuyen.getTongGhe() + "," + "'" + tuyen.getBienSoXe() + "'," + tuyen.getSoLuong() + "," + tuyen.getGia() + ");";
        DataAccessHelper helper = new DataAccessHelper();
        int res = -1;

        helper.open();

        res = helper.excuteUpdate(sql);

        helper.close();
        return res;
    }

    public static int deleteTicket(String maTuyen) {
        String sql = "DELETE FROM TUYEN WHERE MATUYEN = '" + maTuyen + "'";
        DataAccessHelper helper = new DataAccessHelper();
        int res = -1;
        helper.open();

        res = helper.excuteUpdate(sql);

        helper.close();
        return res;
    }

}
