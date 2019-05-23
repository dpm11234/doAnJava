package layout;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static layout.Content.navbar;
import static layout.Navbar.*;
import static util.Session.isLogin;
import static util.Session.ssMaNX;

public class NavLogout extends JPanel {

    final MatteBorder borderLogout;
    static JButton btnLogout;

    public NavLogout() {
        borderLogout = new MatteBorder(0, 0, 0, 0, new Color(227, 228, 231));
        borderLogout.getBaseline(this, 1, 40);
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(160, 60));
        this.setBackground(new Color(242, 243, 245));
        this.setBorder(borderLogout);
        addControls();
    }

    public void addControls() {
        btnLogout = new JButton("Đăng xuất");

        btnLogout.setBackground(new Color(0, 115, 211));
        btnLogout.setForeground(Color.white);
        btnLogout.setRolloverEnabled(false);
        btnLogout.setBorderPainted(false);
        btnLogout.setFocusPainted(false);
        btnLogout.setIcon(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
        btnLogout.setIconTextGap(10);
        btnLogout.setPreferredSize(new Dimension(120, 30));

        this.add(btnLogout);

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLogin = false;
                ssMaNX = null;
                navbar.remove(navLogout);
                navbar.add(navLogin, BorderLayout.EAST);
                navbar.validate();
                navbar.repaint();
            }
        });
    }

}
