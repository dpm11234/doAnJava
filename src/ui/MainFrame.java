package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class MainFrame {

    private JFrame frame;
    private JPanel body, slideBar, booking, logo, selectTicket, info, navbar, signInPanel;
    static JLabel lb1, lb2, textLogo, imageLogo;
    static JButton signIn;
    ImageIcon icon;

    public MainFrame() {
        createAndShow();
        handleEvent();
    }

    public void createAndShow() {
        frame = new JFrame("Đặt Vé Xe");
        icon = new ImageIcon("images/iconb.png");
        frame.setIconImage(icon.getImage());
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        lb1 = new JLabel("Panel 1");
        lb2 = new JLabel("Panel 2");

        textLogo = new JLabel("<html><font style='font-size: 16px; font-family: \"Trebuchet MS\", Helvetica, sans-serif' color='white'> VÉ VI VU</font></html>", SwingConstants.CENTER);
        textLogo.setPreferredSize(new Dimension(200, 50));
//        textLogo.setVerticalAlignment();
        imageLogo = new JLabel("Info");
        textLogo.setIcon(new ImageIcon(new ImageIcon("images/logo.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));

        MatteBorder border = new MatteBorder(0, 0, 1, 0, new Color(35, 126, 212));
        MatteBorder borderNav = new MatteBorder(0, 0, 1, 0, new Color(227, 228, 231));
        MatteBorder borderSignIn = new MatteBorder(0, 1, 0, 0, new Color(227, 228, 231));
        logo = new JPanel();
        logo.setPreferredSize(new Dimension(200, 60));
        logo.setBorder(border);
        selectTicket = new JPanel();
        info = new JPanel();
        logo.setBackground(new Color(0, 115, 211));
        selectTicket.setBackground(new Color(9, 114, 201));
        info.setBackground(new Color(255, 255, 0));
        borderSignIn.getBaseline(signInPanel, 1, 40);

        signInPanel = new JPanel(new GridBagLayout());
        navbar = new JPanel(new BorderLayout());
        slideBar = new JPanel(new BorderLayout());
        booking = new JPanel(new BorderLayout());
        body = new JPanel(new BorderLayout());
        signIn = new JButton("Đăng nhập");

        signInPanel.setBorder(borderSignIn);
        signInPanel.setPreferredSize(new Dimension(120, 60));
        signInPanel.setBackground(new Color(242, 243, 245));
        navbar.setBorder(borderNav);
        navbar.setBackground(new Color(242, 243, 245));
        navbar.setPreferredSize(new Dimension(200, 60));
        slideBar.setBackground(new Color(0, 105, 192));
        booking.setBackground(new Color(226, 228, 233));
        signIn.setBackground(new Color(0, 115, 211));
        signIn.setForeground(Color.white);

        slideBar.add(lb1);
        booking.add(lb2);
        logo.add(textLogo);
        info.add(imageLogo);

        signInPanel.add(signIn);
        booking.add(navbar, BorderLayout.NORTH);
        navbar.add(signInPanel, BorderLayout.EAST);
        slideBar.add(logo, BorderLayout.NORTH);
        slideBar.add(selectTicket, BorderLayout.CENTER);
        slideBar.add(info, BorderLayout.SOUTH);

        body.add(slideBar, BorderLayout.WEST);
        body.add(booking, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.add(body);
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
