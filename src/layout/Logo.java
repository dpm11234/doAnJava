package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 *
 * @author my pc
 */
public class Logo extends JPanel {
    public Logo(){
        MatteBorder border = new MatteBorder(0, 0, 1, 0, new Color(35, 126, 212));
        this.setPreferredSize(new Dimension(270, 60));
        this.setBorder(border);
        this.setBackground(new Color(0, 115, 211));
        
        JLabel textLogo = new JLabel("<html><font style='font-size: 16px; font-family: \"Trebuchet MS\", Helvetica, sans-serif' color='white'> VÉ VI VU</font></html>", SwingConstants.CENTER);
        textLogo.setPreferredSize(new Dimension(220, 50));
        textLogo.setIcon(new ImageIcon(new ImageIcon("images/logo.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        textLogo.setIconTextGap(10);
        textLogo.setPreferredSize(new Dimension(220, 50));
        textLogo.setVerticalAlignment(JLabel.CENTER);
        
        this.add(textLogo);
    }
}
