package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import static layout.Content.areaPanel;

// import Layout

import layout.Info;
import layout.Logo;
import layout.SelectTicket;
import static layout.SelectTicket.checkClickJCompoBox1;
import static layout.SelectTicket.checkClickJCompoBox2;
import static layout.SelectTicket.c1;
import static layout.SelectTicket.c2;
import layout.MenuDashboard;

/**
 *
 * @author my pc
 */
public class SlideBar extends JPanel {
    static MenuDashboard menuDashboard;
    static SelectTicket selectTicket;
    public SlideBar(){
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0, 105, 192));
        
        Info info = new Info();
        Logo logo = new Logo();
        selectTicket = new SelectTicket();
        menuDashboard = new MenuDashboard();
        
        this.add(logo, BorderLayout.NORTH);
        this.add(selectTicket, BorderLayout.CENTER);
        this.add(info, BorderLayout.SOUTH);
    }
    
    
    
    public void changeSelectC1() {
        checkClickJCompoBox1 = false;
        areaPanel.validate();
        areaPanel.repaint();
    }
    
    public void changeSelectC2() {
        checkClickJCompoBox2 = false;
        areaPanel.validate();
        areaPanel.repaint();
    }
    
    public JComboBox getC1() {
        return c1;
    }
    
    public JComboBox getC2() {
        return c2;
    }
}
