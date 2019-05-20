/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Panel.Main;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Duong Mau
 */
public class NavbarPanel extends JPanel {

    final MatteBorder borderNav;

    public NavbarPanel() {

        borderNav = new MatteBorder(0, 0, 1, 0, new Color(227, 228, 231));

        this.setLayout(new BorderLayout());
        this.setBorder(borderNav);
        this.setBackground(new Color(242, 243, 245));
        this.setPreferredSize(new Dimension(200, 60));
    }
}
