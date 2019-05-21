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
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import static layout.Content.areaPanel;
import static layout.Content.home;
import static layout.Content.login;
import static layout.Content.navbar;
import static layout.Navbar.navBackHome;
import static layout.Navbar.navLogin;
import static layout.SelectTicket.listTicket;

/**
 *
 * @author my pc
 */
public class NavLogin extends JPanel {

    final MatteBorder borderSignIn;
    static JButton btnLogin;

    public NavLogin() {
        borderSignIn = new MatteBorder(0, 0, 0, 0, new Color(227, 228, 231));
        borderSignIn.getBaseline(this, 1, 40);

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(160, 60));
        this.setBackground(new Color(242, 243, 245));
        this.setBorder(borderSignIn);
        addControls();
    }

    public void addControls() {
        btnLogin = new JButton("Đăng nhập");

        btnLogin.setBackground(new Color(0, 115, 211));
        btnLogin.setForeground(Color.white);
        btnLogin.setRolloverEnabled(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setIcon(new ImageIcon(new ImageIcon("images/login2.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
        btnLogin.setIconTextGap(10);
        btnLogin.setPreferredSize(new Dimension(120, 30));

        this.add(btnLogin);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaPanel.remove(home);
                areaPanel.remove(listTicket);
                areaPanel.add(login, BorderLayout.CENTER);
                navbar.remove(navLogin);
                navbar.add(navBackHome, BorderLayout.EAST);
                areaPanel.validate();
                areaPanel.repaint();
                navbar.validate();
                navbar.repaint();
            }
        });
    }

    public JButton getbtnLogin() {
        return btnLogin;
    }

}
