package bus;

import dao.NhaXeDAO;
import dto.NhaXeDTO;

import java.util.ArrayList;

public class NhaXeBUS {

    public static ArrayList<NhaXeDTO> getAll() {
        return NhaXeDAO.getAll();
    }

    public static boolean updateNhaXe(int res) {
        if(res != 0) {
            NhaXeDAO.updateSoGhe();
            return true;
        }
        return false;
    }

    public static String getTenNX(String maNX) {
        return NhaXeDAO.getTenNhaXe(maNX);
    }
}
