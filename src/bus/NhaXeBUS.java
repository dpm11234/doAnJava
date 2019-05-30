package bus;

import dao.NhaXeDAO;
import dto.NhaXeDTO;

import java.util.ArrayList;

public class NhaXeBUS {

    public static ArrayList<NhaXeDTO> getAll() {
        return NhaXeDAO.getAll();
    }

}
