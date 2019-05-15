package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.metal.MetalComboBoxButton;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;
import java.net.URL;
// ww w  .ja v a 2 s.  com
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import ui.Panel.Main.BackgroudMain;

import ui.Panel.Main.LoginPanel;
import ui.Panel.Main.NavbarPanel;
import ui.Panel.Main.DatePicker;
import ui.Panel.Main.ButtonShowCompoBox;

public class MainFrame extends JFrame {

    private JFrame frame;
    private JPanel body, slideBar, booking, logo, selectTicket, areaSelect, info, selectFrom, selectTo;
    static JLabel lb1, lb2, textLogo, textInfo, textSelect, textSelectSpace, textSelectTo, textSelectSpaceTo;
    static JButton changeButton;
    ImageIcon icon;
    String list[] = {"TP.HCM", "Đồng Nai", "Bình Dương", "Vũng Tàu", "Long An", "Tay Ninh"};
    static JComboBox c1, c2;

    private LoginPanel loginPanel;
    private NavbarPanel navbarPanel;
    static boolean checkClickJCompoBox1, checkClickJCompoBox2;

    public MainFrame() {
        createAndShow();
    }

    

    public void removeArrowCompoBox(Component[] component) {
        for (int i = 0; i < component.length; i++) {
            if (component[i] instanceof JButton) {
                JButton button = (JButton) component[i];
                button.setPreferredSize(new Dimension(0, 0));
                button.setVisible(false);
//                button.setIcon(new ImageIcon(new ImageIcon("images/login2.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
            }

        }
    }

    
    

    public void createAndShow() {
        
        frame = new JFrame("Vé Vi Vu");
        icon = new ImageIcon("images/iconb.png");
        frame.setIconImage(icon.getImage());
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        loginPanel = new LoginPanel();
        navbarPanel = new NavbarPanel();
        BackgroudMain bgMain = new BackgroudMain();
        DatePicker datePicker = new DatePicker();

        textLogo = new JLabel("<html><font style='font-size: 16px; font-family: \"Trebuchet MS\", Helvetica, sans-serif' color='white'> VÉ VI VU</font></html>", SwingConstants.CENTER);
        Font fontTextInfo = new Font("SansSerif", Font.BOLD, 14);
        textInfo = new JLabel("© Phát triển bởi Gocodee!");
        textInfo.setFont(fontTextInfo);
        textInfo.setForeground(new Color(9, 114, 201));
        textInfo.setPreferredSize(new Dimension(270, 30));
        textInfo.setVerticalAlignment(JLabel.CENTER);
        textInfo.setHorizontalAlignment(JLabel.CENTER);
        textLogo.setPreferredSize(new Dimension(220, 50));
        textLogo.setIcon(new ImageIcon(new ImageIcon("images/logo.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        textLogo.setIconTextGap(10);

        MatteBorder border = new MatteBorder(0, 0, 1, 0, new Color(35, 126, 212));
        textLogo.setPreferredSize(new Dimension(220, 50));
        textLogo.setVerticalAlignment(JLabel.CENTER);
        logo = new JPanel();
        logo.setPreferredSize(new Dimension(270, 60));
        logo.setBackground(new Color(0, 115, 211));
        
        logo.setBorder(border);
        selectTicket = new JPanel(new BorderLayout());
        info = new JPanel();
        
        selectTicket.setBackground(new Color(9, 114, 201));
        info.setBackground(new Color(255, 255, 255));
        info.setPreferredSize(new Dimension(270, 40));
        

        selectFrom = new JPanel(new BorderLayout());
        selectTo = new JPanel(new BorderLayout());
        
        
        slideBar = new JPanel(new BorderLayout());
        booking = new JPanel(new BorderLayout());
        body = new JPanel(new BorderLayout());
        
        areaSelect = new JPanel(new GridLayout(0, 1));


        c1 = new JComboBox(list);
        c2 = new JComboBox(list);

        
        


        selectFrom.setBackground(new Color(26, 126, 218));
        selectTo.setBackground(new Color(26, 126, 218));
        slideBar.setBackground(new Color(0, 105, 192));
        booking.setBackground(new Color(242, 243, 245));
        logo.add(textLogo);
        info.add(textInfo);
        
        

        textSelect = new JLabel("<html><font color='#5898DD'>Từ</font></html>");
        textSelect.setPreferredSize(new Dimension(50, 50));
        textSelect.setHorizontalAlignment(JLabel.CENTER);

        textSelectSpace = new JLabel("");
        textSelectSpace.setPreferredSize(new Dimension(20, 50));

        textSelectTo = new JLabel("<html><font color='#5898DD'>Đến</font></html>");
        textSelectTo.setPreferredSize(new Dimension(50, 50));
        textSelectTo.setHorizontalAlignment(JLabel.CENTER);

        textSelectSpaceTo = new JLabel("");
        textSelectSpaceTo.setPreferredSize(new Dimension(20, 50));

        c1.setPreferredSize(new Dimension(90, 50));
        c1.setEditable(true);
//        changeButton = (JButton) c1.getComponent(2);
        MatteBorder borderPicker = new MatteBorder(0, 0, 0, 0, new Color(26, 126, 218));        
        // Custom JCompoBox
        checkClickJCompoBox1 = false;
        checkClickJCompoBox2 = false;
        
        ButtonShowCompoBox buttonShowCompoBox1 = new ButtonShowCompoBox("Chọn Điểm Khởi Hành");  
        ButtonShowCompoBox buttonShowCompoBox2 = new ButtonShowCompoBox("Chọn Điểm Đến");
        
        // Clear biến check khi click ra ngoài JPanel
        body.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                checkClickJCompoBox1 = false;
                checkClickJCompoBox2 = false;
            }
        });

        c1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkClickJCompoBox1 = false;
            }
        });

        c2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkClickJCompoBox2 = false;
            }
        });

        buttonShowCompoBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //then you know that is attached to this button
                if (!checkClickJCompoBox1) {
                    c1.setPopupVisible(true);
                }
                checkClickJCompoBox1 = !checkClickJCompoBox1;
            }
        });

        buttonShowCompoBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //then you know that is attached to this button
                if (!checkClickJCompoBox2) {
                    c2.setPopupVisible(true);
                }
                checkClickJCompoBox2 = !checkClickJCompoBox2;
            }
        });

        // Clear arrow button show JCompoBox
        Component[] componentCompoBox1 = c1.getComponents();
        Component[] componentCompoBox2 = c2.getComponents();
        removeArrowCompoBox(componentCompoBox1);
        removeArrowCompoBox(componentCompoBox2);
        c1.getEditor().getEditorComponent().setBackground(new Color(26, 126, 218));
        c1.setBackground(new Color(26, 126, 218));
        MatteBorder comboBox = new MatteBorder(0, 0, 0, 0, new Color(26, 126, 218));
        c1.setBorder(comboBox);
        c1.setFocusable(false);
        for (int i = 0; i < c1.getComponentCount(); i++) {
            if (c1.getComponent(i) instanceof JComponent) {
                ((JComponent) c1.getComponent(i)).setBorder(new EmptyBorder(0, 0, 0, 0));
            }

            if (c1.getComponent(i) instanceof AbstractButton) {
                ((AbstractButton) c1.getComponent(i)).setBorderPainted(false);
                ((AbstractButton) c1.getComponent(i)).setMaximumSize(new Dimension(0, 0));
            }
        }

