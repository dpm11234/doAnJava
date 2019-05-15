/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Panel.Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
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

/**
 *
 * @author Duong Mau
 */
public class BackgroudMain extends JPanel {
    public BackgroudMain() {
        this.setLayout(new BorderLayout());
        try {
            Image img = null;
            img = ImageIO.read(new File("images/background.png"));
            this.add(new ImagePanel(img));
            System.out.println(this.getWidth() - 1);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }
    }
    
    
    
    class ImagePanel extends JPanel {

        private static final long serialVersionUID = 1L;

        private Image img;
        private Image scaled;

        public ImagePanel(String img) {
            this(new ImageIcon(img).getImage());
        }

        public ImagePanel(Image img) {
            this.img = img;
        }

        @Override
        public void invalidate() {
            super.invalidate();
            int width = getWidth();
            int height = getHeight();

            if (width > 0 && height > 0) {
                scaled = img.getScaledInstance(getWidth(), getHeight(),
                        Image.SCALE_SMOOTH);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(
                    img.getWidth(this), img.getHeight(this));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(scaled, 0, 0, null);
        }
    }
}
