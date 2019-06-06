package dao;

import dto.KhachHangDTO;
import util.DataAccessHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhachHangDAO {

    public static ArrayList<KhachHangDTO> getAll(String maNX, String maTuyen) {

        DataAccessHelper helper = new DataAccessHelper();
        ArrayList<KhachHangDTO> danhSachKhachHang = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG WHERE MANX = '" + maNX + "' AND MATUYEN = '" + maTuyen + "'";

        helper.open();

        ResultSet resultSet = helper.excuteQuery(sql);

        try {
            while (resultSet.next()) {
                KhachHangDTO khachHang = new KhachHangDTO(
                        resultSet.getInt("ID"),
                        resultSet.getString("MANX"),
                        resultSet.getString("MATUYEN"),
                        resultSet.getString("HOTEN"),
                        resultSet.getString("SDT"),
                        resultSet.getInt("SOVEDAT"),
                        resultSet.getTimestamp("THOIGIANDAT")
                );
                danhSachKhachHang.add(khachHang);
            }
        } catch (SQLException ex) {
            helper.displayError(ex);
        }

        helper.close();

        return danhSachKhachHang;
    }

    public static int addCustomer(KhachHangDTO khachHang) {
        int res = 0;
        DataAccessHelper helper = new DataAccessHelper();

        String sql = "INSERT INTO KHACHHANG(MANX, MATUYEN, HOTEN, SDT, SOVEDAT, THOIGIANDAT) VALUES('"
                + khachHang.getMaNX()
                + "', '" + khachHang.getMaTuyen()
                + "', N'" + khachHang.getHoTen()
                + "', '" + khachHang.getSdt()
                + "', " + khachHang.getSoVeDat()
                + ", '" + khachHang.getThoiGianDat() + "')";

        helper.open();

        res = helper.excuteUpdate(sql);

        helper.close();

        return res;
    }

    public static int deleteCustomer(int id) {
        int res = 0;
        DataAccessHelper helper = new DataAccessHelper();

        String sql = "DELETE FROM KHACHHANG WHERE id = " + id;

        helper.open();

        res = helper.excuteUpdate(sql);

        helper.close();

        return res;

    }

}
