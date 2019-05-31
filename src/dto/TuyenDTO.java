package dto;

import java.sql.Time;
import java.sql.Timestamp;

public class TuyenDTO {
    private String maNX;
    private String maTuyen;
    private String diemDen;
    private String diemXuatPhat;
    private Timestamp thoiGianKhoiHanh;
    private int tongGhe;
    private String bienSoXe;
    private int soLuong;
    private int gia;


    public TuyenDTO() {
    }

    public TuyenDTO(String maNX, String maTuyen, String diemDen, String diemXuatPhat, Timestamp thoiGianKhoiHanh, int tongGhe, String bienSoXe, int soLuong, int gia) {
        this.maNX = maNX;
        this.maTuyen = maTuyen;
        this.diemDen = diemDen;
        this.diemXuatPhat = diemXuatPhat;
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
        this.tongGhe = tongGhe;
        this.bienSoXe = bienSoXe;
        this.soLuong = soLuong;
        this.gia = gia;
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

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getDiemXuatPhat() {
        return diemXuatPhat;
    }

    public void setDiemXuatPhat(String diemXuatPhat) {
        this.diemXuatPhat = diemXuatPhat;
    }

    public Timestamp getThoiGianKhoiHanh() {
        return thoiGianKhoiHanh;
    }

    public void setThoiGianKhoiHanh(Timestamp thoiGianKhoiHanh) {
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
    }

    public int getTongGhe() {
        return tongGhe;
    }

    public void setTongGhe(int tongGhe) {
        this.tongGhe = tongGhe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
