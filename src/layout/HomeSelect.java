package layout;

import bus.TuyenBUS;
import createUI.ImagePanel;
import createUI.ImageScroll;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import static layout.Main.widthGet;
import static layout.MenuDashboard.panelTicket;

// import Layout
import dto.TuyenDTO;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Date;

import static layout.Main.heightGet;
import layout.SelectTicketPanel;
import layout.Ticket;

/**
 *
 * @author my pc
 */
public class HomeSelect extends JPanel {

    private ImagePanel bgDashboard;
//    ImageScroll hi;
    static Ticket ticket2, ticket3, ticket4, ticket5, ticket6;
    static Ticket ticket;

    private ArrayList<TuyenDTO> danhSachTuyen;

    public HomeSelect(String startingPoint, String destination, LocalDateTime time) {
//        danhSachTuyen = new ArrayList<>();
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
        
        JLabel test = new JLabel("Menu quản trị");
        UIManager.put("ScrollBar.background", new Color(0, 0, 0, 0));
        UIManager.put("ScrollBar.darkShadow", new Color(0, 0, 0, 0));
        UIManager.put("ScrollBar.highlight", new Color(0, 0, 0, 0));
        UIManager.put("ScrollBar.shadow", new Color(0, 0, 0, 0));
        JPanel jp = new JPanel();
        JPanel ka = new JPanel();
        int height = 0;
        ka.setPreferredSize(new Dimension(790, height));
        ka.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        ka.setBorder(borderInputPass);
        ka.setBackground(new Color(119, 191, 251, 0));

        Font fontTextTitle = new Font("SansSerif", Font.PLAIN, 28);
        JPanel showTitle = new JPanel(new BorderLayout());
        showTitle.setPreferredSize(new Dimension(widthGet - 280, 50));

        JLabel message = new JLabel("Không có vé");
        message.setVerticalAlignment(JLabel.CENTER);
        showTitle.setBackground(new Color(0, 0, 0, 0));
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setPreferredSize(new Dimension(widthGet - 280, 50));
        message.setFont(fontTextTitle);
        message.setForeground(new Color(0, 0, 0, 184));
        showTitle.add(message, BorderLayout.CENTER);



        int countTuyen = 1;
        danhSachTuyen = TuyenBUS.getAllByTripClient(startingPoint, destination, time);
        if(danhSachTuyen.size() > 0) {
            for(TuyenDTO tuyen : danhSachTuyen) {
                ticket = new Ticket(tuyen);
                ticket.setPreferredSize(new Dimension(380, 118));
                if (countTuyen % 2 != 0) {
                    height += 133;
                }
                countTuyen++;
                ka.setPreferredSize(new Dimension(790, height));
                ka.add(ticket);
            }
        } else {
//            ka.setPreferredSize(new Dimension(790, 50));
////            ka.add(showTitle);

            Date date = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

            Timestamp timestampQ = Timestamp.valueOf(time);
            if(date.getTime() > timestampQ.getTime()) {
                message.setText("Ngày không hợp lệ");
            }
            bgDashboard.add(showTitle);
        }
        
        JViewport viewport = new JViewport();
        viewport.setView(ka);
        JScrollPane hi = new JScrollPane();
        hi.setViewport(viewport);
        hi.setPreferredSize(new Dimension(810, heightGet - 160));
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
                hi.setPreferredSize(new Dimension(810, heightGet - 160));
                bgDashboard.revalidate();
            }
        });
    }
}
