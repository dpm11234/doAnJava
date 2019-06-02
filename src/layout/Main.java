/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

// import Layout
import layout.Content;
import layout.SlideBarMain;

public class Main extends JFrame {

    static JFrame frame;
    int currentTo, currentFrom;
    static int widthGet, heightGet;

    private JTextField user;
    private JPasswordField textPass;

    public Main() {
        createAndShow();
    }

    public void createAndShow() {

        frame = new JFrame("Vé Vi Vu");
        ImageIcon icon = new ImageIcon("images/iconb.png");
        frame.setIconImage(icon.getImage());
        frame.pack();
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        widthGet = frame.getWidth();
        heightGet = frame.getHeight();
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                widthGet = frame.getWidth();
                heightGet = frame.getHeight();
            }
        });

        JPanel body = new JPanel(new BorderLayout());
        SlideBarMain slideBarMain = new SlideBarMain();
        Content content = new Content();

        // Clear biến check khi click ra ngoài JPanel
        body.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                slideBarMain.changeSelectC1();
                slideBarMain.changeSelectC2();
            }
        });

        body.add(slideBarMain, BorderLayout.WEST);
        body.add(content, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.add(body);
    }

    public Frame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        new Main();
    }
}
