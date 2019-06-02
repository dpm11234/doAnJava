/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import createUI.JPanelInput;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import static layout.Content.areaPanel;

/**
 *
 * @author my pc
 */
public class SelectWhite extends JPanel {
    JComboBox compoBox;
    boolean checkClick;
    public SelectWhite(String list[], String lable, int widthLable) {
        
        MatteBorder borderSelect = new MatteBorder(0, 0, 1, 0, new Color(48, 148, 238));
        MatteBorder borderPicker = new MatteBorder(0, 0, 0, 0, new Color(26, 126, 218));
        MatteBorder borderNone = new MatteBorder(0, 0, 0, 0, new Color(0, 0, 0));
        Font fontB16 = new Font("SansSerif", Font.BOLD, 16);
        
        JPanel select = new JPanelInput(25);
        select.setLayout(new BorderLayout());
        select.setBackground(new Color(230, 230, 230, 0));
        select.setPreferredSize(new Dimension(220, 40));
        
        compoBox = new JComboBox(list);
        compoBox.setPreferredSize(new Dimension(90, 50));
        compoBox.setEditable(true);
        compoBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkClick = false;
            }
        });
        
        checkClick = false;
        final JButton showCompoBoxFrom = new JButton();
//        showCompoBoxFrom.setToolTipText("Chọn Điểm Khởi Hành");
        showCompoBoxFrom.setIcon(new ImageIcon(new ImageIcon("images/arrow-down-add.png").getImage().getScaledInstance(13, 13, Image.SCALE_DEFAULT)));
        showCompoBoxFrom.setPreferredSize(new Dimension(45, 15));
        showCompoBoxFrom.setBackground(new Color(230, 230, 230));
        showCompoBoxFrom.setBorder(borderPicker);
        showCompoBoxFrom.setBorderPainted(false);
        showCompoBoxFrom.setFocusPainted(false);
        showCompoBoxFrom.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showCompoBoxFrom.setRolloverEnabled(false);
        showCompoBoxFrom.setContentAreaFilled(false);
        
        showCompoBoxFrom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //then you know that is attached to this button
                areaPanel.validate();
                areaPanel.repaint();
                if (!checkClick) {
                    compoBox.setPopupVisible(true);
                }
                checkClick = !checkClick;
            }
        });
        Component[] componentCompoBoxFrom = compoBox.getComponents();
        removeArrowCompoBox(componentCompoBoxFrom);
        
        compoBox.getEditor().getEditorComponent().setBackground(new Color(255, 255, 255));
        compoBox.setBackground(new Color(255, 255, 255));
        compoBox.setBorder(borderNone);
        compoBox.setFocusable(false);
        for (int i = 0; i < compoBox.getComponentCount(); i++) {
            if (compoBox.getComponent(i) instanceof JComponent) {
                ((JComponent) compoBox.getComponent(i)).setBorder(new EmptyBorder(0, 0, 0, 0));
            }

            if (compoBox.getComponent(i) instanceof AbstractButton) {
                ((AbstractButton) compoBox.getComponent(i)).setBorderPainted(false);
                ((AbstractButton) compoBox.getComponent(i)).setMaximumSize(new Dimension(0, 0));
            }
        }
        compoBox.getEditor().getEditorComponent().setForeground(new Color(180, 180, 180));
        compoBox.setFont(fontB16);
        
        JLabel textSelectFrom = new JLabel("<html><font color='#5898DD'>"+lable+"</font></html>");
        textSelectFrom.setPreferredSize(new Dimension(widthLable, 50));
        textSelectFrom.setHorizontalAlignment(JLabel.CENTER);
        
        select.add(textSelectFrom, BorderLayout.WEST);
        select.add(compoBox, BorderLayout.CENTER);
        select.add(showCompoBoxFrom, BorderLayout.EAST);
        
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(255, 255, 255));
        this.setPreferredSize(new Dimension(250, 40));
        
        this.add(select);
    }
    
    public void removeArrowCompoBox(Component[] component) {
        for (int i = 0; i < component.length; i++) {
            if (component[i] instanceof JButton) {
                JButton button = (JButton) component[i];
                button.setPreferredSize(new Dimension(0, 0));
                button.setVisible(false);
            }
        }
    }
    
    public JComboBox get() {
        return compoBox;
    }
}
