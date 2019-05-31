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
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author my pc
 */
public class BookedTicket extends JPanel {

    private ImagePanel bgBooked;

    public BookedTicket() {
        this.setLayout(new BorderLayout());
        try {
            Image img = null;
            img = ImageIO.read(new File("images/bg/admin-panel2.png"));
            bgBooked = new ImagePanel(img);
            //this.add(new ImagePanel(img));
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }

        MatteBorder borderBlack = new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0));
        MatteBorder borderWhile = new MatteBorder(1, 1, 1, 1, new Color(255, 255, 255));

        JPanel boxListBooked = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        boxListBooked.setPreferredSize(new Dimension(800, 400));
        boxListBooked.setBackground(new Color(255, 255, 255, 0));
//        boxListBooked.setBorder(borderWhile);

        JLabel spaceTop = new JLabel();
        spaceTop.setPreferredSize(new Dimension(800, 30));
        spaceTop.setBackground(new Color(95, 152, 244, 0));

        JPanel infoTicket = new JPanel(new BorderLayout());
        infoTicket.setPreferredSize(new Dimension(800, 40));
        infoTicket.setBackground(new Color(76, 173, 255));
        infoTicket.setBorder(borderWhile);

        JPanel infoTicketLeft = new JPanel(new BorderLayout());
        infoTicketLeft.setPreferredSize(new Dimension(208, 40));
        infoTicketLeft.setBackground(new Color(76, 173, 255));

        JLabel from = new JLabel("Bình Dương");
        from.setPreferredSize(new Dimension(80, 40));
        from.setHorizontalAlignment(JLabel.CENTER);
        from.setForeground(Color.white);
        from.setHorizontalAlignment(JLabel.RIGHT);
        from.setVerticalAlignment(JLabel.CENTER);

        JLabel arrow = new JLabel();
        arrow.setPreferredSize(new Dimension(48, 27));
        arrow.setIcon(new ImageIcon(new ImageIcon("images/right-arrow-space-w.png").getImage().getScaledInstance(48, 16, Image.SCALE_DEFAULT)));
        arrow.setIconTextGap(0);

        JLabel to = new JLabel("Đồng Nai");
        to.setPreferredSize(new Dimension(80, 40));
        to.setForeground(Color.white);
        to.setHorizontalAlignment(JLabel.LEFT);
        to.setVerticalAlignment(JLabel.CENTER);

        infoTicketLeft.add(from, BorderLayout.WEST);
        infoTicketLeft.add(arrow, BorderLayout.CENTER);
        infoTicketLeft.add(to, BorderLayout.EAST);

        JPanel infoTicketRight = new JPanel(new BorderLayout());
        infoTicketRight.setPreferredSize(new Dimension(170, 40));
        infoTicketRight.setBackground(new Color(76, 173, 255));

        JLabel time = new JLabel("12:30");
        time.setPreferredSize(new Dimension(60, 40));
        time.setHorizontalAlignment(JLabel.CENTER);
        time.setForeground(Color.white);
        time.setHorizontalAlignment(JLabel.CENTER);
        time.setVerticalAlignment(JLabel.CENTER);

        JLabel day = new JLabel("Ngày 29-05-2019");
        day.setPreferredSize(new Dimension(110, 40));
        day.setHorizontalAlignment(JLabel.CENTER);
        day.setForeground(Color.white);
        day.setHorizontalAlignment(JLabel.LEFT);
        day.setVerticalAlignment(JLabel.CENTER);

        infoTicketRight.add(time, BorderLayout.WEST);
        infoTicketRight.add(day, BorderLayout.EAST);

        infoTicket.add(infoTicketLeft, BorderLayout.WEST);
        infoTicket.add(infoTicketRight, BorderLayout.EAST);

        JPanel titleTable = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        titleTable.setPreferredSize(new Dimension(800, 38));
        titleTable.setBackground(new Color(255, 255, 255));

        JLabel name = new JLabel("Tên");
        name.setPreferredSize(new Dimension(230, 38));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setForeground(new Color(117, 120, 122));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);

        Line line1 = new Line();

        JLabel phone = new JLabel("Số điện thoại");
        phone.setPreferredSize(new Dimension(180, 38));
        phone.setHorizontalAlignment(JLabel.CENTER);
        phone.setForeground(new Color(117, 120, 122));
        phone.setHorizontalAlignment(JLabel.CENTER);
        phone.setVerticalAlignment(JLabel.CENTER);

        Line line2 = new Line();

        JLabel totalTicket = new JLabel("Số vé đặt");
        totalTicket.setPreferredSize(new Dimension(130, 38));
        totalTicket.setHorizontalAlignment(JLabel.CENTER);
        totalTicket.setForeground(new Color(117, 120, 122));
        totalTicket.setHorizontalAlignment(JLabel.CENTER);
        totalTicket.setVerticalAlignment(JLabel.CENTER);

        Line line3 = new Line();

        JLabel timeBooked = new JLabel("Thời gian đặt");
        timeBooked.setPreferredSize(new Dimension(176, 38));
        timeBooked.setHorizontalAlignment(JLabel.CENTER);
        timeBooked.setForeground(new Color(117, 120, 122));
        timeBooked.setHorizontalAlignment(JLabel.CENTER);
        timeBooked.setVerticalAlignment(JLabel.CENTER);

        Line line4 = new Line();

        JLabel delete = new JLabel("Hủy");
        delete.setPreferredSize(new Dimension(80, 38));
        delete.setHorizontalAlignment(JLabel.CENTER);
        delete.setForeground(new Color(117, 120, 122));
        delete.setHorizontalAlignment(JLabel.CENTER);
        delete.setVerticalAlignment(JLabel.CENTER);

        titleTable.add(name);
        titleTable.add(line1);
        titleTable.add(phone);
        titleTable.add(line2);
        titleTable.add(totalTicket);
        titleTable.add(line3);
        titleTable.add(timeBooked);
        titleTable.add(line4);
        titleTable.add(delete);

//        ListBookedB list1 = new ListBookedB();
//        ListBookedW list2 = new ListBookedW();
        boxListBooked.add(spaceTop);
        boxListBooked.add(infoTicket);
        boxListBooked.add(titleTable);

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                boxListBooked.add(new ListBookedB());
            } else {
                boxListBooked.add(new ListBookedW());
            }
        }

//        boxListBooked.add(list1);
//        boxListBooked.add(list2);
        bgBooked.add(boxListBooked);

        this.add(bgBooked);
    }

    public class Line extends JLabel {

        public Line() {
            this.setPreferredSize(new Dimension(1, 20));
            this.setHorizontalAlignment(JLabel.CENTER);
            MatteBorder borderBlack = new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0));
            this.setBorder(borderBlack);
        }
    }

    public class ListBookedB extends JPanel {

        public ListBookedB() {
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            this.setPreferredSize(new Dimension(800, 40));
            this.setBackground(new Color(239, 241, 242));
        }
    }

    public class ListBookedW extends JPanel {

        public ListBookedW() {
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            this.setPreferredSize(new Dimension(800, 40));
            this.setBackground(new Color(255, 255, 255));
            MatteBorder borderLR = new MatteBorder(0, 1, 0, 1, new Color(239, 241, 242));
            this.setBorder(borderLR);
        }
    }
}
