/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import bus.KhachHangBUS;
import bus.NhaXeBUS;
import bus.TuyenBUS;
import createUI.ButtonImage;
import createUI.DatePickerAdd;
import createUI.ImagePanel;
import createUI.Input;
import createUI.JPanelInput;
import createUI.SelectDown;
import createUI.TwoDots;
import dao.KhachHangDAO;
import dao.TuyenDAO;
import dto.KhachHangDTO;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;
import java.util.Locale;
import static util.Session.*;

/**
 *
 * @author my pc
 */
public class PickTicket extends JPanel {

    String list[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static boolean checkClickJCompoBox1, checkClickJCompoBox2, checkClickJCompoBoxKind;
    static SelectDown compoBoxFrom, compoBoxBookNum, compoBoxKind;
    private JTextField time, price;
    private TuyenDTO tuyen;
    static ButtonImage submitSave, submitDelete;
    int indexFrom = 0, index = 0, indexKind = 0;

    private DatePickerAdd datePicker;
    Input inputName, inputPhone;
    private KhachHangDTO khachHang;

    public PickTicket(TuyenDTO tuyen) {

        this.khachHang = new KhachHangDTO();
        this.tuyen = tuyen;

        this.setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();

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
        loginFormLayout.setPreferredSize(new Dimension(300, 300));
        loginFormLayout.setBackground(new Color(255, 255, 255));

        compoBoxBookNum = new SelectDown(list, "Số ghế đặt", 100);

        JPanel selectLocal = new JPanel(new BorderLayout());
        selectLocal.setPreferredSize(new Dimension(300, 40));
        selectLocal.setBackground(new Color(255, 255, 255));

        selectLocal.add(compoBoxBookNum, BorderLayout.CENTER);

        // Row 2
        JPanel selectTime = new JPanel(new BorderLayout());
        selectTime.setPreferredSize(new Dimension(300, 40));
        selectTime.setBackground(new Color(255, 255, 255));

        inputName = new Input("Họ tên", "name");

        selectTime.add(inputName, BorderLayout.CENTER);

        // row 3
        JPanel selectRow3 = new JPanel(new BorderLayout());
        selectRow3.setPreferredSize(new Dimension(300, 40));
        selectRow3.setBackground(new Color(255, 255, 255));
        
        inputPhone = new Input("Số điện thoại", "phone2");
        
        selectRow3.add(inputPhone, BorderLayout.CENTER);

        // Submit
        JPanel selectRow5 = new JPanel(new GridBagLayout());
        selectRow5.setPreferredSize(new Dimension(300, 40));
        selectRow5.setBackground(new Color(255, 255, 255));

        submitSave = new ButtonImage("Đặt Vé", "submitSave", 300);

        selectRow5.add(submitSave);

        loginFormLayout.add(selectTime);
        loginFormLayout.add(selectRow3);
        loginFormLayout.add(selectLocal);
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
        compoBoxBookNum.getCompoBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index= compoBoxBookNum.getCompoBox().getSelectedIndex();
            }
        });
        
        // Event
        
        submitSave.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khachHang.setMaNX(tuyen.getMaNX());
                khachHang.setMaTuyen(tuyen.getMaTuyen());
                khachHang.setHoTen(inputName.getText());
                khachHang.setSdt(inputPhone.getText());
                khachHang.setThoiGianDat(Timestamp.valueOf(LocalDateTime.now()));
                khachHang.setSoVeDat(Integer.parseInt(list[index]));

                int res = KhachHangBUS.addCustomer(khachHang);
            }
        });
    }

}
