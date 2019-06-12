/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import dto.TuyenDTO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;

import static layout.Content.*;
import static layout.Login.hello;
import static layout.Navbar.navBackHome;
import static layout.Navbar.navIsLogin;
import static layout.Navbar.titleSpace;


/**
 *
 * @author my pc
 */
public class MenuDashboard extends JPanel {
    static JPanel panelTicket, createTicket;
    static JLabel namePanelTicket, nameCreateTicket;
    public MenuDashboard() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(9, 114, 201));
//        this.setPreferredSize(new Dimension(200, 240));
        
        JPanel areaMenuDashboard = new JPanel(new GridLayout(0, 1));
        areaMenuDashboard.setBackground(new Color(26, 126, 218));
        areaMenuDashboard.setPreferredSize(new Dimension(220, 140));
        
        panelTicket = new JPanel();
        createTicket = new JPanel();
        
        namePanelTicket = new JLabel("Quản lý tuyến");
        nameCreateTicket = new JLabel("Tạo chuyến mới");
        
        Font fontText = new Font("SansSerif", Font.BOLD, 14);
        MatteBorder borderSelect = new MatteBorder(0, 0, 1, 0, new Color(48, 148, 238));
        
//        panelTicket.setPreferredSize(new Dimension(220, 70));
        namePanelTicket.setIcon(new ImageIcon(new ImageIcon("images/list.png").getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT)));
        namePanelTicket.setIconTextGap(10);
        namePanelTicket.setFont(fontText);
        namePanelTicket.setForeground(Color.white);
        namePanelTicket.setPreferredSize(new Dimension(220, 55));
        namePanelTicket.setVerticalAlignment(JLabel.CENTER);
        
        panelTicket.setBackground(new Color(26, 126, 218));
        panelTicket.setBorder(borderSelect);
        panelTicket.add(namePanelTicket);
        panelTicket.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hover
        panelTicket.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                panelTicket.setBackground(new Color(227,233,237));
                namePanelTicket.setForeground(new Color(26, 126, 218));
                namePanelTicket.setIcon(new ImageIcon(new ImageIcon("images/list-hover.png").getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT)));
            }
        });
        
        panelTicket.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
                panelTicket.setBackground(new Color(26, 126, 218));
                namePanelTicket.setForeground(new Color(255, 255, 255));
                namePanelTicket.setIcon(new ImageIcon(new ImageIcon("images/list.png").getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT)));
            }
        });
        
        createTicket.setPreferredSize(new Dimension(220, 70));
        nameCreateTicket.setIcon(new ImageIcon(new ImageIcon("images/notes.png").getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT)));
        nameCreateTicket.setIconTextGap(10);
        nameCreateTicket.setFont(fontText);
        nameCreateTicket.setForeground(Color.white);
        nameCreateTicket.setPreferredSize(new Dimension(220, 55));
        nameCreateTicket.setVerticalAlignment(JLabel.CENTER);
        
        createTicket.setBackground(new Color(26, 126, 218));
        createTicket.add(nameCreateTicket);
        createTicket.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hover
        createTicket.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                createTicket.setBackground(new Color(227,233,237));
                nameCreateTicket.setForeground(new Color(26, 126, 218));
                nameCreateTicket.setIcon(new ImageIcon(new ImageIcon("images/notes-hover.png").getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT)));
            }
        });
        
        createTicket.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
                createTicket.setBackground(new Color(26, 126, 218));
                nameCreateTicket.setForeground(new Color(255, 255, 255));
                nameCreateTicket.setIcon(new ImageIcon(new ImageIcon("images/notes.png").getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT)));
            }
        });
        
        Font fontTextTitle = new Font("SansSerif", Font.PLAIN, 18);
        
        JLabel createTicketTicket = new JLabel("Tạo Tuyến Mới");
        createTicketTicket.setPreferredSize(new Dimension(150, 60));
        createTicketTicket.setVerticalAlignment(JLabel.CENTER);
        createTicketTicket.setHorizontalAlignment(JLabel.CENTER);
        createTicketTicket.setFont(fontTextTitle);
        createTicketTicket.setForeground(new Color(140, 140, 140));
        
        JLabel panelTicketTitle = new JLabel("Quản Lý Danh Sách Vé");
        panelTicketTitle.setPreferredSize(new Dimension(150, 60));
        panelTicketTitle.setVerticalAlignment(JLabel.CENTER);
        panelTicketTitle.setHorizontalAlignment(JLabel.CENTER);
        panelTicketTitle.setFont(fontTextTitle);
        panelTicketTitle.setForeground(new Color(140, 140, 140));

        createTicket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                areaPanel.removeAll();
                addTicket = new AddTicket();
                areaPanel.add(addTicket);

                areaPanel.validate();
                areaPanel.repaint();
                navbar.removeAll();
                navbar.add(navIsLogin, BorderLayout.EAST);
                navbar.add(createTicketTicket, BorderLayout.CENTER);
                navbar.add(hello, BorderLayout.WEST);
                navbar.validate();
                navbar.repaint();
            }
        });

        panelTicket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                areaPanel.removeAll();
                dashboard = new Dashboard(null);
                areaPanel.add(dashboard);

                areaPanel.validate();
                areaPanel.repaint();
                navbar.removeAll();
                navbar.add(navIsLogin, BorderLayout.EAST);
                navbar.add(panelTicketTitle, BorderLayout.CENTER);
                navbar.add(hello, BorderLayout.WEST);
                navbar.validate();
                navbar.repaint();
            }
        });
        
        areaMenuDashboard.add(panelTicket);
        areaMenuDashboard.add(createTicket);
        
        this.add(areaMenuDashboard, BorderLayout.NORTH);
    }
}
