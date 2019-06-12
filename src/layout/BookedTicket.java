/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import bus.KhachHangBUS;
import createUI.ImagePanel;
import dao.KhachHangDAO;
import dto.KhachHangDTO;
import dto.TuyenDTO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import static layout.Content.areaPanel;
import static layout.Main.heightGet;
import static layout.Main.widthGet;
import static layout.Content.*;
import static layout.MenuDashboard.createTicket;

/**
 *
 * @author my pc
 */
public class BookedTicket extends JPanel {

    private ImagePanel bgBooked;
    public int height;
    private ArrayList<KhachHangDTO> danhSachKhachHang;
    private TuyenDTO tuyen;
    static JPanel spaceTop;
    int rePP = 0;

    public BookedTicket(TuyenDTO tuyen) {

        this.danhSachKhachHang = KhachHangBUS.getAll(tuyen.getMaNX(), tuyen.getMaTuyen());
        this.tuyen = tuyen;

        int widthArea = widthGet - 130 - 270;
        int width;
        if (height > heightGet - 251) {
            width = widthArea - 17;
        } else {
            width = widthArea;
        }
        int widthOutLine = width - 5;

        float checkW2 = (float) widthOutLine / 100 * 10;
        float nameW2 = (float) widthOutLine / 100 * 26;
        float phoneW2 = (float) widthOutLine / 100 * 19;
        float totalW2 = (float) widthOutLine / 100 * 13;
        float timeW2 = (float) widthOutLine / 100 * 21;

        int checkW = Math.round(checkW2) + 1;
        int nameW = Math.round(nameW2);
        int phoneW = Math.round(phoneW2);
        int totalW = Math.round(totalW2);
        int timeW = Math.round(timeW2);
        int deleteW = widthOutLine - (checkW + nameW + phoneW + totalW + timeW);

        this.setLayout(new BorderLayout());
        try {
            Image img = null;
            img = ImageIO.read(new File("images/bg/admin-panel2.png"));
            bgBooked = new ImagePanel(img);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }

        MatteBorder borderBlack = new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0));
        MatteBorder borderWhile = new MatteBorder(1, 1, 1, 1, new Color(255, 255, 255));
        MatteBorder borderBox = new MatteBorder(0, 0, 1, 0, new Color(219, 220, 221));

        JPanel boxListBooked = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        boxListBooked.setBackground(new Color(255, 255, 255, 0));

        spaceTop = new JPanel(new BorderLayout());
        spaceTop.setPreferredSize(new Dimension(800, 30));
        spaceTop.setBackground(new Color(255, 255, 255, 0));
        //spaceTop.setIcon(new ImageIcon(new ImageIcon("images/10x10.png").getImage().getScaledInstance(800, 30, Image.SCALE_DEFAULT)));

        JPanel infoTicket = new JPanel(new BorderLayout());
        infoTicket.setPreferredSize(new Dimension(widthGet - 130 - 270, 40));
        infoTicket.setBackground(new Color(76, 173, 255));
        infoTicket.setBorder(borderWhile);

        JPanel infoTicketLeft = new JPanel(new BorderLayout());
        infoTicketLeft.setPreferredSize(new Dimension(208, 40));
        infoTicketLeft.setBackground(new Color(76, 173, 255));

        JLabel from = new JLabel(tuyen.getDiemXuatPhat());
        from.setPreferredSize(new Dimension(80, 40));
        from.setHorizontalAlignment(JLabel.CENTER);
        from.setForeground(Color.white);
        from.setHorizontalAlignment(JLabel.RIGHT);
        from.setVerticalAlignment(JLabel.CENTER);

        JLabel arrow = new JLabel();
        arrow.setPreferredSize(new Dimension(48, 27));
        arrow.setIcon(new ImageIcon(new ImageIcon("images/right-arrow-space-w.png").getImage().getScaledInstance(48, 16, Image.SCALE_DEFAULT)));
        arrow.setIconTextGap(0);

        JLabel to = new JLabel(tuyen.getDiemDen());
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

        LocalDateTime dateTime = tuyen.getThoiGianKhoiHanh().toLocalDateTime();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        JLabel time = new JLabel(dateTime.format(formatter));
        time.setPreferredSize(new Dimension(60, 40));
        time.setHorizontalAlignment(JLabel.CENTER);
        time.setForeground(Color.white);
        time.setHorizontalAlignment(JLabel.CENTER);
        time.setVerticalAlignment(JLabel.CENTER);

        JLabel day = new JLabel("Ngày " + dateTime.getDayOfMonth() + "-" + dateTime.getMonthValue() + "-" + dateTime.getYear());
        day.setPreferredSize(new Dimension(110, 40));
        day.setHorizontalAlignment(JLabel.CENTER);
        day.setForeground(Color.white);
        day.setHorizontalAlignment(JLabel.LEFT);
        day.setVerticalAlignment(JLabel.CENTER);

        infoTicketRight.add(time, BorderLayout.WEST);
        infoTicketRight.add(day, BorderLayout.EAST);

        JLabel totalTickets = new JLabel("Tổng vé: " + tuyen.getTongGhe());
        totalTickets.setPreferredSize(new Dimension(60, 40));
        totalTickets.setHorizontalAlignment(JLabel.CENTER);
        totalTickets.setForeground(Color.white);
        totalTickets.setHorizontalAlignment(JLabel.CENTER);
        totalTickets.setVerticalAlignment(JLabel.CENTER);

        infoTicket.add(infoTicketLeft, BorderLayout.WEST);
        infoTicket.add(totalTickets, BorderLayout.CENTER);
        infoTicket.add(infoTicketRight, BorderLayout.EAST);

        JPanel titleTable = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        titleTable.setPreferredSize(new Dimension(widthGet - 130 - 270, 38));
        titleTable.setBackground(new Color(255, 255, 255));
        titleTable.setBorder(borderBox);

        JLabel check = new JLabel("Xác nhận");
        check.setPreferredSize(new Dimension(checkW, 38));
        check.setHorizontalAlignment(JLabel.CENTER);
        check.setForeground(new Color(117, 120, 122));
        check.setHorizontalAlignment(JLabel.CENTER);
        check.setVerticalAlignment(JLabel.CENTER);

        Line line0 = new Line();

        JLabel name = new JLabel("Tên");
        System.out.println(nameW);
        name.setPreferredSize(new Dimension(nameW, 38));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setForeground(new Color(117, 120, 122));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);

        Line line1 = new Line();

        JLabel phone = new JLabel("Số điện thoại");
        phone.setPreferredSize(new Dimension(phoneW, 38));
        phone.setHorizontalAlignment(JLabel.CENTER);
        phone.setForeground(new Color(117, 120, 122));
        phone.setHorizontalAlignment(JLabel.CENTER);
        phone.setVerticalAlignment(JLabel.CENTER);

        Line line2 = new Line();

        JLabel totalTicket = new JLabel("Số vé đặt");
        totalTicket.setPreferredSize(new Dimension(totalW, 38));
        totalTicket.setHorizontalAlignment(JLabel.CENTER);
        totalTicket.setForeground(new Color(117, 120, 122));
        totalTicket.setHorizontalAlignment(JLabel.CENTER);
        totalTicket.setVerticalAlignment(JLabel.CENTER);

        Line line3 = new Line();

        JLabel timeBooked = new JLabel("Thời gian đặt");
        timeBooked.setPreferredSize(new Dimension(timeW, 38));
        timeBooked.setHorizontalAlignment(JLabel.CENTER);
        timeBooked.setForeground(new Color(117, 120, 122));
        timeBooked.setHorizontalAlignment(JLabel.CENTER);
        timeBooked.setVerticalAlignment(JLabel.CENTER);

        Line line4 = new Line();

        JLabel delete = new JLabel("Hủy");
        delete.setPreferredSize(new Dimension(deleteW, 38));
        delete.setHorizontalAlignment(JLabel.CENTER);
        delete.setForeground(new Color(117, 120, 122));
        delete.setHorizontalAlignment(JLabel.CENTER);
        delete.setVerticalAlignment(JLabel.CENTER);

        titleTable.add(check);
        titleTable.add(line0);
        titleTable.add(name);
        titleTable.add(line1);
        titleTable.add(phone);
        titleTable.add(line2);
        titleTable.add(totalTicket);
        titleTable.add(line3);
        titleTable.add(timeBooked);
        titleTable.add(line4);
        titleTable.add(delete);

        UIManager.put("ScrollBar.background", new Color(219, 220, 221));
        UIManager.put("ScrollBar.highlight", new Color(252, 210, 33, 0));

        JPanel ka = new JPanel();
        ka.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        MatteBorder borderInputPass = new MatteBorder(0, 0, 0, 0, new Color(0, 0, 0));
        ka.setBorder(borderInputPass);
        ka.setBackground(new Color(119, 191, 251));
        height = danhSachKhachHang.size() * 40;
        if (height > heightGet - 251) {
            boxListBooked.setPreferredSize(new Dimension(widthGet - 130 - 270, heightGet - 142));
        } else {
            boxListBooked.setPreferredSize(new Dimension(widthGet - 130 - 270, 108 + height));
        }
        ka.setPreferredSize(new Dimension(widthGet - 130 - 270 - 17, height + 1));

