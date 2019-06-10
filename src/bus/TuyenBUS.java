package bus;

import dao.TuyenDAO;
import dto.TuyenDTO;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    

    public static ArrayList<TuyenDTO> getAllByTrip(String startingPoint, String destination, LocalDateTime time) {
        return TuyenDAO.getAllByTrip(startingPoint, destination, time);
    }
}
