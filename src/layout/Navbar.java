package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import static layout.Content.navbar;

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
    static NavIsLogin navIsLogin;
    static NavBackSelect navBackSelect;
    static JLabel titleSpace;
    
    public Navbar() {
        MatteBorder borderNav = new MatteBorder(0, 0, 1, 0, new Color(227, 228, 231));
        MatteBorder borderTest = new MatteBorder(1, 1, 1, 1, new Color(1, 1, 1));

        this.setLayout(new BorderLayout());
        this.setBorder(borderNav);
        this.setBackground(new Color(242, 243, 245));
        this.setPreferredSize(new Dimension(600, 60));
        
        titleSpace = new JLabel("");
        titleSpace.setPreferredSize(new Dimension(160, 60));
        
        navLogin = new NavLogin();
        navBackHome = new NavBackHome();
        navIsLogin = new NavIsLogin();
        navBackSelect = new NavBackSelect();
        this.add(titleSpace, BorderLayout.WEST);
        this.add(navLogin, BorderLayout.EAST);
    }
}
