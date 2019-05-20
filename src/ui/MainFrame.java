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
//import javax.swing.plaf.ComboBoxUI;
//import javax.swing.plaf.basic.BasicArrowButton;
//import javax.swing.plaf.basic.BasicComboBoxUI;
//import javax.swing.plaf.metal.MetalComboBoxButton;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JFormattedTextField.AbstractFormatter;

import bus.NhaXeBUS;
import dto.NhaXeDTO;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;
import java.net.URL;
// ww w  .ja v a 2 s.  com
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import org.jdesktop.swingx.JXTextField;
import ui.Panel.Main.BackgroudMain;

import ui.Panel.Main.LoginPanel;
import ui.Panel.Main.NavbarPanel;
import ui.Panel.Main.DatePicker;
import ui.Panel.Main.ButtonShowCompoBox;

public class MainFrame extends JFrame {

    private JFrame frame;
    private JPanel body, slideBar, booking, logo, selectTicket, areaSelect, info, selectFrom, selectTo, loginFormPanel, mainPanel, ticketPanel;
    static JLabel lb1, lb2, textLogo, textInfo, textSelect, textSelectSpace, textSelectTo, textSelectSpaceTo, datePickerSpace, leftAlignDatePicker, rightAlignDatePicker;
    static JButton changeButton;
    ImageIcon icon;
    String list[] = {"TP.HCM", "Đồng Nai", "Bình Dương", "Vũng Tàu", "Long An", "Tay Ninh"};
    static JComboBox c1, c2;

    private LoginPanel loginPanel;
    private NavbarPanel navbarPanel;
    BackgroudMain bgMain;
    static boolean checkClickJCompoBox1, checkClickJCompoBox2;
    int currentTo, currentFrom;

    private JTextField user;
    private JPasswordField textPass;
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

    class ImagePanel extends JPanel {

        private static final long serialVersionUID = 1L;

        private Image img;
        private Image scaled;
        private int x = 0;
        private int y = 0;

        public ImagePanel(Image img) {
            this.img = img;
        }

        public ImagePanel(Image img, int x, int y) {
            this.img = img;
            this.x = x;
            this.y = y;
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
            if (x != 0 && y != 0) {
                return img == null ? new Dimension(200, 200) : new Dimension(x, y);
            } else {
                return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(this), img.getHeight(this));
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(scaled, 0, 0, null);
        }
    }

    class ImageButton extends JButton {

        private static final long serialVersionUID = 1L;

        private Image img;
        private Image scaled;
        private int x = 0;
        private int y = 0;

        public ImageButton(Image img) {
            this.img = img;
        }

        public ImageButton(Image img, int x, int y) {
            this.img = img;
            this.x = x;
            this.y = y;
        }

        @Override
        public void invalidate() {
            super.invalidate();
            int width = getWidth();
            int height = getHeight();
            System.out.println(width);

            if (width > 0 && height > 0) {
                scaled = img.getScaledInstance(getWidth(), getHeight(),
                        Image.SCALE_SMOOTH);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            if (x != 0 && y != 0) {
                return img == null ? new Dimension(200, 200) : new Dimension(x, y);
            } else {
                return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(this), img.getHeight(this));
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(scaled, 0, 0, null);
        }
    }

    class RoundedCornerBorder extends AbstractBorder {

        int r;

        public RoundedCornerBorder(int r) {
            this.r = r;
        }
        private final Color ALPHA_ZERO = new Color(0x0, true);

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//            System.out.println(this.r);
            Shape border = getBorderShape(x, y, width - 1, height - 1, this.r);
            g2.setPaint(ALPHA_ZERO);
            Area corner = new Area(new Rectangle2D.Double(x, y, width, height));
            corner.subtract(new Area(border));
            g2.fill(corner);
            g2.setPaint(new Color(230, 230, 230));
            g2.draw(border);
            g2.dispose();
        }

