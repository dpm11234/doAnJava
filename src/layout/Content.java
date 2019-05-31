package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

// import Layout

import layout.Navbar;
import layout.Home;
import layout.Login;
import layout.Dashboard;
import layout.AddTicket;

/**
 *
 * @author my pc
 */
public class Content extends JPanel {
    public static Navbar navbar;
    public static JPanel areaPanel;
    public static Home home;
    public static Login login;
    public static Dashboard dashboard;
    public static AddTicket addTicket;
    public static BookedTicket bookedTicket;
    
    public Content() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(242, 243, 245));
        
        areaPanel = new JPanel();
        areaPanel.setLayout(new BorderLayout());
        
        navbar = new Navbar();
        home = new Home();
        login = new Login();
        dashboard = new Dashboard();
        addTicket = new AddTicket();
        bookedTicket = new BookedTicket();
        
        areaPanel.add(home, BorderLayout.CENTER);
        
        this.add(navbar, BorderLayout.NORTH);
        this.add(areaPanel, BorderLayout.CENTER);
    }
}
