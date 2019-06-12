/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import bus.TuyenBUS;
import createUI.DatePicker;
import createUI.DatePickerWhite;
import dao.TuyenDAO;
import dto.TuyenDTO;
import layout.SelectWhite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import static layout.Content.*;
import static layout.Dashboard.selectTicketPanel;
import static layout.Content.homeSelect;
import static layout.MenuDashboard.panelTicket;
import static layout.SelectTicket.c1;
import static layout.SelectTicket.c2;

/**
 * @author my pc
 */
public class SelectTicketPanel extends JPanel {

    String list[] = {"Tất cả", "TP.HCM", "Đồng Nai", "Bình Dương", "Vũng Tàu", "Long An", "Tây Ninh"};
    String list2[] = {"Tất cả", "Đồng Nai", "TP.HCM", "Bình Dương", "Vũng Tàu", "Long An", "Tây Ninh"};
    int currentTo, currentFrom;
    static ListTicket listTicket;
    private SelectWhite selectFrom, selectTo;
//    private DatePickerWhite datePicker;

    public SelectTicketPanel() {

        selectFrom = new SelectWhite(list, "Từ", 50);
        selectTo = new SelectWhite(list2, "Đến", 50);
        areaPanel.validate();
        areaPanel.repaint();

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(9, 114, 201, 0));
        this.setPreferredSize(new Dimension(810, 55));

        JPanel areaSelect = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        areaSelect.setPreferredSize(new Dimension(810, 65));
        areaSelect.setBackground(new Color(255, 255, 255, 0));

        DatePickerWhite datePicker = new DatePickerWhite(12);
        datePicker.setPreferredSize(new Dimension(250, 40));

        areaSelect.add(selectFrom);
        areaSelect.add(selectTo);
        areaSelect.add(datePicker);

        this.add(areaSelect, BorderLayout.NORTH);

        listTicket = new ListTicket();

        currentFrom = selectFrom.get().getSelectedIndex();
        currentTo = selectTo.get().getSelectedIndex();

        selectFrom.get().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = selectFrom.get().getSelectedIndex();
                JFormattedTextField textField = datePicker.getTextField();

                Date date = new Date();
                Timestamp dateTimestamp = null;
                LocalDateTime dateTime = null;
                try {
                    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    date = format.parse(textField.getText());
                    dateTimestamp = new Timestamp(date.getTime());
                    dateTime = dateTimestamp.toLocalDateTime();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                ArrayList<TuyenDTO> danhSachTuyen = null;

                if((selectTo.get().getSelectedIndex() == 0)) {
                    danhSachTuyen = TuyenBUS.getAllByStart(list[selected], dateTime);
                    if(selected == 0) {
                        danhSachTuyen = TuyenBUS.getAllByTime(dateTime);
                    }
                } else if(selected == 0) {
                    danhSachTuyen = TuyenBUS.getAllByDest(list2[currentTo], dateTime);
                } else {
                    danhSachTuyen = TuyenBUS.getAllByTrip(list[selected], list2[currentTo], dateTime);
                }

                dashboard.getBgDashboard().removeAll();
                dashboard.getBgDashboard().add(selectTicketPanel);
                dashboard.getKa().removeAll();
                dashboard.showTicket(danhSachTuyen);
                selectTicketPanel.validate();
                selectTicketPanel.repaint();
                dashboard.getKa().validate();
                dashboard.getKa().repaint();
                dashboard.getHi().validate();
                dashboard.getHi().repaint();
                dashboard.getBgDashboard().add(dashboard.getHi());
                dashboard.getBgDashboard().validate();
                dashboard.getBgDashboard().repaint();
                dashboard.validate();
                dashboard.repaint();
                currentFrom = selected;
            }

        });

        selectTo.get().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = selectTo.get().getSelectedIndex();
                JFormattedTextField textField = datePicker.getTextField();
                System.out.println(selected);
                Date date = new Date();
                Timestamp dateTimestamp = null;
                LocalDateTime dateTime = null;
                try {
                    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    date = format.parse(textField.getText());
                    dateTimestamp = new Timestamp(date.getTime());
                    dateTime = dateTimestamp.toLocalDateTime();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                ArrayList<TuyenDTO> danhSachTuyen = null;
                if(selectFrom.get().getSelectedIndex() == 0) {
                    danhSachTuyen = TuyenBUS.getAllByDest(list2[selected], dateTime);
                    if(selected == 0) {
                        danhSachTuyen = TuyenBUS.getAllByTime(dateTime);
                    }
                } else if(selected == 0){
                    danhSachTuyen = TuyenBUS.getAllByStart(list[currentFrom], dateTime);
                } else {
                    danhSachTuyen = TuyenBUS.getAllByTrip(list[currentFrom], list2[selected], dateTime);
                }


                dashboard.getBgDashboard().removeAll();
                dashboard.getBgDashboard().add(selectTicketPanel);
                dashboard.getKa().removeAll();
                dashboard.showTicket(danhSachTuyen);
                selectTicketPanel.validate();
                selectTicketPanel.repaint();
                dashboard.getKa().validate();
                dashboard.getKa().repaint();
                dashboard.getHi().validate();
                dashboard.getHi().repaint();
                dashboard.getBgDashboard().add(dashboard.getHi());
                dashboard.getBgDashboard().validate();
                dashboard.getBgDashboard().repaint();
                dashboard.validate();
                dashboard.repaint();
                currentTo = selected;

            }
        });

        datePicker.getDatePicker().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFormattedTextField textField = datePicker.getTextField();

                Date date = new Date();
                Timestamp dateTimestamp = null;
                LocalDateTime dateTime = null;
                try {
                    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    date = format.parse(textField.getText());
                    dateTimestamp = new Timestamp(date.getTime());
                    dateTime = dateTimestamp.toLocalDateTime();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                ArrayList<TuyenDTO> danhSachTuyen = null;
                System.out.println(currentFrom);
                System.out.println(currentTo);
                if(currentTo == 0) {
                    danhSachTuyen = TuyenBUS.getAllByStart(list[currentFrom], dateTime);
                    if(currentFrom == 0) {
                        danhSachTuyen = TuyenBUS.getAllByTime(dateTime);
                    }
                } else if(currentFrom == 0) {
                    danhSachTuyen = TuyenBUS.getAllByStart(list2[currentTo], dateTime);
                } else {
                    danhSachTuyen = TuyenBUS.getAllByTrip(list[currentFrom], list2[currentTo], dateTime);
                }

                dashboard.getKa().removeAll();
                dashboard.showTicket(danhSachTuyen);
                dashboard.getKa().removeAll();
                dashboard.showTicket(danhSachTuyen);
                dashboard.getKa().validate();
                dashboard.getKa().repaint();
                dashboard.getHi().validate();
                dashboard.getHi().repaint();
                dashboard.getBgDashboard().add(dashboard.getHi());
                dashboard.getBgDashboard().validate();
                dashboard.getBgDashboard().repaint();
                dashboard.validate();
                dashboard.repaint();
            }
        });
    }

    public void removeArrowCompoBox(Component[] component) {
        for (int i = 0; i < component.length; i++) {
            if (component[i] instanceof JButton) {
                JButton button = (JButton) component[i];
                button.setPreferredSize(new Dimension(0, 0));
                button.setVisible(false);
            }
        }
    }

    public SelectWhite getSelectFrom() {
        return selectFrom;
    }

    public SelectWhite getSelectTo() {
        return selectTo;
    }
}
