/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import static layout.Content.areaPanel;
import static layout.Navbar.navLogin;
import static layout.Navbar.navIsLogin;
import static layout.SelectTicket.listTicket;
import static layout.Content.dashboard;
import static layout.Content.home;
import static layout.Content.navbar;
import static layout.Login.hello;
import static layout.Login.spaceHello;
import static layout.SlideBar.menuDashboard;
import static layout.SlideBar.selectTicket;
import static layout.SlideBarMain.slideBar;

/**
 *
 * @author my pc
 */
public class NavIsLogin extends JPanel {
    final MatteBorder borderSignIn;
    static JButton btnLogout;
    
    public NavIsLogin() {
        borderSignIn = new MatteBorder(0, 0, 0, 0, new Color(227, 228, 231));
        borderSignIn.getBaseline(this, 1, 40);

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(160, 60));
        this.setBackground(new Color(242, 243, 245));
        this.setBorder(borderSignIn);
        addControls();
    }
    
    public void addControls() {
        btnLogout = new JButton("Đăng xuất");

        btnLogout.setBackground(new Color(0, 115, 211));
        btnLogout.setForeground(Color.white);
        btnLogout.setRolloverEnabled(false);
        btnLogout.setBorderPainted(false);
        btnLogout.setFocusPainted(false);
        btnLogout.setIcon(new ImageIcon(new ImageIcon("images/log-out.png").getImage().getScaledInstance(17, 17, Image.SCALE_DEFAULT)));
        btnLogout.setIconTextGap(10);
        btnLogout.setPreferredSize(new Dimension(120, 30));
        
        this.add(btnLogout);
        
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaPanel.removeAll();
                areaPanel.add(home, BorderLayout.CENTER);
                slideBar.remove(menuDashboard);
                navbar.removeAll();
                navbar.add(navLogin, BorderLayout.EAST);

//                SelectTicket selectTicket2 = new SelectTicket();
                slideBar.add(selectTicket, BorderLayout.CENTER);
                areaPanel.validate();
                areaPanel.repaint();
                navbar.validate();
                navbar.repaint();
                slideBar.validate();
                slideBar.repaint();
            }
        });
    }

    public JButton getbtnLogin() {
        return btnLogout;
    }
}
