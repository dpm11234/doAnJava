/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import bus.NhaXeBUS;
import bus.TuyenBUS;
import createUI.ButtonImage;
import createUI.DatePickerAdd;
import createUI.ImagePanel;
import createUI.Input;
import createUI.JPanelInput;
import createUI.SelectDown;
import createUI.TwoDots;
import dto.NhaXeDTO;
import dto.TuyenDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;
import java.util.Date;
import java.util.Locale;
import static layout.Content.areaPanel;
import static layout.Content.dashboard;
import static layout.Content.navbar;
import static layout.Login.hello;
import static layout.MenuDashboard.panelTicketTitle;
import static layout.Navbar.navIsLogin;
import static layout.TicketClient.titleEdit;
import static util.Session.*;

/**
 *
 * @author my pc
 */
public class EditTicket extends JPanel {

    String list[] = {"TP.HCM", "Đồng Nai", "Bình Dương", "Vũng Tàu", "Long An", "Tây Ninh"};
    String list2[] = {"TP.HCM", "Đồng Nai", "Bình Dương", "Vũng Tàu", "Long An", "Tây Ninh"};
    String listKind[] = {"16", "24", "29", "34", "36", "39", "47", "52"};
    static boolean checkClickJCompoBox1, checkClickJCompoBox2, checkClickJCompoBoxKind;
    static SelectDown compoBoxFrom, compoBoxTo, compoBoxKind;
    private JTextField time, price;
    private TuyenDTO tuyen;
    static ButtonImage submitSave, submitDelete;
    int indexFrom, indexTo, indexKind;

    private DatePickerAdd datePicker;
    Input inputTime, inputLicensePlate, inputPrice, inputSet;

    public EditTicket(TuyenDTO tuyen) {
        this.setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();

//        this.tuyen = new TuyenDTO();
//        this.tuyen.setDiemXuatPhat(this.list[0]);
//        this.tuyen.setDiemDen(this.list2[0]);
        this.tuyen = tuyen;
        indexFrom = setIndex(tuyen.getDiemXuatPhat());
        indexTo = setIndex(tuyen.getDiemDen());
        indexKind = setIndexKind(tuyen.getTongGhe());
        JPanel loginBg = new JPanel();
        try {
            Image imgLogin = null;
            imgLogin = ImageIO.read(new File("images/loginbackground.png"));
            loginBg = new ImagePanel(imgLogin);
            loginBg.setLayout(new GridBagLayout());
            //bgMain.add(loginBg);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }

//        MatteBorder borderSelect = new MatteBorder(1, 1, 1, 1, new Color(48, 148, 238));
        JPanel loginFormLayoutCenter = new JPanel(new GridBagLayout());
        loginFormLayoutCenter.setPreferredSize(new Dimension(230, 300));
        loginFormLayoutCenter.setBackground(new Color(255, 255, 255));

        JPanel loginFormLayout = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 15));
        loginFormLayout.setPreferredSize(new Dimension(490, 300));
        loginFormLayout.setBackground(new Color(255, 255, 255));

        compoBoxFrom = new SelectDown(list, "Từ", 50);
        compoBoxTo = new SelectDown(list2, "Đến", 50);

        compoBoxFrom.getCompoBox().setSelectedItem(tuyen.getDiemXuatPhat());
        compoBoxTo.getCompoBox().setSelectedItem(tuyen.getDiemDen());

        JLabel arrow = new JLabel();
        arrow.setPreferredSize(new Dimension(48, 27));
        arrow.setIcon(new ImageIcon(new ImageIcon("images/right-arrow-space.png").getImage().getScaledInstance(48, 16, Image.SCALE_DEFAULT)));
        arrow.setIconTextGap(0);

        JPanel selectLocal = new JPanel(new BorderLayout());
        selectLocal.setPreferredSize(new Dimension(488, 40));
        selectLocal.setBackground(new Color(255, 255, 255));

        selectLocal.add(compoBoxFrom, BorderLayout.WEST);
        selectLocal.add(arrow, BorderLayout.CENTER);
        selectLocal.add(compoBoxTo, BorderLayout.EAST);

