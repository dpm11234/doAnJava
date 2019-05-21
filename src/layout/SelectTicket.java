package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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


// import UI

import createUI.DatePicker;
import layout.ListTicket;
import static layout.Content.home;
import static layout.Content.login;
import static layout.Content.areaPanel;
/**
 *
 * @author my pc
 */
public class SelectTicket extends JPanel {
    String list[] = {"TP.HCM", "Đồng Nai", "Bình Dương", "Vũng Tàu", "Long An", "Tay Ninh"};
    String list2[] = {"Đồng Nai", "TP.HCM", "Bình Dương", "Vũng Tàu", "Long An", "Tay Ninh"};
    static boolean checkClickJCompoBox1, checkClickJCompoBox2;
    static JComboBox c1, c2;
    int currentTo, currentFrom;
    static ListTicket listTicket;
    
    public SelectTicket() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(9, 114, 201));
        this.setPreferredSize(new Dimension(200, 240));
        
        JPanel areaSelect = new JPanel(new GridLayout(0, 1));
        
        MatteBorder borderSelect = new MatteBorder(0, 0, 1, 0, new Color(48, 148, 238));
        
        JPanel selectFrom = new JPanel(new BorderLayout());
        selectFrom.setBackground(new Color(26, 126, 218));
        selectFrom.setBorder(borderSelect);
        
        JPanel selectTo = new JPanel(new BorderLayout());
        selectTo.setBackground(new Color(26, 126, 218));
        selectTo.setBorder(borderSelect);
        
        JLabel textSelect = new JLabel("<html><font color='#5898DD'>Từ</font></html>");
        textSelect.setPreferredSize(new Dimension(50, 50));
        textSelect.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel textSelectTo = new JLabel("<html><font color='#5898DD'>Đến</font></html>");
        textSelectTo.setPreferredSize(new Dimension(50, 50));
        textSelectTo.setHorizontalAlignment(JLabel.CENTER);
        
        MatteBorder borderPicker = new MatteBorder(0, 0, 0, 0, new Color(26, 126, 218));
        MatteBorder comboBox = new MatteBorder(0, 0, 0, 0, new Color(26, 126, 218));
        Font fontJCompoBox = new Font("SansSerif", Font.BOLD, 16);
        // Tạo CompoBox 1
        c1 = new JComboBox(list);
        c1.setPreferredSize(new Dimension(90, 50));
        c1.setEditable(true);
        c1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkClickJCompoBox1 = false;
            }
        });
        
        checkClickJCompoBox1 = false;
        final JButton showCompoBox1 = new JButton();
        showCompoBox1.setToolTipText("Chọn Điểm Khởi Hành");
        showCompoBox1.setIcon(new ImageIcon(new ImageIcon("images/down-arrow.png").getImage().getScaledInstance(13, 13, Image.SCALE_DEFAULT)));
        showCompoBox1.setPreferredSize(new Dimension(45, 15));
        showCompoBox1.setBackground(new Color(26, 126, 218));
        showCompoBox1.setBorder(borderPicker);
        showCompoBox1.setBorderPainted(false);
        showCompoBox1.setFocusPainted(false);
        
        showCompoBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //then you know that is attached to this button
                if (!checkClickJCompoBox1) {
                    c1.setPopupVisible(true);
                }
                checkClickJCompoBox1 = !checkClickJCompoBox1;
            }
        });
        Component[] componentCompoBox1 = c1.getComponents();
        removeArrowCompoBox(componentCompoBox1);
        
        c1.getEditor().getEditorComponent().setBackground(new Color(26, 126, 218));
        c1.setBackground(new Color(26, 126, 218));
        c1.setBorder(comboBox);
        c1.setFocusable(false);
        for (int i = 0; i < c1.getComponentCount(); i++) {
            if (c1.getComponent(i) instanceof JComponent) {
                ((JComponent) c1.getComponent(i)).setBorder(new EmptyBorder(0, 0, 0, 0));
            }

            if (c1.getComponent(i) instanceof AbstractButton) {
                ((AbstractButton) c1.getComponent(i)).setBorderPainted(false);
                ((AbstractButton) c1.getComponent(i)).setMaximumSize(new Dimension(0, 0));
            }
        }
        c1.getEditor().getEditorComponent().setForeground(new Color(255, 255, 255));
        c1.setFont(fontJCompoBox);
        
        
        // Tạo CompoBox 2
        c2 = new JComboBox(list2);
        c2.setPreferredSize(new Dimension(90, 50));
        c2.setEditable(true);
        c2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkClickJCompoBox2 = false;
            }
        });
        
        checkClickJCompoBox2 = false;
        final JButton showCompoBox2 = new JButton();
        showCompoBox2.setToolTipText("Chọn Điểm Đến");
        showCompoBox2.setIcon(new ImageIcon(new ImageIcon("images/down-arrow.png").getImage().getScaledInstance(13, 13, Image.SCALE_DEFAULT)));
        showCompoBox2.setPreferredSize(new Dimension(45, 15));
        showCompoBox2.setBackground(new Color(26, 126, 218));
        showCompoBox2.setBorder(borderPicker);
        showCompoBox2.setBorderPainted(false);
        showCompoBox2.setFocusPainted(false);
        
        showCompoBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //then you know that is attached to this button
                if (!checkClickJCompoBox2) {
                    c2.setPopupVisible(true);
                }
                checkClickJCompoBox2 = !checkClickJCompoBox2;
            }
        });
        Component[] componentCompoBox2 = c2.getComponents();
        removeArrowCompoBox(componentCompoBox2);
        
        c2.getEditor().getEditorComponent().setBackground(new Color(26, 126, 218));
        c2.setBackground(new Color(26, 126, 218));
        c2.setBorder(comboBox);
        c2.setFocusable(false);
        for (int i = 0; i < c2.getComponentCount(); i++) {
            if (c2.getComponent(i) instanceof JComponent) {
                ((JComponent) c2.getComponent(i)).setBorder(new EmptyBorder(0, 0, 0, 0));
            }

            if (c2.getComponent(i) instanceof AbstractButton) {
                ((AbstractButton) c2.getComponent(i)).setBorderPainted(false);
                ((AbstractButton) c2.getComponent(i)).setMaximumSize(new Dimension(0, 0));
            }
        }
        c2.getEditor().getEditorComponent().setForeground(new Color(255, 255, 255));
        c2.setFont(fontJCompoBox);
        
        DatePicker datePicker = new DatePicker();
        
        // add các thành phần
        
        selectFrom.add(textSelect, BorderLayout.WEST);
        selectFrom.add(c1, BorderLayout.CENTER);
        selectFrom.add(showCompoBox1, BorderLayout.EAST);
        
        selectTo.add(textSelectTo, BorderLayout.WEST);
        selectTo.add(c2, BorderLayout.CENTER);
        selectTo.add(showCompoBox2, BorderLayout.EAST);
        
        areaSelect.add(selectFrom);
        areaSelect.add(selectTo);
        areaSelect.add(datePicker);
        
        this.add(areaSelect, BorderLayout.NORTH);
        
        
        currentFrom = c1.getSelectedIndex();
        currentTo = c2.getSelectedIndex();
        
        listTicket = new ListTicket();
        
        c1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = c1.getSelectedIndex();
                if(selected != currentFrom) {
                    areaPanel.remove(home);
                    areaPanel.remove(login);
                    areaPanel.add(listTicket);
                    areaPanel.validate();
                    areaPanel.repaint();
                    currentFrom = selected;
                }
            }
            
        });
        
        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = c2.getSelectedIndex();
                if(selected != currentFrom) {
                    areaPanel.remove(home);
                    areaPanel.remove(login);
                    areaPanel.add(listTicket);
                    areaPanel.validate();
                    areaPanel.repaint();
                    currentTo = selected;
                }
            }
        });
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
}
