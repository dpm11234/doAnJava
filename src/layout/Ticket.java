/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import createUI.ImagePanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import static layout.Dashboard.selectTicketPanel;

/**
 *
 * @author my pc
 */
public class Ticket extends JPanel {
    private ImagePanel bgTicket;
    
    public Ticket() {
        this.setLayout(new BorderLayout());
        try {
            Image img = null;
            img = ImageIO.read(new File("images/bg/ticket2.png"));
            bgTicket = new ImagePanel(img);
            this.add(bgTicket);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }
        
        MatteBorder borderTest = new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0));
        Font fontPrice = new Font("SansSerif", Font.PLAIN, 12);
        
        
        JPanel leftTop = new JPanel(new BorderLayout());
        leftTop.setBorder(borderTest);
        leftTop.setPreferredSize(new Dimension(258, 27));
        leftTop.setBackground(new Color(0, 0, 0, 0));
        
        JLabel price = new JLabel("Giá vé: 120.000đ");
        price.setFont(fontPrice);
        price.setPreferredSize(new Dimension(130, 27));
        price.setIcon(new ImageIcon(new ImageIcon("images/logo.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
        price.setIconTextGap(10);
        price.setForeground(Color.white);
        price.setBorder(borderTest);
        
        JLabel priceSpace = new JLabel("");
        priceSpace.setPreferredSize(new Dimension(20, 27));
        
        JPanel priceJPanel = new JPanel(new BorderLayout());
        priceJPanel.setBackground(new Color(0, 0, 0, 0));
        priceJPanel.add(priceSpace, BorderLayout.WEST);
        priceJPanel.add(price, BorderLayout.CENTER);
        
        
        leftTop.add(priceJPanel, BorderLayout.WEST);
        
        
        bgTicket.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JPanel left = new JPanel();
        left.setBackground(new Color(68, 175, 47, 0));
        left.setPreferredSize(new Dimension(258, 118));
        left.setLayout(new BorderLayout());
        
        left.add(leftTop, BorderLayout.NORTH);
        
        JPanel right = new JPanel();
        right.setBackground(new Color(178, 122, 39, 0));
        right.setPreferredSize(new Dimension(122, 118));
        bgTicket.add(left);
        bgTicket.add(right);
    }
}
