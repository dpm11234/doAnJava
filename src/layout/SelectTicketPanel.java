/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import createUI.DatePicker;
import createUI.DatePickerWhite;
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
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import static layout.Content.*;
import static layout.Content.homeSelect;
import static layout.MenuDashboard.panelTicket;
import static layout.SelectTicket.c1;

/**
 *
 * @author my pc
 */
public class SelectTicketPanel extends JPanel {

    String list[] = {"TP.HCM", "Đồng Nai", "Bình Dương", "Vũng Tàu", "Long An", "Tay Ninh"};
    String list2[] = {"Đồng Nai", "TP.HCM", "Bình Dương", "Vũng Tàu", "Long An", "Tay Ninh"};
    int currentTo, currentFrom;
    static ListTicket listTicket;
    private SelectWhite selectFrom, selectTo;
    private DatePickerWhite datePicker;

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

        datePicker = new DatePickerWhite(12);
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
                if(selected != currentFrom) {
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

                    areaPanel.removeAll();
                    dashboard = new Dashboard(list[selected], list2[currentTo], dateTime);
                    areaPanel.add(dashboard);
                    areaPanel.validate();
                    areaPanel.repaint();
                    currentFrom = selected;
                }
            }

        });

        selectTo.get().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = selectTo.get().getSelectedIndex();
                if(selected != currentTo) {
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

                    areaPanel.removeAll();
                    dashboard = new Dashboard(list[selected], list2[currentTo], dateTime);
                    areaPanel.add(dashboard);
                    areaPanel.validate();
                    areaPanel.repaint();
                    currentFrom = selected;
                }
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
