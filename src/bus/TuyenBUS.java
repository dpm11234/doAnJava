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
}