        // Row 2
        JPanel selectTime = new JPanel(new BorderLayout());
        selectTime.setPreferredSize(new Dimension(488, 40));
        selectTime.setBackground(new Color(255, 255, 255));
        LocalDateTime time = tuyen.getThoiGianKhoiHanh().toLocalDateTime();

        String date = new SimpleDateFormat("dd-MM-yyyy").format(tuyen.getThoiGianKhoiHanh());

        datePicker = new DatePickerAdd(9);
        datePicker.getTextField().setText(date);
        TwoDots dot1 = new TwoDots();
        inputTime = new Input("Giờ khởi hành", "time-oclock");

        inputTime.getInput().setText(time.getHour() + ":" + time.getMinute());

        selectTime.add(datePicker, BorderLayout.WEST);
        selectTime.add(dot1, BorderLayout.CENTER);
        selectTime.add(inputTime, BorderLayout.EAST);

        // row 3
        JPanel selectRow3 = new JPanel(new BorderLayout());
        selectRow3.setPreferredSize(new Dimension(488, 40));
        selectRow3.setBackground(new Color(255, 255, 255));

        compoBoxKind = new SelectDown(listKind, "Số chổ ngồi", 88);
        compoBoxKind.getCompoBox().setSelectedItem(tuyen.getTongGhe());

        TwoDots dot2 = new TwoDots();
        inputPrice = new Input("Giá vé", "price");

        inputPrice.getInput().setText(tuyen.getGia() + "");

        selectRow3.add(compoBoxKind, BorderLayout.WEST);
        selectRow3.add(dot2, BorderLayout.CENTER);
        selectRow3.add(inputPrice, BorderLayout.EAST);

        // row 4
        JPanel selectRow4 = new JPanel(new BorderLayout());
        selectRow4.setPreferredSize(new Dimension(488, 40));
        selectRow4.setBackground(new Color(255, 255, 255));

        inputSet = new Input("Đã đặt", "user-set");
        TwoDots dot3 = new TwoDots();
        inputLicensePlate = new Input("Biển số", "LicensePlate");

        inputSet.getInput().setText(tuyen.getSoLuong() + "");
        inputLicensePlate.getInput().setText(tuyen.getBienSoXe() + "");

        selectRow4.add(inputSet, BorderLayout.WEST);
        selectRow4.add(dot3, BorderLayout.CENTER);
        selectRow4.add(inputLicensePlate, BorderLayout.EAST);

        // Submit
        JPanel selectRow5 = new JPanel(new GridBagLayout());
        selectRow5.setPreferredSize(new Dimension(488, 40));
        selectRow5.setBackground(new Color(255, 255, 255));

        submitSave = new ButtonImage("Lưu thay đổi", "submitSave", 220);
        JLabel spaceSubmit = new JLabel();
        spaceSubmit.setPreferredSize(new Dimension(48, 27));
        spaceSubmit.setBackground(new Color(0, 0, 0, 0));
        submitDelete = new ButtonImage("Xóa chuyến xe", "submitDelete", 220);

        selectRow5.add(submitSave);
        selectRow5.add(spaceSubmit);
        selectRow5.add(submitDelete);

        loginFormLayout.add(selectLocal);
        loginFormLayout.add(selectTime);
        loginFormLayout.add(selectRow3);
        loginFormLayout.add(selectRow4);
        loginFormLayout.add(selectRow5);

        loginFormLayoutCenter.add(loginFormLayout);

        JPanel loginSpace = new JPanel(new BorderLayout());
        loginSpace.setBackground(new Color(200, 12, 223, 0));

        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = gbc.weighty = 42;
        loginBg.add(loginFormLayoutCenter, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weightx = /*gbc.weighty = */ 45;
        gbc.insets = new Insets(2, 2, 2, 2);
        loginBg.add(loginSpace, gbc);

        this.add(loginBg, BorderLayout.CENTER);
        addEvents();
    }

