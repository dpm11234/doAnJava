package dao;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import dto.TuyenDTO;
import util.DataAccessHelper;
import static util.Session.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TuyenDAO {

    public static ArrayList<TuyenDTO> getAll() {
        ArrayList<TuyenDTO> danhSachTuyen = new ArrayList<>();
        String sql = "SELECT * FROM TUYEN WHERE MANX = '" + ssNhaXe.getMaNX() + "' ORDER BY TGKHOIHANH ASC;";
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

    public static ArrayList<TuyenDTO> getAllByStart(String startingPoint, LocalDateTime time) {
        String sql = "SELECT * FROM TUYEN WHERE DIEMXUATPHAT = '" + startingPoint + "' AND YEAR(TGKHOIHANH) = '" + time.getYear() + "' AND MONTH(TGKHOIHANH) = '" + time.getMonthValue() + "' AND DAY(TGKHOIHANH) = '" + time.getDayOfMonth() + "' AND MANX = '" + ssNhaXe.getMaNX() + "' ORDER BY TGKHOIHANH ASC;";
        DataAccessHelper helper = new DataAccessHelper();
        helper.open();

        ResultSet resultSet = null;
        ArrayList<TuyenDTO> danhSachTuyen = new ArrayList<>();
        try {
            resultSet = helper.excuteQuery(sql);

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
        } finally {
            helper.close();
        }

        return danhSachTuyen;
    }

    public static ArrayList<TuyenDTO> getAllByDest(String dest, LocalDateTime time) {
        String sql = "SELECT * FROM TUYEN WHERE DIEMDEN = '" + dest + "' AND YEAR(TGKHOIHANH) = '" + time.getYear() + "' AND MONTH(TGKHOIHANH) = '" + time.getMonthValue() + "' AND DAY(TGKHOIHANH) = '" + time.getDayOfMonth() + "' AND MANX = '" + ssNhaXe.getMaNX() + "' ORDER BY TGKHOIHANH ASC;";
        DataAccessHelper helper = new DataAccessHelper();
        helper.open();

        ResultSet resultSet = null;
        ArrayList<TuyenDTO> danhSachTuyen = new ArrayList<>();
        try {
            resultSet = helper.excuteQuery(sql);

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
        } finally {
            helper.close();
        }

        return danhSachTuyen;
    }

    public static ArrayList<TuyenDTO> getAllByTime(LocalDateTime time) {
        String sql = "SELECT * FROM TUYEN WHERE YEAR(TGKHOIHANH) = '" + time.getYear() + "' AND MONTH(TGKHOIHANH) = '" + time.getMonthValue() + "' AND DAY(TGKHOIHANH) = '" + time.getDayOfMonth() + "' AND MANX = '" + ssNhaXe.getMaNX() + "' ORDER BY TGKHOIHANH ASC;";
        DataAccessHelper helper = new DataAccessHelper();
        helper.open();
        System.out.println(sql);
        ResultSet resultSet = null;
        ArrayList<TuyenDTO> danhSachTuyen = new ArrayList<>();
        try {
            resultSet = helper.excuteQuery(sql);

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
        } finally {
            helper.close();
        }

        return danhSachTuyen;
    }

    public static ArrayList<TuyenDTO> getAllByMaNX() {
        ArrayList<TuyenDTO> danhSachTuyen = new ArrayList<>();
        String sql = "select * from TUYEN WHERE MANX = '" + ssNhaXe.getMaNX() + "' ORDER BY TGKHOIHANH ASC;";
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
            helper.displayError(ex);
        } finally {
            helper.close();
        }

        return danhSachTuyen;
    }

    public static int addTicket(TuyenDTO tuyen) {
        String sql = "INSERT INTO TUYEN VALUES ('" + tuyen.getMaNX() + "', '" + tuyen.getMaTuyen() + "', N'" + tuyen.getDiemDen() + "', N'" + tuyen.getDiemXuatPhat() + "', '" + tuyen.getThoiGianKhoiHanh() + "'," + tuyen.getTongGhe() + "," + "'" + tuyen.getBienSoXe() + "'," + tuyen.getSoLuong() + "," + tuyen.getGia() + ");";
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

        int res = -1;
        helper.open();

        res = helper.excuteUpdate(sql);

        helper.close();
        return res;
    }

    public static ArrayList<TuyenDTO> getAllByTrip(String startingPoint, String destination, LocalDateTime time) {

        String sql = "SELECT * FROM TUYEN WHERE DIEMDEN = N'" + destination + "' AND DIEMXUATPHAT = N'" + startingPoint + "' AND YEAR(TGKHOIHANH) = '" + time.getYear() + "' AND MONTH(TGKHOIHANH) = '" + time.getMonthValue() + "' AND DAY(TGKHOIHANH) = '" + time.getDayOfMonth() + "' ORDER BY TGKHOIHANH ASC;";
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

    public static ArrayList<TuyenDTO> getAllByTripClient(String startingPoint, String destination, LocalDateTime time) {

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDateTime now = LocalDateTime.now();

        String sql = "SELECT * FROM TUYEN WHERE DIEMDEN = N'" + destination + "' AND DIEMXUATPHAT = N'" + startingPoint + "' AND YEAR(TGKHOIHANH) = '" + time.getYear() + "' AND MONTH(TGKHOIHANH) = '" + time.getMonthValue() + "' AND DAY(TGKHOIHANH) = '" + time.getDayOfMonth() + "' AND YEAR(TGKHOIHANH) >= '" + now.getYear() + "' AND MONTH(TGKHOIHANH) >= '" + now.getMonthValue() + "' AND DAY(TGKHOIHANH) >= '" + now.getDayOfMonth() + "' ORDER BY TGKHOIHANH ASC;";
        DataAccessHelper helper = new DataAccessHelper();
        ArrayList<TuyenDTO> danhSachTuyen = new ArrayList<>();
        System.out.println(sql);
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

    public static ArrayList<TuyenDTO> getAllByTripAndMaNX(String startingPoint, String destination, LocalDateTime time) {

        String sql = "SELECT * FROM TUYEN, NHAXE WHERE DIEMDEN = N'" + destination + "' AND DIEMXUATPHAT = N'" + startingPoint + "' AND YEAR(TGKHOIHANH) = '" + time.getYear() + "' AND MONTH(TGKHOIHANH) = '" + time.getMonthValue() + "' AND DAY(TGKHOIHANH) = '" + time.getDayOfMonth() + "' AND MANX = '" + ssNhaXe.getMaNX() + "' ORDER BY TGKHOIHANH ASC;";
        DataAccessHelper helper = new DataAccessHelper();
        ArrayList<TuyenDTO> danhSachTuyen = new ArrayList<>();
        System.out.println(sql);
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
}