        public Shape getBorderShape(int x, int y, int w, int h, int r) {
//            int r = 20; //h / 2;
            return new RoundRectangle2D.Double(x, y, w, h, r, r);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(4, 8, 4, 8);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.set(4, 8, 4, 8);
            return insets;
        }
    }

    class JPanelInput extends JPanel {

        int r;

        JPanelInput(int r) {
            this.r = r;
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setPaint(getBackground());
                g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
                        0, 0, getWidth() - 1, getHeight() - 1, this.r));
                g2.dispose();
                setBorder(new RoundedCornerBorder(this.r));
            }
            super.paintComponent(g);
        }

        @Override
        public void updateUI() {
            super.updateUI();
            setOpaque(false);
            setBorder(new RoundedCornerBorder(this.r));
        }
    }

    public static boolean openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean openWebpage(URL url) {
        try {
            return openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createAndShow() {

        frame = new JFrame("Vé Vi Vu");
        icon = new ImageIcon("images/iconb.png");
        frame.setIconImage(icon.getImage());
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lb1 = new JLabel("Panel 1");
        lb2 = new JLabel("Panel 2");
        
        loginPanel = new LoginPanel();
        navbarPanel = new NavbarPanel();
        bgMain = new BackgroudMain();
        DatePicker datePicker = new DatePicker();
        mainPanel = new JPanel();
        
        ticketPanel = new JPanel();
        
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

        selectFrom = new JPanel(new BorderLayout());
        selectTo = new JPanel(new BorderLayout());
        slideBar = new JPanel(new BorderLayout());
        booking = new JPanel(new BorderLayout());
        body = new JPanel(new BorderLayout());
        areaSelect = new JPanel(new GridLayout(0, 1));


        MatteBorder borderPicker = new MatteBorder(0, 0, 0, 0, new Color(26, 126, 218));


        c1 = new JComboBox(list);
        c2 = new JComboBox(list);

        selectFrom.setBackground(new Color(26, 126, 218));
        selectTo.setBackground(new Color(26, 126, 218));
        slideBar.setBackground(new Color(0, 105, 192));
        booking.setBackground(new Color(242, 243, 245));
        slideBar.add(lb1);
        booking.add(lb2);
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
        areaSelect.add(datePicker);
//        selectTicket.add(selectTo, BorderLayout.CENTER);
        selectTicket.setPreferredSize(new Dimension(200, 240));

//        ImageIcon iconBackground = new ImageIcon("images/background.png");
        JLabel thumb = new JLabel();
//        thumb.add(new ImagePanel(img));
//        thumb.setIcon(new ImageIcon(new ImageIcon("images/background.png").getImage().getScaledInstance(630, 440, Image.SCALE_DEFAULT)));

//        try {
//            Image img = null;
//            img = ImageIO.read(new File("images/background.png"));
//            JPanel BgHello = new ImagePanel(img);
//            bgMain.add(BgHello);
//            System.out.println(bgMain.getWidth() - 1);
//        } catch (IOException | HeadlessException exp) {
//            exp.printStackTrace();
//        }
        JPanel loginBg = new JPanel();
        try {
            Image imgLogin = null;
            imgLogin = ImageIO.read(new File("images/loginbackground.png"));
            loginBg = new ImagePanel(imgLogin);
            loginBg.setLayout(new GridLayout(1, 0));
            //bgMain.add(loginBg);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }

        JPanel loginFormLayout = new JPanel(new GridBagLayout());
        loginFormLayout.setPreferredSize(new Dimension(230, 300));
        loginFormLayout.setBackground(new Color(255, 255, 255));

        JPanel loginForm = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 15));
        loginForm.setPreferredSize(new Dimension(230, 300));
        loginForm.setBackground(new Color(255, 255, 255));

        // Tạo JTextField + Custom Style
//        JTextField user = new JTextField(26);
        user = new JTextField(26);
        MatteBorder borderInputLogin = new MatteBorder(0, 0, 0, 0, new Color(0, 0, 0));
        user.setBorder(borderInputLogin);
        user.setText("Tài Khoản");
        user.setForeground(new Color(180, 180, 180));
        Font fontInputLogin = new Font("SansSerif", Font.BOLD, 14);
        user.setFont(fontInputLogin);
        user.setPreferredSize(new Dimension(230, 40));
        user.setBackground(new Color(230, 230, 230));

        // Tạo placeholder cho JTextField
        // Đưa con trỏ về đầu JTextField khi Focus
        user.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                Object source = e.getSource();
                if (source instanceof JTextComponent) {
                    JTextComponent comp = (JTextComponent) source;
                    comp.setCaretPosition(0);
                }
            }
        });

        // Ẩn hiện placeholder
        user.addKeyListener(new KeyAdapter() {
            int countKey = 0;
            boolean checkKey = false;

            @Override
            public void keyPressed(KeyEvent e) {
                if ("".equals(user.getText())) {

                } else {
                    if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                        System.out.println(e.getKeyCode());
                        checkKey = true;
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if ("".equals(user.getText())) {
                    user.setText("Tài Khoản");
                    user.setForeground(new Color(192, 192, 192));
                    Object source = e.getSource();
                    if (source instanceof JTextComponent) {
                        JTextComponent comp = (JTextComponent) source;
                        comp.setCaretPosition(0);
                    }
                    countKey = 0;
                    checkKey = false;
                } else {
                    if (!checkKey) {
                        if (countKey == 0) {
                            user.setText("");
                            user.setForeground(new Color(104, 104, 104));
                            countKey = 1;
                        }
                    } else {
                        checkKey = false;
                    }
                }
            }
        });

        // Block (khóa) con trỏ khi hiện placeholder
        user.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if ("Tài Khoản".equals(user.getText())) {
                    Object source = e.getSource();
                    if (source instanceof JTextComponent) {
                        JTextComponent comp = (JTextComponent) source;
                        comp.setCaretPosition(0);
                    }
                }
            }
        });
        // End placeholder

        // Tạo icon cho JTextField
        JPanel inputUser = new JPanelInput(25);
        inputUser.setLayout(new BorderLayout());
        inputUser.setBackground(new Color(230, 230, 230));
        inputUser.setPreferredSize(new Dimension(230, 40));
        JLabel imageUser = new JLabel();
        imageUser.setPreferredSize(new Dimension(32, 40));
        imageUser.setIcon(new ImageIcon(new ImageIcon("images/user.png").getImage().getScaledInstance(22, 15, Image.SCALE_DEFAULT)));
        inputUser.add(imageUser, BorderLayout.WEST);
        inputUser.add(user, BorderLayout.CENTER);

        // Tạo JTextField + Custom Style
