package layout;

import createUI.ImagePanel;
import createUI.ImageScroll;
import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ColorUIResource;
import static layout.MenuDashboard.panelTicket;

// import Layout
import layout.SelectTicketPanel;
import layout.Ticket;

/**
 *
 * @author my pc
 */
public class Dashboard extends JPanel {

    private ImagePanel bgDashboard;
//    ImageScroll hi;
    static SelectTicketPanel selectTicketPanel;
    static Ticket ticket, ticket2, ticket3, ticket4, ticket5, ticket6;

    public Dashboard() {

        MatteBorder borderInputPass = new MatteBorder(0, 0, 0, 0, new Color(0, 0, 0));
        this.setLayout(new BorderLayout());
        try {
            Image img = null;
            img = ImageIO.read(new File("images/bg/admin-panel2.png"));
            bgDashboard = new ImagePanel(img);
            //this.add(new ImagePanel(img));
            this.add(bgDashboard);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }

        ticket = new Ticket();
        ticket2 = new Ticket();
        ticket3 = new Ticket();
        ticket4 = new Ticket();
        ticket5 = new Ticket();
        ticket6 = new Ticket();
        ticket.setPreferredSize(new Dimension(380, 118));
        ticket2.setPreferredSize(new Dimension(380, 118));
        ticket3.setPreferredSize(new Dimension(380, 118));
        ticket4.setPreferredSize(new Dimension(380, 118));
        ticket5.setPreferredSize(new Dimension(380, 118));
        ticket6.setPreferredSize(new Dimension(380, 118));
        selectTicketPanel = new SelectTicketPanel();
        JLabel test = new JLabel("Menu quản trị");
        UIManager.put("ScrollBar.background", new Color(0, 0, 0, 0));
        UIManager.put("ScrollBar.darkShadow", new Color(0, 0, 0, 0));
        UIManager.put("ScrollBar.highlight", new Color(0, 0, 0, 0));
        UIManager.put("ScrollBar.shadow", new Color(0, 0, 0, 0));
//        UIManager.put("ScrollBar.thumbHighlight", new Color(0, 0, 0, 0));
//        UIManager.put("ScrollBar.thumbShadow", new Color(0, 0, 0, 0));
//        UIManager.put("ScrollBar.width", 16);
        UIManager.put("control", new Color(0, 0, 0, 0));
        JPanel jp = new JPanel();
        JPanel ka = new JPanel();
        ka.setPreferredSize(new Dimension(790, 399));
        ka.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        ka.setBorder(borderInputPass);
        ka.setBackground(new Color(119, 191, 251, 0));
        ka.add(ticket);
        ka.add(ticket2);
        ka.add(ticket3);
        ka.add(ticket4);
        ka.add(ticket5);
        ka.add(ticket6);

//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 20; j++) {
//                ka.add(new JButton("Button " + j));
//            }
//        }
        JViewport viewport = new JViewport();
        viewport.setView(ka);
        JScrollPane hi = new JScrollPane();
        hi.setViewport(viewport);
        hi.setPreferredSize(new Dimension(810, 500));
        hi.setBorder(borderInputPass);
        hi.setOpaque(false);
        hi.getViewport().setOpaque(false);

        hi.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(final AdjustmentEvent e) {
                hi.repaint();
            }
        });
        hi.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(final AdjustmentEvent e) {
                hi.repaint();
            }
        });
        
        JLabel spaceScorll = new JLabel();
        spaceScorll.setPreferredSize(new Dimension(810, 10));
        bgDashboard.add(selectTicketPanel);
        bgDashboard.add(spaceScorll);

        bgDashboard.add(hi);
    }
}