//        c1.ForeColor = Color.Red;
        c1.getEditor().getEditorComponent().setForeground(new Color(255, 255, 255));
        
        c2.setPreferredSize(new Dimension(90, 50));
        c2.setEditable(true);
        c2.getEditor().getEditorComponent().setBackground(new Color(26, 126, 218));
        c2.setBackground(new Color(26, 126, 218));
        MatteBorder comboBox2 = new MatteBorder(0, 0, 0, 0, new Color(26, 126, 218));
        c2.setBorder(comboBox2);
        c2.setFocusable(false);
        for (int i = 0; i < c2.getComponentCount(); i++) {
            if (c2.getComponent(i) instanceof JComponent) {
                ((JComponent) c2.getComponent(i)).setBorder(new EmptyBorder(0, 0, 0, 0));
            }

            if (c2.getComponent(i) instanceof AbstractButton) {
                ((AbstractButton) c2.getComponent(i)).setBorderPainted(false);
                ((AbstractButton) c2.getComponent(i)).setMaximumSize(new Dimension(0, 0));
            }
        }

//        c1.ForeColor = Color.Red;
        c2.getEditor().getEditorComponent().setForeground(new Color(255, 255, 255));
        Font fontJCompoBox = new Font("SansSerif", Font.BOLD, 16);
        c1.setFont(fontJCompoBox);
        c2.setFont(fontJCompoBox);

        selectFrom.add(textSelect, BorderLayout.WEST);
        selectFrom.add(c1, BorderLayout.CENTER);
        selectFrom.add(buttonShowCompoBox1, BorderLayout.EAST);
        MatteBorder borderSelect = new MatteBorder(0, 0, 1, 0, new Color(48, 148, 238));
        selectFrom.setBorder(borderSelect);
        selectTo.setBorder(borderSelect);

        selectTo.add(textSelectTo, BorderLayout.WEST);
        selectTo.add(c2, BorderLayout.CENTER);
        selectTo.add(buttonShowCompoBox2, BorderLayout.EAST);

//        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        selectTicket.add(areaSelect, BorderLayout.NORTH);
        areaSelect.add(selectFrom);
        areaSelect.add(selectTo);
        
        areaSelect.add(datePicker);
//        selectTicket.add(selectTo, BorderLayout.CENTER);
        selectTicket.setPreferredSize(new Dimension(200, 240));

//        ImageIcon iconBackground = new ImageIcon("images/background.png");
        JLabel thumb = new JLabel();
//        thumb.add(new ImagePanel(img));
//        thumb.setIcon(new ImageIcon(new ImageIcon("images/background.png").getImage().getScaledInstance(630, 440, Image.SCALE_DEFAULT)));
        //bgMain = new JPanel(new BorderLayout());

        
//        thumb.getWidth();
//            bgMain.add(thumb);
            navbarPanel.add(loginPanel, BorderLayout.EAST);
            
            booking.add(navbarPanel, BorderLayout.NORTH);
            booking.add(bgMain, BorderLayout.CENTER);
            slideBar.add(logo, BorderLayout.NORTH);
            slideBar.add(selectTicket, BorderLayout.CENTER);
            slideBar.add(info, BorderLayout.SOUTH);

            body.add(slideBar, BorderLayout.WEST);
            body.add(booking, BorderLayout.CENTER);

            frame.setVisible(true);
            frame.add(body);

//            JFrame frame = new JFrame("Testing");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setLayout(new BorderLayout());
//            frame.add(new ImagePanel(img));
//            frame.pack();
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
            JButton jButton = new JButton("test");
            
            System.out.println(c1.getSelectedIndex());
            int current = c1.getSelectedIndex();
            c1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = c1.getSelectedIndex();
                if(current != selected) {
                    booking.remove(bgMain);
                    booking.repaint();
                } 
            }
        });
            
            
            JPanel login = new JPanel();
            
            
            loginPanel.getbtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                booking.remove(bgMain);
                booking.add(login);
                booking.repaint();
            }
        });
    }
    
    
    
    public static void main(String[] args) {
        new MainFrame();
    }
}
