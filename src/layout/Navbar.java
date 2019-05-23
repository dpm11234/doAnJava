package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

// import Layout

import layout.NavLogin;
import layout.NavBackHome;

/**
 *
 * @author my pc
 */
public class Navbar extends JPanel{
    static NavLogin navLogin;
    static NavBackHome navBackHome;
    static NavLogout navLogout;

    public Navbar() {
        MatteBorder borderNav = new MatteBorder(0, 0, 1, 0, new Color(227, 228, 231));

        this.setLayout(new BorderLayout());
        this.setBorder(borderNav);
        this.setBackground(new Color(242, 243, 245));
        this.setPreferredSize(new Dimension(200, 60));
        
        navLogin = new NavLogin();
        navBackHome = new NavBackHome();
        navLogout = new NavLogout();
        this.add(navLogin, BorderLayout.EAST);
    }
}
