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
        String sql2 = "DELETE FROM KHACHHANG WHERE MATUYEN = '" + maTuyen + "'";
        DataAccessHelper helper = new DataAccessHelper();
        int res = -1;
        helper.open();

        res = helper.excuteUpdate(sql2);
        helper.excuteUpdate(sql);
        helper.close();
        return res;
    }

    public static int editTicket(String maTuyen, TuyenDTO tuyen) {
        String sql = "UPDATE TUYEN SET DIEMDEN = " + "N'" + tuyen.getDiemDen() + "'" + ", DIEMXUATPHAT = " + "N'" + tuyen.getDiemXuatPhat() + "'" + ", TGKHOIHANH = " + "'" + tuyen.getThoiGianKhoiHanh() + "'" + ", TONGGHE = " + tuyen.getTongGhe() + ", BSX = " + "'" + tuyen.getBienSoXe() + "'" + ", SOLUONG = " + tuyen.getSoLuong() + ",GIA = " + tuyen.getGia() + " WHERE MATUYEN = '" + maTuyen + "'";
        DataAccessHelper helper = new DataAccessHelper();
        System.out.println(sql);
        int res = -1;
        helper.open();

        res = helper.excuteUpdate(sql);

        helper.close();
        return res;
    }

    public static ArrayList<TuyenDTO> getAllByTrip(String startingPoint, String destination) {

        String sql = "SELECT * FROM TUYEN WHERE DIEMDEN = N'" + destination + "' AND DIEMXUATPHAT = N'" + startingPoint + "';";
        DataAccessHelper helper = new DataAccessHelper();

        ArrayList<TuyenDTO> danhSachTuyen = new ArrayList<>();

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
            helper.displayError(ex);
        }

        return danhSachTuyen;
    }

    public static int countEmptySeat(String maTuyen) {
        String sql = "SELECT TONGGHE, SOLUONG FROM TUYEN WHERE MATUYEN = " + "'" + maTuyen + "'";
        String sql2 = "SELECT COUNT(MATUYEN), SUM(SOVEDAT) FROM KHACHHANG WHERE MATUYEN = " + "'" + maTuyen + "'";
        DataAccessHelper helper = new DataAccessHelper();
        helper.open();
        ResultSet resultSet = helper.excuteQuery(sql);
        ResultSet resultSet2 = helper.excuteQuery(sql2);
        int result = 0;
        int count = 0;
        int tongGhe = 0;
        int daDat = 0;
        int datTruoc = 0;
        try {
            while (resultSet2.next()) {
                count = resultSet2.getInt("COUNT(MATUYEN)");
                daDat = resultSet2.getInt("SUM(SOVEDAT)");
            }
            while (resultSet.next()) {
                tongGhe = resultSet.getInt("TONGGHE");
                datTruoc = resultSet.getInt("SOLUONG");
                if (count == 0) {
                    daDat = 0;
                }
                result = tongGhe - daDat - datTruoc;
            }
        } catch (SQLException ex) {
            helper.displayError(ex);
        }
        return result;
    }

}
