package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

// import Layout

import layout.Navbar;
import layout.Home;
import layout.Login;
import layout.Dashboard;

/**
 *
 * @author my pc
 */
public class Content extends JPanel {
    static Navbar navbar;
    static JPanel areaPanel;
    static Home home;
    static Login login;
    static Dashboard dashboard;
    
    public Content() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(242, 243, 245));
        
        areaPanel = new JPanel();
        areaPanel.setLayout(new BorderLayout());
        
        navbar = new Navbar();
        home = new Home();
        login = new Login();
        dashboard = new Dashboard();
        
        areaPanel.add(home, BorderLayout.CENTER);
        
        this.add(navbar, BorderLayout.NORTH);
        this.add(areaPanel, BorderLayout.CENTER);
    }
}
