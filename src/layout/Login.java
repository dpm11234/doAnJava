package layout;

import bus.NhaXeBUS;
import dto.NhaXeDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;
import static layout.Content.areaPanel;
import static layout.Content.login;
import createUI.ImagePanel;
import createUI.JPanelInput;
import static layout.Content.navbar;
import layout.Dashboard;
import static layout.Navbar.navIsLogin;
import static layout.Navbar.navBackHome;
import static layout.SlideBar.menuDashboard;
import static layout.SlideBarMain.slideBar;
import static layout.SlideBar.selectTicket;
import util.Session;

import static layout.NavBackHome.btnBackLogin;
import static util.Session.isLogin;
import static util.Session.ssMaNX;

/**
 *
 * @author my pc
 */
public class Login extends JPanel {
    private JTextField user;
    private JPasswordField textPass;
    private JFrame frame;
    static Dashboard dashboard;
    static JLabel hello, spaceHello;
    
    public Login() {
        this.setLayout(new BorderLayout());
        
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
        
        this.add(loginBg, BorderLayout.CENTER);
        
        
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(login()) {
                    menuDashboard = new MenuDashboard();
                    hello = new JLabel("Xin chào nhà xe: HiHi " + Session.tenNX);
                    spaceHello = new JLabel();
                    spaceHello.setPreferredSize(new Dimension(20, 50));
                    Font fontHello = new Font("SansSerif", Font.BOLD, 15);
                    hello.setFont(fontHello);
                    dashboard = new Dashboard();
                    areaPanel.remove(login);
                    areaPanel.add(dashboard, BorderLayout.CENTER);
                    navbar.remove(navBackHome);
                    navbar.add(navIsLogin, BorderLayout.EAST);
                    navbar.add(hello, BorderLayout.CENTER);
                    navbar.add(spaceHello, BorderLayout.WEST);
                    slideBar.remove(selectTicket);
                    slideBar.add(menuDashboard, BorderLayout.CENTER);
                    areaPanel.validate();
                    areaPanel.repaint();
                    navbar.validate();
                    navbar.repaint();
                    slideBar.validate();
                    slideBar.repaint();
                    System.out.println("hihi");
                } else {
                    JOptionPane.showMessageDialog(frame, "Tài khoản hoặc mật khẩu không đúng");
                }
            }
        });

    }
    
    public boolean login() {

        ArrayList<NhaXeDTO> dsNhaXe = new ArrayList<>();
        dsNhaXe = NhaXeBUS.getAll();

        NhaXeDTO nhaXe;
        for(NhaXeDTO nx : dsNhaXe) {
            nhaXe = nx;
            if(nhaXe.getUsername().equals(user.getText())) {
//                System.out.println("Dung user name");
//                System.out.println("Pass: " + textPass.getText());
                if(nhaXe.getPassword().equals(textPass.getText())) {
//                    System.out.println("Pass dung!");
                    isLogin = true;
                    Session.ssMaNX = nhaXe.getMaNX();
                    Session.tenNX = nhaXe.getTenNX();
                    System.out.println(ssMaNX);
                    return true;
                }
                else{
                    System.out.println("Pass sai!"); 
               }
            }
        }

        return false;
    }
}
