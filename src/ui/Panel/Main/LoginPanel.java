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
public class LoginPanel extends JPanel {

    final MatteBorder borderSignIn;
    private JButton btnLogin;
    public LoginPanel() {
        borderSignIn = new MatteBorder(0, 0, 0, 0, new Color(227, 228, 231));
        borderSignIn.getBaseline(this, 1, 40);
        
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(160, 60));
        this.setBackground(new Color(242, 243, 245));
        this.setBorder(borderSignIn);
        addControls();
    }
    
    public void addControls() {
        btnLogin = new JButton("Đăng nhập");
        
        btnLogin.setBackground(new Color(0, 115, 211));
        btnLogin.setForeground(Color.white);
        btnLogin.setRolloverEnabled(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setIcon(new ImageIcon(new ImageIcon("images/login2.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
        btnLogin.setIconTextGap(10);
        btnLogin.setPreferredSize(new Dimension(120, 30));
        
        this.add(btnLogin);
    }
    
    public JButton getbtnLogin() {
        return btnLogin;
    }
    
//    public void handleEvent() {
//        btnLogin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                frame.dispose();
//                new LoginFrame();
//            }
//        });
///    }
}