//        for (int i = 0; i < 20; i++) {
//            if (i % 2 == 0) {
//                ka.add(new ListBookedB(i));
//            } else {
//                ka.add(new ListBookedW(i));
//            }
//        }
//        int count = 0;
//
//        for (KhachHangDTO khachHang : danhSachKhachHang) {
//            if(count % 2 == 0) {
//                ka.add(new ListBookedB(khachHang));
//            } else {
//                ka.add(new ListBookedW(khachHang));
//            }
//            count++;
//        }
        JViewport viewport = new JViewport();
        viewport.setView(ka);
        JScrollPane hi = new JScrollPane();
        hi.setViewport(viewport);
        if (height > heightGet - 251) {
            hi.setPreferredSize(new Dimension(widthGet - 130 - 270, heightGet - 251));
        } else {
            hi.setPreferredSize(new Dimension(widthGet - 130 - 270, height));
        }
        hi.setBorder(borderInputPass);
        hi.setOpaque(false);
        hi.getViewport().setOpaque(false);
        hi.getVerticalScrollBar().setUnitIncrement(5);
        hi.setBackground(new Color(0, 0, 0, 0));

        boxListBooked.setBorder(borderBox);

        boxListBooked.add(spaceTop);
        boxListBooked.add(infoTicket);
        boxListBooked.add(titleTable);
        boxListBooked.add(hi);
        bgBooked.add(boxListBooked);

        Font fontTextTitle = new Font("SansSerif", Font.PLAIN, 16);

        JLabel noTicket = new JLabel("Chưa Có Khách Đặt Mua!");
        noTicket.setPreferredSize(new Dimension(width, 40));
        noTicket.setVerticalAlignment(JLabel.CENTER);
        noTicket.setHorizontalAlignment(JLabel.CENTER);
        noTicket.setForeground(new Color(100, 100, 100));
        noTicket.setFont(fontTextTitle);

        this.add(bgBooked);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                int widthG = widthGet - 130 - 270;
                int width;
                if (height > heightGet - 251) {
                    width = widthG - 17;
                } else {
                    width = widthG;
                }
                int widthOutLine = width - 5;

                float checkW2 = (float) widthOutLine / 100 * 10;
                float nameW2 = (float) widthOutLine / 100 * 26;
                float phoneW2 = (float) widthOutLine / 100 * 19;
                float totalW2 = (float) widthOutLine / 100 * 13;
                float timeW2 = (float) widthOutLine / 100 * 21;

                int checkW = Math.round(checkW2) + 1;
                int nameW = Math.round(nameW2);
                int phoneW = Math.round(phoneW2);
                int totalW = Math.round(totalW2);
                int timeW = Math.round(timeW2);
                int deleteW = widthOutLine - (checkW + nameW + phoneW + totalW + timeW);

                if (height > heightGet - 251) {
                    boxListBooked.setPreferredSize(new Dimension(widthGet - 130 - 270, heightGet - 142));
                } else {
                    boxListBooked.setPreferredSize(new Dimension(widthGet - 130 - 270, 109 + height));
                }
                infoTicket.setPreferredSize(new Dimension(widthG, 40));
                titleTable.setPreferredSize(new Dimension(widthG, 38));
                ka.setPreferredSize(new Dimension(widthG - 17, height));
                if (height > heightGet - 251) {
                    hi.setPreferredSize(new Dimension(widthGet - 130 - 270, heightGet - 251));
                } else {
                    hi.setPreferredSize(new Dimension(widthGet - 130 - 270, height));
                }
                name.setPreferredSize(new Dimension(nameW, 38));
                phone.setPreferredSize(new Dimension(phoneW, 38));
                totalTicket.setPreferredSize(new Dimension(totalW, 38));
                timeBooked.setPreferredSize(new Dimension(timeW, 38));
                delete.setPreferredSize(new Dimension(deleteW, 38));
                ka.removeAll();

