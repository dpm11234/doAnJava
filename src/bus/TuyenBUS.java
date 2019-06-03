package bus;

import dao.TuyenDAO;
import dto.TuyenDTO;

import java.util.ArrayList;

public class TuyenBUS {
    public static ArrayList<TuyenDTO> getAll() {
        return TuyenDAO.getAll();
    }

    public static ArrayList<TuyenDTO> getAllByMaNX() {
        return TuyenDAO.getAllByMaNX();
    }
    
    public static int addTicket(TuyenDTO tuyen) {
        int res = -1;

        res = TuyenDAO.addTicket(tuyen);

        return res;
    }

    public static int deleteTicket(String maTuyen) {
        int res = -1;

        res = TuyenDAO.deleteTicket(maTuyen);

        return res;
    }
    
     public static int editTicket(String maTuyen, TuyenDTO tuyen) {
        int res = -1;

        res = TuyenDAO.editTicket(maTuyen, tuyen);

        return res;
    }
    
}
