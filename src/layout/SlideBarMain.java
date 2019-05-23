/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import static layout.SelectTicket.checkClickJCompoBox1;
import static layout.SelectTicket.checkClickJCompoBox2;

/**
 *
 * @author my pc
 */
public class SlideBarMain extends JPanel {
    static SlideBar slideBar;
    
    public SlideBarMain() {
        this.setLayout(new BorderLayout());
        slideBar = new SlideBar();
        this.add(slideBar);
    }
    
    public void changeSelectC1() {
        checkClickJCompoBox1 = false;
    }
    
    public void changeSelectC2() {
        checkClickJCompoBox2 = false;
    }
}
