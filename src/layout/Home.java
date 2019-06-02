package layout;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import createUI.ImagePanel;
/**
 *
 * @author my pc
 */
public class Home extends JPanel{
    private ImagePanel imgPanel;
    
    public Home() {
        this.setLayout(new BorderLayout());
        try {
            Image img = null;
            img = ImageIO.read(new File("images/background.png"));
            imgPanel = new ImagePanel(img);
            this.add(imgPanel);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }
    }
    
    public void remove() {
        this.remove(imgPanel);
        this.repaint();
    }
}
