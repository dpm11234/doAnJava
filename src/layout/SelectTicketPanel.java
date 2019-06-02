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
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import static layout.Content.areaPanel;
import static layout.Content.home;
import static layout.Content.login;
import static layout.MenuDashboard.panelTicket;
import static layout.SelectTicket.c1;

/**
 *
 * @author my pc
 */
public class SelectTicketPanel extends JPanel {

    String list[] = {"TP.HCM", "Đồng Nai", "Bình Dương", "Vũng Tàu", "Long An", "Tay Ninh"};
    String list2[] = {"Đồng Nai", "TP.HCM", "Bình Dương", "Vũng Tàu", "Long An", "Tay Ninh"};
    static boolean checkClickJCompoBox1, checkClickJCompoBox2;
    static JComboBox c1, c2;
    int currentTo, currentFrom;
    static ListTicket listTicket;
    static JPanel selectFrom, selectTo;

    public SelectTicketPanel() {

        SelectWhite selectFrom1 = new SelectWhite(list, "Từ", 50);
        SelectWhite selectTo1 = new SelectWhite(list2, "Đến", 50);
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

        areaSelect.add(selectFrom1);
        areaSelect.add(selectTo1);
        areaSelect.add(datePicker);

        this.add(areaSelect, BorderLayout.NORTH);

        listTicket = new ListTicket();

        selectFrom1.get().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaPanel.validate();
                areaPanel.repaint();
            }

        });

        selectTo1.get().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaPanel.validate();
                areaPanel.repaint();
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
}
