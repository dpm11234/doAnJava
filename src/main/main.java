//package main;
//
//import java.awt.*;
//import java.awt.event.ComponentAdapter;
//import java.awt.event.ComponentEvent;
//import javax.swing.*;
//
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.JFrame;
//
//// import Layouta
//import layout.Content;
//import layout.SlideBarMain;
//
//public class main extends JFrame {
//
//    public JFrame frame;
//    int currentTo, currentFrom;
//
//    private JTextField user;
//    private JPasswordField textPass;
//
//    public main() {
//        createAndShow();
//    }
//
//    public void createAndShow() {
//
//        frame = new JFrame("Vé Vi Vu");
//        ImageIcon icon = new ImageIcon("images/iconb.png");
//        frame.pack();
//        frame.setSize(1200, 600);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        frame.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                System.out.println(frame.getWidth());
//                System.out.println(frame.getHeight());
//            }
//        });
//
//        JPanel body = new JPanel(new BorderLayout());
//        SlideBarMain slideBarMain = new SlideBarMain();
//        Content content = new Content();
//
//        // Clear biến check khi click ra ngoài JPanel
//        body.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                slideBarMain.changeSelectC1();
//                slideBarMain.changeSelectC2();
//            }
//        });
//
//        body.add(slideBarMain, BorderLayout.WEST);
//        body.add(content, BorderLayout.CENTER);
//
//        frame.setVisible(true);
//        frame.add(body);
//    }
//
//    public Frame getFrame() {
//        return frame;
//    }
//
//    public static void main(String[] args) {
//        new main();
//    }
//}
