package dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class KhachHangDTO {

    private int id;
    private String maNX;
    private String maTuyen;
    private String hoTen;
    private String sdt;
    private int soVeDat;
    private Timestamp thoiGianDat;
    private int kt;

    public KhachHangDTO() {
    }

    public KhachHangDTO(int id, String maNX, String maTuyen, String hoTen, String sdt, int soVeDat, Timestamp thoiGianDat, int kt) {
        this.id = id;
        this.maNX = maNX;
        this.maTuyen = maTuyen;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.soVeDat = soVeDat;
        this.thoiGianDat = thoiGianDat;
        this.kt = kt;
    }

    public KhachHangDTO(String maNX, String maTuyen, String hoTen, String sdt, int soVeDat, Timestamp thoiGianDat) {
        this.maNX = maNX;
        this.maTuyen = maTuyen;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.soVeDat = soVeDat;
        this.thoiGianDat = thoiGianDat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNX() {
        return maNX;
    }

    public void setMaNX(String maNX) {
        this.maNX = maNX;
    }

    public String getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSoVeDat() {
        return soVeDat;
    }

    public void setSoVeDat(int soVeDat) {
        this.soVeDat = soVeDat;
    }

    public Timestamp getThoiGianDat() {
        return thoiGianDat;
    }

    public void setThoiGianDat(Timestamp thoiGianDat) {
        this.thoiGianDat = thoiGianDat;
    }

    public int getKT() {
        return kt;
    }

    public void setKT(int kt) {
        this.kt = kt;
    }
}
