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

        if(tuyen.getGia() < 0) {
            return -3;
        }

        if(tuyen.getSoLuong() < 0) {
            return -4;
        }

        res = TuyenDAO.addTicket(tuyen);

        return res;
    }

    public static ArrayList<TuyenDTO> getAllByStart(String startingPoint, LocalDateTime time) {
        return TuyenDAO.getAllByStart(startingPoint, time);
    }

    public static ArrayList<TuyenDTO> getAllByDest(String dest, LocalDateTime time) {
        return TuyenDAO.getAllByDest(dest, time);
    }

    public static ArrayList<TuyenDTO> getAllByTime(LocalDateTime time) {
        return TuyenDAO.getAllByTime(time);
    }

    public static int deleteTicket(String maTuyen) {
        int res = -1;

        res = TuyenDAO.deleteTicket(maTuyen);
        
        return res;
    }
    
     public static int editTicket(String maTuyen, TuyenDTO tuyen) {
        int res = -1;

         if(tuyen.getGia() < 0) {
             return -3;
         }

         if(tuyen.getSoLuong() < 0) {
             return -4;
         }

        res = TuyenDAO.editTicket(maTuyen, tuyen);

        return res;
    }
    

    public static ArrayList<TuyenDTO> getAllByTrip(String startingPoint, String destination, LocalDateTime time) {
        return TuyenDAO.getAllByTrip(startingPoint, destination, time);
    }

    public static ArrayList<TuyenDTO> getAllByTripClient(String startingPoint, String destination, LocalDateTime time) {
        return TuyenDAO.getAllByTripClient(startingPoint, destination, time);
    }

    public static ArrayList<TuyenDTO> getAllByTripAndMaNX(String startingPoint, String destination, LocalDateTime time) {
        return TuyenDAO.getAllByTrip(startingPoint, destination, time);
    }
   
    public static int countemptySeat(String maTuyen){
        return TuyenDAO.countEmptySeat(maTuyen);
    }
}
