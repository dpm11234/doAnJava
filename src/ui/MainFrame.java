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
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {

    private JFrame frame;
    private JPanel body, slideBar, booking, logo, selectTicket, areaSelect, info, navbar, signInPanel, selectFrom, selectTo, datePicker1, alignDatePicker, bgMain;
    static JLabel lb1, lb2, textLogo, textInfo, textSelect, textSelectSpace, textSelectTo, textSelectSpaceTo, datePickerSpace, leftAlignDatePicker, rightAlignDatePicker;
    static JButton signIn, changeButton;
    ImageIcon icon;
    String list[] = {"TP.HCM", "Đồng Nai", "Bình Dương", "Vũng Tàu", "Long An", "Tay Ninh"};
    static JComboBox c1, c2;

    static boolean checkClickJCompoBox1, checkClickJCompoBox2;

    public MainFrame() {
        createAndShow();
        handleEvent();
    }

    public class DateLabelFormatter extends AbstractFormatter {

        private String datePattern = "dd-MM-yyyy";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }
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

    class ImagePanel extends JPanel {

        private static final long serialVersionUID = 1L;

        private Image img;
        private Image scaled;

        public ImagePanel(String img) {
            this(new ImageIcon(img).getImage());
        }

        public ImagePanel(Image img) {
            this.img = img;
        }

        @Override
        public void invalidate() {
            super.invalidate();
            int width = getWidth();
            int height = getHeight();

            if (width > 0 && height > 0) {
                scaled = img.getScaledInstance(getWidth(), getHeight(),
                        Image.SCALE_SMOOTH);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(
                    img.getWidth(this), img.getHeight(this));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(scaled, 0, 0, null);
        }
    }

    public void createAndShow() {
        
        frame = new JFrame("Vé Vi Vu");
        icon = new ImageIcon("images/iconb.png");
        frame.setIconImage(icon.getImage());
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lb1 = new JLabel("Panel 1");
        lb2 = new JLabel("Panel 2");

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
        MatteBorder borderNav = new MatteBorder(0, 0, 1, 0, new Color(227, 228, 231));
        MatteBorder borderSignIn = new MatteBorder(0, 0, 0, 0, new Color(227, 228, 231));
        logo = new JPanel();
        logo.setPreferredSize(new Dimension(270, 60));
        textLogo.setPreferredSize(new Dimension(220, 50));
        textLogo.setVerticalAlignment(JLabel.CENTER);
        logo.setBorder(border);
        selectTicket = new JPanel(new BorderLayout());
        info = new JPanel();
        logo.setBackground(new Color(0, 115, 211));
        selectTicket.setBackground(new Color(9, 114, 201));
        info.setBackground(new Color(255, 255, 255));
        info.setPreferredSize(new Dimension(270, 40));
        borderSignIn.getBaseline(signInPanel, 1, 40);

        selectFrom = new JPanel(new BorderLayout());
        selectTo = new JPanel(new BorderLayout());
        signInPanel = new JPanel(new GridBagLayout());
        navbar = new JPanel(new BorderLayout());
        slideBar = new JPanel(new BorderLayout());
        booking = new JPanel(new BorderLayout());
        body = new JPanel(new BorderLayout());
        signIn = new JButton("Đăng nhập");
        areaSelect = new JPanel(new GridLayout(0, 1));

        // Căn lề datePicker
        leftAlignDatePicker = new JLabel("");
        rightAlignDatePicker = new JLabel("");
        datePickerSpace = new JLabel("");
        datePickerSpace.setPreferredSize(new Dimension(120, 20));
        leftAlignDatePicker.setPreferredSize(new Dimension(50, 25));
        rightAlignDatePicker.setPreferredSize(new Dimension(15, 25));
        alignDatePicker = new JPanel(new BorderLayout());
        alignDatePicker.setBackground(new Color(26, 126, 218));
//        alignDatePicker.setPreferredSize(new Dimension(120, 30));
        datePicker1 = new JPanel(new BorderLayout());
        datePicker1.setBackground(new Color(26, 126, 218));
        datePicker1.setPreferredSize(new Dimension(120, 60));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(new Date());
        String[] parts = date.split("/"); //returns an array with the 2 parts
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];
        UtilDateModel model = new UtilDateModel();
        model.setDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        Properties p = new Properties();
        p.put("text.today", "Hôm nay");
        p.put("text.month", "tháng");
        p.put("text.year", "năm");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        JFormattedTextField textField = datePicker.getJFormattedTextField();

        datePicker.setShowYearButtons(false);
        datePicker.setTextEditable(false);
        datePicker.setButtonFocusable(false);

        MatteBorder borderPicker = new MatteBorder(0, 0, 0, 0, new Color(26, 126, 218));
        changeButton = (JButton) datePicker.getComponent(1);
        changeButton.setToolTipText("OK");
        changeButton.setText("");

        changeButton.setIcon(new ImageIcon(new ImageIcon("images/calendar.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
        changeButton.setPreferredSize(new Dimension(15, 15));
        changeButton.setBackground(new Color(26, 126, 218));
        changeButton.setBorder(borderPicker);
        datePicker.getJFormattedTextField().setPreferredSize(new Dimension(120, 30));
        datePicker.getJFormattedTextField().setBackground(new Color(0xeaeaea));
        datePicker.getJFormattedTextField().setText(day + '-' + month + '-' + year);
        datePicker.setBackground(new Color(26, 126, 218));
        textField.setBackground(new Color(26, 126, 218));
        textField.setForeground(Color.WHITE);
        textField.setBorder(borderPicker);
        textField.setPreferredSize(new Dimension(100, 15));
        Font font1 = new Font("SansSerif", Font.BOLD, 16);
        textField.setFont(font1);

        alignDatePicker.add(leftAlignDatePicker, BorderLayout.WEST);
        alignDatePicker.add(datePicker, BorderLayout.CENTER);
        alignDatePicker.add(rightAlignDatePicker, BorderLayout.EAST);

        c1 = new JComboBox(list);
        c2 = new JComboBox(list);

        signInPanel.setBorder(borderSignIn);
        signInPanel.setPreferredSize(new Dimension(160, 60));
        signInPanel.setBackground(new Color(242, 243, 245));
        navbar.setBorder(borderNav);
        navbar.setBackground(new Color(242, 243, 245));
        navbar.setPreferredSize(new Dimension(200, 60));

        selectFrom.setBackground(new Color(26, 126, 218));
        selectTo.setBackground(new Color(26, 126, 218));
        slideBar.setBackground(new Color(0, 105, 192));
        booking.setBackground(new Color(242, 243, 245));
        slideBar.add(lb1);
        booking.add(lb2);
        logo.add(textLogo);
        info.add(textInfo);
        signIn.setBackground(new Color(0, 115, 211));
        signIn.setForeground(Color.white);
        signIn.setRolloverEnabled(false);
        signIn.setBorderPainted(false);
        signIn.setFocusPainted(false);
        signIn.setIcon(new ImageIcon(new ImageIcon("images/login2.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
        signIn.setIconTextGap(10);
        signIn.setPreferredSize(new Dimension(120, 30));
        signInPanel.add(signIn);

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

        // Custom JCompoBox
        checkClickJCompoBox1 = false;
        final JButton showCompoBox1 = new JButton();
        showCompoBox1.setToolTipText("Chọn Điểm Khởi Hành");
        showCompoBox1.setIcon(new ImageIcon(new ImageIcon("images/down-arrow.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
        showCompoBox1.setPreferredSize(new Dimension(45, 15));
        showCompoBox1.setBackground(new Color(26, 126, 218));
        showCompoBox1.setBorder(borderPicker);
        showCompoBox1.setBorderPainted(false);
        showCompoBox1.setFocusPainted(false);

        checkClickJCompoBox2 = false;
        final JButton showCompoBox2 = new JButton();
        showCompoBox2.setToolTipText("Chọn Điểm Đến");
        showCompoBox2.setIcon(new ImageIcon(new ImageIcon("images/down-arrow.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
        showCompoBox2.setPreferredSize(new Dimension(45, 15));
        showCompoBox2.setBackground(new Color(26, 126, 218));
        showCompoBox2.setBorder(borderPicker);
        showCompoBox2.setBorderPainted(false);
        showCompoBox2.setFocusPainted(false);

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

        showCompoBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //then you know that is attached to this button
                if (!checkClickJCompoBox1) {
                    c1.setPopupVisible(true);
                }
                checkClickJCompoBox1 = !checkClickJCompoBox1;
            }
        });

        showCompoBox2.addActionListener(new ActionListener() {
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
        selectFrom.add(showCompoBox1, BorderLayout.EAST);
        MatteBorder borderSelect = new MatteBorder(0, 0, 1, 0, new Color(48, 148, 238));
        selectFrom.setBorder(borderSelect);
        selectTo.setBorder(borderSelect);

        selectTo.add(textSelectTo, BorderLayout.WEST);
        selectTo.add(c2, BorderLayout.CENTER);
        selectTo.add(showCompoBox2, BorderLayout.EAST);

//        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        selectTicket.add(areaSelect, BorderLayout.NORTH);
        areaSelect.add(selectFrom);
        areaSelect.add(selectTo);
        datePicker1.add(datePickerSpace, BorderLayout.NORTH);
        datePicker1.add(alignDatePicker, BorderLayout.CENTER);
        areaSelect.add(datePicker1);
//        selectTicket.add(selectTo, BorderLayout.CENTER);
        selectTicket.setPreferredSize(new Dimension(200, 240));

//        ImageIcon iconBackground = new ImageIcon("images/background.png");
        JLabel thumb = new JLabel();
//        thumb.add(new ImagePanel(img));
//        thumb.setIcon(new ImageIcon(new ImageIcon("images/background.png").getImage().getScaledInstance(630, 440, Image.SCALE_DEFAULT)));
        bgMain = new JPanel(new BorderLayout());

        try {
            Image img = null;
            img = ImageIO.read(new File("images/background.png"));
            bgMain.add(new ImagePanel(img));
            System.out.println(bgMain.getWidth() - 1);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }
//        thumb.getWidth();
//            bgMain.add(thumb);

            booking.add(navbar, BorderLayout.NORTH);
            navbar.add(signInPanel, BorderLayout.EAST);
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
    }

    public void handleEvent() {
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new LoginFrame();
            }
        });
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