//                for (int i = 0; i < 20; i++) {
//                    if (i % 2 == 0) {
//                        ka.add(new ListBookedB(i));
//                    } else {
//                        ka.add(new ListBookedW(i));
//                    }
//                }
                int count = 0;

                for (KhachHangDTO khachHang : danhSachKhachHang) {
                    if (count % 2 == 0) {
                        ka.add(new ListBookedB(khachHang));
                    } else {
                        ka.add(new ListBookedW(khachHang));
                    }
                    count++;
                }

                if (count <= 0) {
                    ka.add(noTicket);
                }

                timeBooked.revalidate();
                boxListBooked.revalidate();
            }
        });

//        addMouseMotionListener(new MouseAdapter() {
//            public void mouseEntered(MouseEvent e) {
//                if (rePP == 0) {
//                    bgBooked.validate();
//                    bgBooked.repaint();
//                    rePP++;
//                }
//            }
//        });
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                System.out.println("hihi");
                if (rePP == 0) {
                    bgBooked.validate();
                    bgBooked.repaint();
                    rePP++;
                }
            }
        });
        hi.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                System.out.println("hihi");
                if (rePP == 0) {
                    bgBooked.validate();
                    bgBooked.repaint();
                    rePP++;
                }
            }
        });
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

        JPanel boxButtonDeleteT, boxButtonDeleteTHover, boxButtonCheckT, boxButtonCheckTHover;

        public ListBookedB(KhachHangDTO khachHang) {
            MatteBorder borderBlack = new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0));

            int widthArea = widthGet - 130 - 270;
            int width;
            if (height > heightGet - 251) {
                width = widthArea - 17;
            } else {
                width = widthArea;
            }
            int widthOutLine = width - 5;

            float checkW2 = (float) widthOutLine / 100 * 10;
            float nameW2 = (float) widthOutLine / 100 * 26;
            float phoneW2 = (float) widthOutLine / 100 * 19;
            float totalW2 = (float) widthOutLine / 100 * 13;
            float timeW2 = (float) widthOutLine / 100 * 21;

            int checkW = Math.round(checkW2);
            int nameW = Math.round(nameW2);
            int phoneW = Math.round(phoneW2);
            int totalW = Math.round(totalW2);
            int timeW = Math.round(timeW2);
            int deleteW = widthOutLine - (checkW + nameW + phoneW + totalW + timeW);

            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            this.setPreferredSize(new Dimension(width, 40));
            this.setBackground(new Color(239, 241, 242));
            MatteBorder borderLR = new MatteBorder(0, 1, 0, 1, new Color(219, 220, 221));
            this.setBorder(borderLR);

            JPanel boxButtonCheck = new JPanel(new GridBagLayout());
            boxButtonCheck.setPreferredSize(new Dimension(checkW, 38));
            boxButtonCheck.setBackground(new Color(239, 241, 242));

            boxButtonCheckT = new JPanel(new BorderLayout());
            boxButtonCheckT.setPreferredSize(new Dimension(24, 24));
            boxButtonCheckT.setBackground(new Color(39, 241, 242));

            boxButtonCheckTHover = new JPanel(new BorderLayout());
            boxButtonCheckTHover.setPreferredSize(new Dimension(24, 24));
            boxButtonCheckTHover.setBackground(new Color(39, 241, 242));

            JButton check = new JButton();
            check.setPreferredSize(new Dimension(24, 24));
            check.setBackground(new Color(0, 0, 0, 0));
            check.setRolloverEnabled(false);
            check.setBorderPainted(false);
            check.setFocusPainted(false);
            check.setContentAreaFilled(false);
            check.setCursor(new Cursor(Cursor.HAND_CURSOR));

            try {
                Image imgButtonLogin = null;
                imgButtonLogin = ImageIO.read(new File("images/verified.png"));
                boxButtonCheckT = new ImagePanel(imgButtonLogin, 24, 24);
            } catch (IOException | HeadlessException exp) {
                exp.printStackTrace();
            }

            try {
                Image imgButtonLogin = null;
                imgButtonLogin = ImageIO.read(new File("images/verified-hover.png"));
                boxButtonCheckTHover = new ImagePanel(imgButtonLogin, 24, 24);
            } catch (IOException | HeadlessException exp) {
                exp.printStackTrace();
            };

            check.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    boxButtonCheckTHover.add(check);
                    boxButtonCheck.remove(boxButtonCheckT);
                    boxButtonCheck.add(boxButtonCheckTHover);
                    boxButtonCheck.validate();
                    boxButtonCheck.repaint();
                }
            });

            check.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    boxButtonCheckT.add(check);
                    boxButtonCheck.remove(boxButtonCheckTHover);
                    boxButtonCheck.add(boxButtonCheckT);
                    boxButtonCheck.validate();
                    boxButtonCheck.repaint();
                }
            });

            boxButtonCheckT.add(check);
            boxButtonCheck.add(boxButtonCheckT);

            Line line0 = new Line();

            JLabel name = new JLabel(khachHang.getHoTen());
            name.setPreferredSize(new Dimension(nameW, 38));
            name.setHorizontalAlignment(JLabel.CENTER);
            name.setForeground(new Color(117, 120, 122));
            name.setHorizontalAlignment(JLabel.CENTER);
            name.setVerticalAlignment(JLabel.CENTER);

            Line line1 = new Line();

            JLabel phone = new JLabel(khachHang.getSdt());
            phone.setPreferredSize(new Dimension(phoneW, 38));
            phone.setHorizontalAlignment(JLabel.CENTER);
            phone.setForeground(new Color(117, 120, 122));
            phone.setHorizontalAlignment(JLabel.CENTER);
            phone.setVerticalAlignment(JLabel.CENTER);

            Line line2 = new Line();

            JLabel totalTicket = new JLabel(khachHang.getSoVeDat() + "");
            totalTicket.setPreferredSize(new Dimension(totalW, 38));
            totalTicket.setHorizontalAlignment(JLabel.CENTER);
            totalTicket.setForeground(new Color(117, 120, 122));
            totalTicket.setHorizontalAlignment(JLabel.CENTER);
            totalTicket.setVerticalAlignment(JLabel.CENTER);

            Line line3 = new Line();

            DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDateTime dateTime = khachHang.getThoiGianDat().toLocalDateTime();

            JLabel timeBooked = new JLabel(dateTime.format(formatterTime) + " ngày " + dateTime.format(formatterDate));
            timeBooked.setPreferredSize(new Dimension(timeW, 38));
            timeBooked.setHorizontalAlignment(JLabel.CENTER);
            timeBooked.setForeground(new Color(117, 120, 122));
            timeBooked.setHorizontalAlignment(JLabel.CENTER);
            timeBooked.setVerticalAlignment(JLabel.CENTER);

            Line line4 = new Line();

            JPanel boxButtonDelete = new JPanel(new GridBagLayout());
            boxButtonDelete.setPreferredSize(new Dimension(deleteW - 2, 38));
            boxButtonDelete.setBackground(new Color(239, 241, 242));

            boxButtonDeleteT = new JPanel(new BorderLayout());
            boxButtonDeleteT.setPreferredSize(new Dimension(24, 24));
            boxButtonDeleteT.setBackground(new Color(39, 241, 242));

            boxButtonDeleteTHover = new JPanel(new BorderLayout());
            boxButtonDeleteTHover.setPreferredSize(new Dimension(24, 24));
            boxButtonDeleteTHover.setBackground(new Color(39, 241, 242));

            JButton delete = new JButton();
            delete.setPreferredSize(new Dimension(24, 24));
            delete.setBackground(new Color(0, 0, 0, 0));
            delete.setRolloverEnabled(false);
            delete.setBorderPainted(false);
            delete.setFocusPainted(false);
            delete.setContentAreaFilled(false);
            delete.setCursor(new Cursor(Cursor.HAND_CURSOR));

            try {
                Image imgButtonLogin = null;
                imgButtonLogin = ImageIO.read(new File("images/delete-button.png"));
                boxButtonDeleteT = new ImagePanel(imgButtonLogin, 24, 24);
            } catch (IOException | HeadlessException exp) {
                exp.printStackTrace();
            }

            try {
                Image imgButtonLogin = null;
                imgButtonLogin = ImageIO.read(new File("images/delete-button-hover.png"));
                boxButtonDeleteTHover = new ImagePanel(imgButtonLogin, 24, 24);
            } catch (IOException | HeadlessException exp) {
                exp.printStackTrace();
            };

            delete.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    boxButtonDeleteTHover.add(delete);
                    boxButtonDelete.remove(boxButtonDeleteT);
                    boxButtonDelete.add(boxButtonDeleteTHover);
                    boxButtonDelete.validate();
                    boxButtonDelete.repaint();
                }
            });

            delete.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    boxButtonDeleteT.add(delete);
                    boxButtonDelete.remove(boxButtonDeleteTHover);
                    boxButtonDelete.add(boxButtonDeleteT);
                    boxButtonDelete.validate();
                    boxButtonDelete.repaint();
                }
            });

            boxButtonDeleteT.add(delete);
            boxButtonDelete.add(boxButtonDeleteT);

            this.add(boxButtonCheck);
            this.add(line0);
            this.add(name);
            this.add(line1);
            this.add(phone);
            this.add(line2);
            this.add(totalTicket);
            this.add(line3);
            this.add(timeBooked);
            this.add(line4);
            this.add(boxButtonDelete);

            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (check == 0) {
                        int res = KhachHangBUS.deleteCustomer(khachHang.getId());
                        areaPanel.removeAll();
                        bookedTicket = new BookedTicket(tuyen);
                        areaPanel.add(bookedTicket);
                        areaPanel.validate();
                        areaPanel.repaint();
                    }

                }
            });
        }
    }

    public class ListBookedW extends JPanel {

        JPanel boxButtonDeleteT, boxButtonDeleteTHover, boxButtonCheckT, boxButtonCheckTHover;

        public ListBookedW(KhachHangDTO khachHang) {

            int widthArea = widthGet - 130 - 270;
            int width;
            if (height > heightGet - 251) {
                width = widthArea - 17;
            } else {
                width = widthArea;
            }
            int widthOutLine = width - 5;

            float checkW2 = (float) widthOutLine / 100 * 10;
            float nameW2 = (float) widthOutLine / 100 * 26;
            float phoneW2 = (float) widthOutLine / 100 * 19;
            float totalW2 = (float) widthOutLine / 100 * 13;
            float timeW2 = (float) widthOutLine / 100 * 21;

            int checkW = Math.round(checkW2);
            int nameW = Math.round(nameW2);
            int phoneW = Math.round(phoneW2);
            int totalW = Math.round(totalW2);
            int timeW = Math.round(timeW2);
            int deleteW = widthOutLine - (checkW + nameW + phoneW + totalW + timeW);

            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            this.setPreferredSize(new Dimension(width, 40));
            this.setBackground(new Color(255, 255, 255));
            MatteBorder borderLR = new MatteBorder(0, 1, 0, 1, new Color(219, 220, 221));
            this.setBorder(borderLR);

            JPanel boxButtonCheck = new JPanel(new GridBagLayout());
            boxButtonCheck.setPreferredSize(new Dimension(checkW, 38));
            boxButtonCheck.setBackground(new Color(255, 255, 255));

            boxButtonCheckT = new JPanel(new BorderLayout());
            boxButtonCheckT.setPreferredSize(new Dimension(24, 24));
            boxButtonCheckT.setBackground(new Color(255, 255, 255));

            boxButtonCheckTHover = new JPanel(new BorderLayout());
            boxButtonCheckTHover.setPreferredSize(new Dimension(24, 24));
            boxButtonCheckTHover.setBackground(new Color(255, 255, 255));

            JButton check = new JButton();
            check.setPreferredSize(new Dimension(24, 24));
            check.setBackground(new Color(0, 0, 0, 0));
            check.setRolloverEnabled(false);
            check.setBorderPainted(false);
            check.setFocusPainted(false);
            check.setContentAreaFilled(false);
            check.setCursor(new Cursor(Cursor.HAND_CURSOR));

            try {
                Image imgButtonLogin = null;
                imgButtonLogin = ImageIO.read(new File("images/verified.png"));
                boxButtonCheckT = new ImagePanel(imgButtonLogin, 24, 24);
            } catch (IOException | HeadlessException exp) {
                exp.printStackTrace();
            }

            try {
                Image imgButtonLogin = null;
                imgButtonLogin = ImageIO.read(new File("images/verified-hover.png"));
                boxButtonCheckTHover = new ImagePanel(imgButtonLogin, 24, 24);
            } catch (IOException | HeadlessException exp) {
                exp.printStackTrace();
            };

            check.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    boxButtonCheckTHover.add(check);
                    boxButtonCheck.remove(boxButtonCheckT);
                    boxButtonCheck.add(boxButtonCheckTHover);
                    boxButtonCheck.validate();
                    boxButtonCheck.repaint();
                }
            });

            check.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    boxButtonCheckT.add(check);
                    boxButtonCheck.remove(boxButtonCheckTHover);
                    boxButtonCheck.add(boxButtonCheckT);
                    boxButtonCheck.validate();
                    boxButtonCheck.repaint();
                }
            });

            boxButtonCheckT.add(check);
            boxButtonCheck.add(boxButtonCheckT);

            Line line0 = new Line();

            JLabel name = new JLabel(khachHang.getHoTen());
            name.setPreferredSize(new Dimension(nameW, 38));
            name.setHorizontalAlignment(JLabel.CENTER);
            name.setForeground(new Color(117, 120, 122));
            name.setHorizontalAlignment(JLabel.CENTER);
            name.setVerticalAlignment(JLabel.CENTER);

            Line line1 = new Line();

            JLabel phone = new JLabel(khachHang.getSdt());
            phone.setPreferredSize(new Dimension(phoneW, 38));
            phone.setHorizontalAlignment(JLabel.CENTER);
            phone.setForeground(new Color(117, 120, 122));
            phone.setHorizontalAlignment(JLabel.CENTER);
            phone.setVerticalAlignment(JLabel.CENTER);

            Line line2 = new Line();

            JLabel totalTicket = new JLabel(khachHang.getSoVeDat() + "");
            totalTicket.setPreferredSize(new Dimension(totalW, 38));
            totalTicket.setHorizontalAlignment(JLabel.CENTER);
            totalTicket.setForeground(new Color(117, 120, 122));
            totalTicket.setHorizontalAlignment(JLabel.CENTER);
            totalTicket.setVerticalAlignment(JLabel.CENTER);

            Line line3 = new Line();

            DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDateTime dateTime = khachHang.getThoiGianDat().toLocalDateTime();

            JLabel timeBooked = new JLabel(dateTime.format(formatterTime) + " ngày " + dateTime.format(formatterDate));
            timeBooked.setPreferredSize(new Dimension(timeW, 38));
            timeBooked.setHorizontalAlignment(JLabel.CENTER);
            timeBooked.setForeground(new Color(117, 120, 122));
            timeBooked.setHorizontalAlignment(JLabel.CENTER);
            timeBooked.setVerticalAlignment(JLabel.CENTER);

            Line line4 = new Line();

            JPanel boxButtonDelete = new JPanel(new GridBagLayout());
            boxButtonDelete.setPreferredSize(new Dimension(deleteW - 2, 38));
            boxButtonDelete.setBackground(new Color(255, 255, 255));

            boxButtonDeleteT = new JPanel(new BorderLayout());
            boxButtonDeleteT.setPreferredSize(new Dimension(24, 24));
            boxButtonDeleteT.setBackground(new Color(255, 255, 255));

            boxButtonDeleteTHover = new JPanel(new BorderLayout());
            boxButtonDeleteTHover.setPreferredSize(new Dimension(24, 24));
            boxButtonDeleteTHover.setBackground(new Color(255, 255, 255));

            JButton delete = new JButton();
            delete.setPreferredSize(new Dimension(24, 24));
            delete.setBackground(new Color(255, 255, 255));
            delete.setRolloverEnabled(false);
            delete.setBorderPainted(false);
            delete.setFocusPainted(false);
            delete.setContentAreaFilled(false);
            delete.setCursor(new Cursor(Cursor.HAND_CURSOR));

            try {
                Image imgButtonLogin = null;
                imgButtonLogin = ImageIO.read(new File("images/delete-button.png"));
                boxButtonDeleteT = new ImagePanel(imgButtonLogin, 24, 24);
            } catch (IOException | HeadlessException exp) {
                exp.printStackTrace();
            }

            try {
                Image imgButtonLogin = null;
                imgButtonLogin = ImageIO.read(new File("images/delete-button-hover.png"));
                boxButtonDeleteTHover = new ImagePanel(imgButtonLogin, 24, 24);
            } catch (IOException | HeadlessException exp) {
                exp.printStackTrace();
            };

            delete.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    boxButtonDeleteTHover.add(delete);
                    boxButtonDelete.remove(boxButtonDeleteT);
                    boxButtonDelete.add(boxButtonDeleteTHover);
                    boxButtonDelete.validate();
                    boxButtonDelete.repaint();
                }
            });

            delete.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    boxButtonDeleteT.add(delete);
                    boxButtonDelete.remove(boxButtonDeleteTHover);
                    boxButtonDelete.add(boxButtonDeleteT);
                    boxButtonDelete.validate();
                    boxButtonDelete.repaint();
                }
            });

            boxButtonDeleteT.add(delete);
            boxButtonDelete.add(boxButtonDeleteT);

            this.add(boxButtonCheck);
            this.add(line0);
            this.add(name);
            this.add(line1);
            this.add(phone);
            this.add(line2);
            this.add(totalTicket);
            this.add(line3);
            this.add(timeBooked);
            this.add(line4);
            this.add(boxButtonDelete);

        }
    }
}
