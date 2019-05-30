package dao;

import dto.NhaXeDTO;
import util.DataAccessHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
