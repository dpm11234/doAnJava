/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author my pc
 */
public class ButtonImage extends JPanel{
    private JButton buttonLogin;
    public ButtonImage(String text, String image, int width) {
        JPanel buttonLoginPanel = new JPanel(new GridBagLayout());
        try {
            Image imgButtonLogin = null;
            imgButtonLogin = ImageIO.read(new File("images/bg/"+image+".png"));
            buttonLoginPanel = new ImagePanel(imgButtonLogin, width, 40);
            buttonLoginPanel.setPreferredSize(new Dimension(width, 40));
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }

        buttonLogin = new JButton(text);
        buttonLogin.setPreferredSize(new Dimension(width, 30));
        buttonLogin.setBackground(new Color(0, 0, 0, 0));
        buttonLogin.setForeground(Color.white);
        buttonLogin.setRolloverEnabled(false);
        buttonLogin.setBorderPainted(false);
        buttonLogin.setFocusPainted(false);
        buttonLogin.setContentAreaFilled(false);
        buttonLoginPanel.add(buttonLogin);
        buttonLoginPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(255, 255, 255));
        this.setPreferredSize(new Dimension(width, 40));
        
        this.add(buttonLoginPanel);
    }

    public JButton getButton() {
        return buttonLogin;
    }
}
