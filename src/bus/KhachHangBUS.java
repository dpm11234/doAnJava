package bus;

import dao.KhachHangDAO;
import dto.KhachHangDTO;

import java.util.ArrayList;

public class KhachHangBUS {

    public static ArrayList<KhachHangDTO> getAll(String maNX, String maTuyen) {
        return KhachHangDAO.getAll(maNX, maTuyen);
    }

    public static int addCustomer(KhachHangDTO khachHang) {
        return KhachHangDAO.addCustomer(khachHang);
    }

    public static int deleteCustomer(int id) {
        return KhachHangDAO.deleteCustomer(id);
    }

}