//        JPasswordField textPass = new JPasswordField();
        textPass = new JPasswordField();
        MatteBorder borderInputPass = new MatteBorder(0, 0, 0, 0, new Color(0, 0, 0));
        textPass.setBorder(borderInputLogin);
        textPass.setText("Mật Khẩu");
        textPass.setForeground(new Color(180, 180, 180));
        Font fontInputPass = new Font("SansSerif", Font.BOLD, 14);
        textPass.setFont(fontInputLogin);
        textPass.setPreferredSize(new Dimension(230, 40));
        textPass.setBackground(new Color(230, 230, 230));

        // Tạo placeholder cho JTextField
        // Đưa con trỏ về đầu JTextField khi Focus
        textPass.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                Object source = e.getSource();
                if (source instanceof JTextComponent) {
                    JTextComponent comp = (JTextComponent) source;
                    comp.setCaretPosition(0);
                }
            }
        });

        // Ẩn hiện placeholder
        textPass.addKeyListener(new KeyAdapter() {
            int countKey = 0;
            boolean checkKey = false;

            @Override
            public void keyPressed(KeyEvent e) {
                if ("".equals(textPass.getText())) {

                } else {
                    if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                        System.out.println(e.getKeyCode());
                        checkKey = true;
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if ("".equals(textPass.getText())) {
                    textPass.setText("Mật Khẩu");
                    textPass.setForeground(new Color(192, 192, 192));
                    Object source = e.getSource();
                    if (source instanceof JTextComponent) {
                        JTextComponent comp = (JTextComponent) source;
                        comp.setCaretPosition(0);
                    }
                    countKey = 0;
                    checkKey = false;
                } else {
                    if (!checkKey) {
                        if (countKey == 0) {
                            textPass.setText("");
                            textPass.setForeground(new Color(104, 104, 104));
                            countKey = 1;
                        }
                    } else {
                        checkKey = false;
                    }
                }
            }
        });

        // Block (khóa) con trỏ khi hiện placeholder
        textPass.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if ("Mật Khẩu".equals(textPass.getText())) {
                    Object source = e.getSource();
                    if (source instanceof JTextComponent) {
                        JTextComponent comp = (JTextComponent) source;
                        comp.setCaretPosition(0);
                    }
                }
            }
        });
        // End placeholder

        // Tạo icon cho JTextField
        JPanel inputPass = new JPanelInput(25);
        inputPass.setLayout(new BorderLayout());
        inputPass.setBackground(new Color(230, 230, 230));
        inputPass.setPreferredSize(new Dimension(230, 40));
        JLabel imagePass = new JLabel();
        imagePass.setPreferredSize(new Dimension(34, 40));
        imagePass.setIcon(new ImageIcon(new ImageIcon("images/pass2.png").getImage().getScaledInstance(28, 16, Image.SCALE_DEFAULT)));
        inputPass.add(imagePass, BorderLayout.WEST);
        inputPass.add(textPass, BorderLayout.CENTER);

        // Title Login
        JLabel titleLogin = new JLabel("Đăng Nhập Quản Trị");
        Font fontTitleLogin = new Font("SansSerif", Font.BOLD, 20);
        titleLogin.setFont(fontTitleLogin);
        titleLogin.setVerticalAlignment(JLabel.CENTER);
        titleLogin.setHorizontalAlignment(JLabel.CENTER);
        titleLogin.setPreferredSize(new Dimension(230, 40));

        // Button Login
        JPanel buttonLoginPanel = new JPanel(new GridBagLayout());
        try {
            Image imgButtonLogin = null;
            imgButtonLogin = ImageIO.read(new File("images/buttonlogin.png"));
            buttonLoginPanel = new ImagePanel(imgButtonLogin, 230, 40);
            buttonLoginPanel.setPreferredSize(new Dimension(230, 40));
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }

        JButton buttonLogin = new JButton("Đăng Nhập");
        buttonLogin.setPreferredSize(new Dimension(230, 30));
        buttonLogin.setBackground(new Color(0, 0, 0, 0));
        buttonLogin.setForeground(Color.white);
        buttonLogin.setRolloverEnabled(false);
        buttonLogin.setBorderPainted(false);
        buttonLogin.setFocusPainted(false);
        buttonLogin.setContentAreaFilled(false);
        buttonLoginPanel.add(buttonLogin);
        buttonLoginPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // JLable đăng ký
        JLabel regLinkSpace = new JLabel("");
        regLinkSpace.setPreferredSize(new Dimension(230, 20));
        
        
        JLabel regLink = new JLabel("Đăng ký trở thành nhà xe  →");
        Font fontRegLink = new Font("SansSerif", Font.ITALIC, 14);
        regLink.setFont(fontRegLink);
        regLink.setPreferredSize(new Dimension(230, 20));
        regLink.setForeground(new Color(26, 126, 218));
        regLink.setVerticalAlignment(JLabel.CENTER);
        regLink.setHorizontalAlignment(JLabel.CENTER);
        regLink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        regLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.google.com"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Thêm input JTextField vào form
        loginForm.add(titleLogin);
        loginForm.add(inputUser);
        loginForm.add(inputPass);
        loginForm.add(buttonLoginPanel);
        loginForm.add(regLinkSpace);
        loginForm.add(regLink);

        JPanel loginAlign = new JPanel(new BorderLayout());
        JPanel loginAlignSpace = new JPanel(new BorderLayout());
        loginAlignSpace.setBackground(new Color(255, 255, 255));
        JLabel loginSpaceLeft = new JLabel();
        loginSpaceLeft.setPreferredSize(new Dimension(120, 40));
        loginAlignSpace.add(loginSpaceLeft, BorderLayout.WEST);
        loginAlignSpace.add(loginForm, BorderLayout.CENTER);

        loginFormLayout.add(loginAlignSpace);

        JPanel loginSpace = new JPanel(new BorderLayout());
        loginSpace.setBackground(new Color(200, 12, 223, 0));
        loginBg.add(loginFormLayout);
        loginBg.add(loginSpace);
        
        loginFormPanel = new JPanel();
        loginFormPanel.setLayout(new BorderLayout());
        
        loginFormPanel.add(loginBg, BorderLayout.CENTER);
        
        //bgMain.add(loginFormPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(bgMain, BorderLayout.CENTER);
        
        booking.add(navbarPanel, BorderLayout.NORTH);
        navbarPanel.add(loginPanel, BorderLayout.EAST);
        booking.add(mainPanel, BorderLayout.CENTER);

        slideBar.add(logo, BorderLayout.NORTH);
        slideBar.add(selectTicket, BorderLayout.CENTER);
        slideBar.add(info, BorderLayout.SOUTH);

        body.add(slideBar, BorderLayout.WEST);
        body.add(booking, BorderLayout.CENTER);

