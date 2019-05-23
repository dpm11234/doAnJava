package dto;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

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
        return decrypt(password);
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

    public static String encrypt(String str) {
        String temp = null;
        try {
            // Đọc file chứa public key
            FileInputStream fis = new FileInputStream("key/publicKey.rsa");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();

            // Tạo public key
            X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = factory.generatePublic(spec);

            // Mã hoá dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.ENCRYPT_MODE, pubKey);
            byte encryptOut[] = c.doFinal(str.getBytes());
            temp = Base64.getEncoder().encodeToString(encryptOut);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    public static String decrypt(String str) {
        String temp = null;
        try {
            // Đọc file chứa private key
            FileInputStream fis = new FileInputStream("key/privateKey.rsa");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();

            // Tạo private key
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = factory.generatePrivate(spec);

            // Giải mã dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, priKey);
            byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(
                    str));
            temp = new String(decryptOut);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return temp;
    }
}
