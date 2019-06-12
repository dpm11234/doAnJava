package layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import static layout.Content.areaPanel;
import static layout.Content.home;
import static layout.Content.login;
import static layout.Content.navbar;
import static layout.Navbar.*;
import static layout.SelectTicket.listTicket;
import static util.Session.isLogin;
import static layout.Content.*;

/**
 *
 * @author my pc
 */
public class NavBackSelect extends JPanel{
    final MatteBorder borderSignIn;
    static JButton btnBackLogin;
    static JLabel titleListTicket;
    public NavBackSelect() {
        borderSignIn = new MatteBorder(0, 0, 0, 0, new Color(227, 228, 231));
        borderSignIn.getBaseline(this, 1, 40);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(160, 60));
        this.setBackground(new Color(242, 243, 245));
        this.setBorder(borderSignIn);
        addControls();
    }
    
    public void addControls() {
        btnBackLogin = new JButton("Quay Về");
        
        btnBackLogin.setBackground(new Color(0, 115, 211));
        btnBackLogin.setForeground(Color.white);
        btnBackLogin.setRolloverEnabled(false);
        btnBackLogin.setBorderPainted(false);
        btnBackLogin.setFocusPainted(false);
        btnBackLogin.setIcon(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
        btnBackLogin.setIconTextGap(10);
        btnBackLogin.setPreferredSize(new Dimension(120, 30));
        
        this.add(btnBackLogin);

        Font fontTextTitle = new Font("SansSerif", Font.PLAIN, 18);

        titleListTicket = new JLabel("Danh Sách Vé");
        titleListTicket.setPreferredSize(new Dimension(100, 60));
        titleListTicket.setVerticalAlignment(JLabel.CENTER);
        titleListTicket.setHorizontalAlignment(JLabel.CENTER);
        titleListTicket.setFont(fontTextTitle);
        titleListTicket.setForeground(new Color(140, 140, 140));
        
        btnBackLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                areaPanel.remove(login);
//                areaPanel.remove(listTicket);
//                areaPanel.add(home, BorderLayout.CENTER);
//                navbar.remove(navBackHome);
//                navbar.add(navLogin, BorderLayout.EAST);
//                areaPanel.validate();
//                areaPanel.repaint();
//                navbar.validate();
//                navbar.repaint();


                areaPanel.removeAll();
                areaPanel.add(homeSelect);
                navbar.removeAll();
                navbar.add(navLogin, BorderLayout.EAST);
                navbar.add(titleListTicket, BorderLayout.CENTER);
                areaPanel.validate();
                areaPanel.repaint();
                navbar.validate();
                navbar.repaint();
            }
        });

    }
    
    public JButton getbtnLogin() {
        return btnBackLogin;
    }
}