//        loginPanel.getbtnLogin().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainPanel.remove(bgMain);
//                mainPanel.add(loginFormPanel, BorderLayout.CENTER);
//                body.repaint();
//            }
//        });


        
        // Xử lý sự kiện

        loginPanel.getbtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.remove(bgMain);
                mainPanel.remove(ticketPanel);
                mainPanel.add(loginFormPanel, BorderLayout.CENTER);
                mainPanel.validate();
                mainPanel.repaint();
            }
        });
        
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(login()) {
                    mainPanel.remove(loginFormPanel);
                    ticketPanel = new JPanel();
                    ticketPanel.add(new JButton("Test"));
                    mainPanel.add(ticketPanel);
                    mainPanel.validate();
                    mainPanel.repaint();
                } else {
                    JOptionPane.showMessageDialog(frame, "Tài khoản hoặc mật khẩu không đúng");
                }
            }
        });
        
        currentFrom = c1.getSelectedIndex();
        currentTo = c2.getSelectedIndex();
        
        c1.addActionListener(new ActionListener() {
//            final int selected = c1.getSelectedIndex();
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = c1.getSelectedIndex();
                if(selected != currentFrom) {
                    mainPanel.remove(bgMain);
                    ticketPanel.add(new JButton("Test"));
                    mainPanel.add(ticketPanel);
                    mainPanel.validate();
                    mainPanel.repaint();
                    currentFrom = selected;
                }
            }
            
        });
        
        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = c2.getSelectedIndex();
                if(selected != currentFrom) {
                    mainPanel.remove(bgMain);
                    ticketPanel.add(new JButton("Test"));
                    mainPanel.add(ticketPanel);
                    mainPanel.validate();
                    mainPanel.repaint();
                    currentTo = selected;
                }
            }
        });
        
        
        frame.setVisible(true);
        frame.add(body);
    }

    public boolean login() {

        ArrayList<NhaXeDTO> dsNhaXe = new ArrayList<>();
        dsNhaXe = NhaXeBUS.nhaXeAll();

        NhaXeDTO nhaXe;

        for(NhaXeDTO nx : dsNhaXe) {
            nhaXe = nx;
            if(nhaXe.getUsername().equals(user.getText())) {
                System.out.println("Dung user name");
                System.out.println("Pass: " + textPass.getText());
                if(nhaXe.getPassword().equals(textPass.getText())) {
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        new MainFrame();
    }
}
