/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author my pc
 */
public class Info extends JPanel {
    public Info() {
        this.setBackground(new Color(255, 255, 255));
        this.setPreferredSize(new Dimension(270, 40));
        
        JLabel textInfo = new JLabel("© Phát triển bởi Gocodee!");
        Font fontTextInfo = new Font("SansSerif", Font.BOLD, 14);
        textInfo.setFont(fontTextInfo);
        textInfo.setForeground(new Color(9, 114, 201));
        textInfo.setPreferredSize(new Dimension(270, 30));
        textInfo.setVerticalAlignment(JLabel.CENTER);
        textInfo.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(textInfo);
    }
}
