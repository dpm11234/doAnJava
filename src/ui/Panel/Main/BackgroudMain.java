/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Panel.Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.*;
import ui.MainFrame;
import ui.Panel.Main.ImagePanel;
/**
 *
 * @author Duong Mau
 */
public class BackgroudMain extends JPanel {
    
    private ImagePanel imgPanel;
    
    public BackgroudMain() {
        this.setLayout(new BorderLayout());
        try {
            Image img = null;
            img = ImageIO.read(new File("images/background.png"));
            imgPanel = new ImagePanel(img);
            //this.add(new ImagePanel(img));
            this.add(imgPanel);
            System.out.println(this.getWidth() - 1);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }
    }
    
    public void remove() {
        this.remove(imgPanel);
        this.repaint();
    }
}
 