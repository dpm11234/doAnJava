/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createUI;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author my pc
 */
public class TwoDots extends JLabel {
    public TwoDots() {
        this.setPreferredSize(new Dimension(48, 27));
        this.setIcon(new ImageIcon(new ImageIcon("images/two-dots.png").getImage().getScaledInstance(48, 16, Image.SCALE_DEFAULT)));
        this.setIconTextGap(0);
    }
}
