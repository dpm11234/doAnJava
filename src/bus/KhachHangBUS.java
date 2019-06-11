package bus;

import dao.KhachHangDAO;
import dto.KhachHangDTO;

import java.util.ArrayList;

public class KhachHangBUS {

    public static ArrayList<KhachHangDTO> getAll(String maNX, String maTuyen) {
        return KhachHangDAO.getAll(maNX, maTuyen);
    }

    public static int addCustomer(KhachHangDTO khachHang) {
        String regexName = "[a-z]{2,}";

        if(khachHang.getHoTen().equals("Họ tên") || !khachHang.getHoTen().matches(regexName)) {
            return -2;
        }

        String regexPhone = "^0[0-9]{9}";

        if(khachHang.getSdt().equals("Số điện thoại") || !khachHang.getSdt().matches(regexPhone)) {
            return -3;
        }

        return KhachHangDAO.addCustomer(khachHang);
    }

    public static int deleteCustomer(int id) {
        return KhachHangDAO.deleteCustomer(id);
    }

}
