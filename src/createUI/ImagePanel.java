package createUI;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Duong Mau
 */
public class ImagePanel extends JPanel {

        private static final long serialVersionUID = 1L;

        private Image img;
        private Image scaled;
        private int x = 0;
        private int y = 0;

        public ImagePanel(Image img) {
            this.img = img;
            this.setBackground(new Color(255, 0, 0, 0));
        }

        public ImagePanel(Image img, int x, int y) {
            this.img = img;
            this.x = x;
            this.y = y;
        }

        @Override
        public void invalidate() {
            super.invalidate();
            int width = getWidth();
            int height = getHeight();

            if (width > 0 && height > 0) {
                scaled = img.getScaledInstance(getWidth(), getHeight(),
                        Image.SCALE_SMOOTH);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            if (x != 0 && y != 0) {
                return img == null ? new Dimension(200, 200) : new Dimension(x, y);
            } else {
                return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(this), img.getHeight(this));
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(scaled, 0, 0, null);
        }
    }
