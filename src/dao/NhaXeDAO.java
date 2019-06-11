package dao;

import dto.NhaXeDTO;
import util.DataAccessHelper;



import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static util.Session.ssNhaXe;

public class NhaXeDAO {
    public static ArrayList<NhaXeDTO> getAll() {

        ArrayList<NhaXeDTO> dsNhaXe = new ArrayList<NhaXeDTO>();
        String sql = "SELECT * FROM NHAXE";
        DataAccessHelper helper = new DataAccessHelper();

        try {
            helper.open();
            ResultSet rs = helper.excuteQuery(sql);
            while (rs.next()) {
                NhaXeDTO nhaXe = new NhaXeDTO();
                nhaXe.setMaNX(rs.getString("MANX"));
                nhaXe.setTenNX(rs.getString("TENNX"));
                nhaXe.setDiaChi(rs.getString("DIACHI"));
                nhaXe.setUsername(rs.getString("USERNAME"));
                nhaXe.setPassword(rs.getString("PASS"));
                nhaXe.setSoTuyen(rs.getInt("SOTUYEN"));

                dsNhaXe.add(nhaXe);
            }
        } catch (SQLException ex) {
            helper.displayError(ex);
        } finally {
            helper.close();
        }
        return dsNhaXe;
    }

    public static int updateSoGhe() {
        int res = -1;
        DataAccessHelper helper = new DataAccessHelper();
        String sql = "UPDATE NHAXE SET SOTUYEN = SOTUYEN + 1 WHERE MANX = " + ssNhaXe.getMaNX();

        helper.open();
        res = helper.excuteUpdate(sql);

        helper.close();
        return res;
    }

    public static String getTenNhaXe(String maNX) {
        String sql = "SELECT TENNX FROM NHAXE WHERE MANX = " + maNX;
        DataAccessHelper helper = new DataAccessHelper();
        String tenNX = "";
        helper.open();
        ResultSet rs;
        try {
            rs = helper.excuteQuery(sql);
            rs.next();
            tenNX = rs.getString("TENNX");
        } catch (SQLException ex) {
            helper.displayError(ex);
        }
        helper.close();
        return tenNX;
    }

}
