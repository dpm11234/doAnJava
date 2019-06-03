/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;

/**
 *
 * @author my pc
 */
public class Input extends JPanel {
    private JTextField input;
    public Input(String placeholder, String icon) {
        
        JPanel inputRadius = new JPanelInput(25);
        inputRadius.setLayout(new BorderLayout());
        inputRadius.setBackground(new Color(230, 230, 230));
        inputRadius.setPreferredSize(new Dimension(220, 40));
        
        MatteBorder borderNone = new MatteBorder(0, 0, 0, 0, new Color(0, 0, 0));
        Font fontB16 = new Font("SansSerif", Font.BOLD, 16);
        input = new JTextField(26);
        input.setBorder(borderNone);
        input.setText(placeholder);
        input.setForeground(new Color(180, 180, 180));
        input.setFont(fontB16);
        input.setPreferredSize(new Dimension(230, 40));
        input.setBackground(new Color(230, 230, 230));

        // Tạo placeholder cho JTextField
        // Đưa con trỏ về đầu JTextField khi Focus
        input.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                Object source = e.getSource();
                if (source instanceof JTextComponent) {
                    JTextComponent comp = (JTextComponent) source;
                    comp.setCaretPosition(0);
                }
            }
        });

        // Ẩn hiện placeholder
        input.addKeyListener(new KeyAdapter() {
            int countKey = 0;
            boolean checkKey = false;

            @Override
            public void keyPressed(KeyEvent e) {
                if ("".equals(input.getText())) {

                } else {
                    if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                        System.out.println(e.getKeyCode());
                        checkKey = true;
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if ("".equals(input.getText())) {
                    input.setText(placeholder);
                    input.setForeground(new Color(192, 192, 192));
                    Object source = e.getSource();
                    if (source instanceof JTextComponent) {
                        JTextComponent comp = (JTextComponent) source;
                        comp.setCaretPosition(0);
                    }
                    countKey = 0;
                    checkKey = false;
                } else {
                    if (!checkKey) {
                        if (countKey == 0) {
                            input.setText("");
                            input.setForeground(new Color(104, 104, 104));
                            countKey = 1;
                        }
                    } else {
                        checkKey = false;
                    }
                }
            }
        });

        // Block (khóa) con trỏ khi hiện placeholder
        input.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (placeholder.equals(input.getText())) {
                    Object source = e.getSource();
                    if (source instanceof JTextComponent) {
                        JTextComponent comp = (JTextComponent) source;
                        comp.setCaretPosition(0);
                    }
                }
            }
        });
        // End placeholder

        // Tạo icon cho JTextField
//        JPanel inputPrice = new JPanelInput(25);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(255, 255, 255));
        this.setPreferredSize(new Dimension(220, 40));
        JLabel imagePrice = new JLabel();
        imagePrice.setPreferredSize(new Dimension(32, 40));
        imagePrice.setIcon(new ImageIcon(new ImageIcon("images/"+icon+".png").getImage().getScaledInstance(22, 15, Image.SCALE_DEFAULT)));
        inputRadius.add(imagePrice, BorderLayout.WEST);
        inputRadius.add(input, BorderLayout.CENTER);
        
        this.add(inputRadius);
    }
    public String getText(){
        return input.getText();
    }
    
    public void setText(String text) {
        input.setText(text);
    }
}
