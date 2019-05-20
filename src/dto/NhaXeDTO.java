package dto;

public class NhaXeDTO {
    private String maNX;
    private String tenNX;
    private String diaChi;
    private String username;
    private String password;
    private int soTuyen;

    public String getMaNX() {
        return maNX;
    }

    public void setMaNX(String maNX) {
        this.maNX = maNX;
    }

    public String getTenNX() {
        return tenNX;
    }

    public void setTenNX(String tenNX) {
        this.tenNX = tenNX;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSoTuyen() {
        return soTuyen;
    }

    public void setSoTuyen(int soTuyen) {
        this.soTuyen = soTuyen;
    }
}
