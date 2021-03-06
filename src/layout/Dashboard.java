package layout;

import bus.TuyenBUS;
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
import java.util.ArrayList;
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
import static layout.Content.areaPanel;
import static layout.MenuDashboard.panelTicket;

// import Layout
import dto.TuyenDTO;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import static layout.Main.heightGet;
import static layout.Main.widthGet;
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

    static TicketClient ticket;

    private JPanel ka;
    private JScrollPane hi;

    public Dashboard(ArrayList<TuyenDTO> danhSachTuyen) {
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
        

        selectTicketPanel = new SelectTicketPanel();
        JLabel test = new JLabel("Menu quản trị");
        UIManager.put("ScrollBar.background", new Color(0, 0, 0, 0));
        UIManager.put("ScrollBar.darkShadow", new Color(0, 0, 0, 0));
        UIManager.put("ScrollBar.highlight", new Color(0, 0, 0, 0));
        UIManager.put("ScrollBar.shadow", new Color(0, 0, 0, 0));
        JPanel jp = new JPanel();
        ka = new JPanel();

        ka.setPreferredSize(new Dimension(790, 0));
        ka.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        ka.setBorder(borderInputPass);
        ka.setBackground(new Color(119, 191, 251, 0));

        showTicket(danhSachTuyen);
        
        JViewport viewport = new JViewport();
        viewport.setView(ka);
        hi = new JScrollPane();
        hi.setViewport(viewport);
        hi.setPreferredSize(new Dimension(810, heightGet - 220));
        hi.setBorder(borderInputPass);
        hi.setOpaque(false);
        hi.getViewport().setOpaque(false);
        hi.getVerticalScrollBar().setUnitIncrement(5);

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
        
        bgDashboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                areaPanel.validate();
                areaPanel.repaint();
            }
        });
        
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                hi.setPreferredSize(new Dimension(810, heightGet - 220));
                bgDashboard.revalidate();
            }
        });
    }

    public void showTicket(ArrayList<TuyenDTO> danhSachTuyen) {

        JPanel showTitle = new JPanel();
//        showTitle.setSize(new Dimension(150, 50));
        JLabel message = new JLabel("Không có vé");

        showTitle.add(message);

        if(danhSachTuyen == null) {
            danhSachTuyen = TuyenBUS.getAll();
        }

        if(danhSachTuyen.size() > 0) {
            int height = 0;
            int countTuyen = 1;

            for(TuyenDTO tuyen : danhSachTuyen) {
                ticket = new TicketClient(tuyen);
                ticket.setPreferredSize(new Dimension(380, 118));

                if (countTuyen % 2 != 0) {
                    height += 133;
                }
                countTuyen++;
                ka.setPreferredSize(new Dimension(790, height));
                ka.add(ticket);
            }
        } else {
            ka.setPreferredSize(new Dimension(790, 50));
            ka.add(showTitle);
        }
    }

    public ImagePanel getBgDashboard() {
        return bgDashboard;
    }

    public JPanel getKa() {
        return this.ka;
    }

    public JScrollPane getHi() {
        return this.hi;
    }
}
