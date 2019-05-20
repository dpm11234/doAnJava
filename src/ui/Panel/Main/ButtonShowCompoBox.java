/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Panel.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Duong Mau
 */
public class ButtonShowCompoBox extends JButton {
    public ButtonShowCompoBox(String toolTipText) {
        
        MatteBorder borderPicker = new MatteBorder(0, 0, 0, 0, new Color(26, 126, 218));
        
        this.setToolTipText(toolTipText);
        this.setIcon(new ImageIcon(new ImageIcon("images/down-arrow.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
        this.setPreferredSize(new Dimension(45, 15));
        this.setBackground(new Color(26, 126, 218));
        this.setBorder(borderPicker);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
    }
}