    public void addEvents() {

        compoBoxFrom.getCompoBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexFrom = compoBoxFrom.getCompoBox().getSelectedIndex();
            }
        });
        compoBoxTo.getCompoBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexTo = compoBoxTo.getCompoBox().getSelectedIndex();
            }
        });
        compoBoxKind.getCompoBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexKind = compoBoxKind.getCompoBox().getSelectedIndex();
            }
        });

        // Event
        submitSave.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (handleEditTicket()) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thành công", 1);
                        areaPanel.removeAll();
                        areaPanel.add(dashboard);
                        dashboard.getKa().removeAll();
                        dashboard.showTicket(TuyenBUS.getAll());
                        dashboard.getKa().validate();
                        dashboard.getKa().repaint();
                        navbar.removeAll();
                        navbar.add(navIsLogin, BorderLayout.EAST);
                        navbar.add(panelTicketTitle, BorderLayout.CENTER);
                        navbar.add(hello, BorderLayout.WEST);
                        navbar.validate();
                        navbar.repaint();
                        areaPanel.validate();
                        areaPanel.repaint();
                        break;
                    case -2:
                        JOptionPane.showMessageDialog(null, "Giờ khởi hành không hợp lệ", "Thất bại", 1);
                        break;
                    case -3:
                        JOptionPane.showMessageDialog(null, "Giá không hợp lệ", "Thất bại", 1);
                        break;
                    case -4:
                        JOptionPane.showMessageDialog(null, "Số đã đặt không hợp lệ", "Thất bại", 1);
                }
            }
        });

        submitDelete.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (check == 0) {
                    int res = TuyenBUS.deleteTicket(tuyen.getMaTuyen());
                    if (res == 0) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", 1);
                        areaPanel.removeAll();
                        dashboard = new Dashboard(null);
                        navbar.removeAll();
                        navbar.add(navIsLogin, BorderLayout.EAST);
                        navbar.add(panelTicketTitle, BorderLayout.CENTER);
                        navbar.add(hello, BorderLayout.WEST);
                        navbar.validate();
                        navbar.repaint();
                        areaPanel.add(dashboard);
                        areaPanel.validate();
                        areaPanel.repaint();
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public int handleEditTicket() {
        String regexTime = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]?";
        if (!inputTime.getText().matches(regexTime)) {
            return -2;
        }

        String regexGia = "[0-9]+";
        if (!inputPrice.getText().matches(regexGia)) {
            return -3;
        }

        String regexDaDat = "[0-9]+";
        if (!inputSet.getText().matches(regexDaDat)) {
            return -4;
        }

        tuyen.setBienSoXe(inputLicensePlate.getText());

        tuyen.setGia(Integer.parseInt(inputPrice.getText()));

        tuyen.setSoLuong(Integer.parseInt(inputSet.getText()));

        tuyen.setDiemDen(list2[indexTo]);

        tuyen.setDiemXuatPhat(list[indexFrom]);

        tuyen.setTongGhe(Integer.parseInt(listKind[indexKind]));

        JFormattedTextField textField = datePicker.getTextField();
        String txtGioKhoiHanh = textField.getText() + " " + inputTime.getText();

        Date date = new Date();
        Timestamp gioKhoiHanh;
        try {
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            date = format.parse(txtGioKhoiHanh);
            gioKhoiHanh = new Timestamp(date.getTime());
            tuyen.setThoiGianKhoiHanh(gioKhoiHanh);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return TuyenBUS.editTicket(tuyen.getMaTuyen(), tuyen);
    }

    public int setIndex(String value) {
        switch (value) {
            case "TP.HCM":
                return 0;
            case "Đồng Nai":
                return 1;
            case "Bình Dương":
                return 2;
            case "Vũng Tàu":
                return 3;
            case "Long An":
                return 4;
            case "Tây Ninh":
                return 5;
        }
        return -1;
    }

    public int setIndexKind(int value) {
        switch (value) {
            case 16:
                return 0;
            case 24:
                return 1;
            case 29:
                return 2;
            case 34:
                return 3;
            case 36:
                return 4;
            case 39:
                return 5;
            case 47:
                return 6;
            case 52:
                return 7;
        }
        return -1;
    }
}
