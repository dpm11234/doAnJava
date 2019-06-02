package createUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author my pc
 */
public class JPanelInput extends JPanel {

        int r;

        public JPanelInput(int r) {
            this.r = r;
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (!isOpaque() && getBorder() instanceof RoundedBorder) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setPaint(getBackground());
                g2.fill(((RoundedBorder) getBorder()).getBorderShape(
                        0, 0, getWidth() - 1, getHeight() - 1, this.r));
                g2.dispose();
                setBorder(new RoundedBorder(this.r));
            }
            super.paintComponent(g);
        }

        @Override
        public void updateUI() {
            super.updateUI();
            setOpaque(false);
            setBorder(new RoundedBorder(this.r));
        }
    }
