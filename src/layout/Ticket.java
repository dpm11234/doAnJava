/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import bus.NhaXeBUS;
import createUI.ImagePanel;
import dto.TuyenDTO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import static layout.Dashboard.selectTicketPanel;
import static layout.Content.*;
import static layout.Navbar.navBackSelect;
import static layout.Navbar.navLogin;
import static layout.Navbar.titleSpace;

/**
 *
 * @author my pc
 */
public class Ticket extends JPanel {
    private ImagePanel bgTicket;

    private JButton submit;
    private JLabel price, chair, startingPoint, destination, day;
    private TuyenDTO tuyen;

    public Ticket(TuyenDTO tuyen) {
        this.tuyen = tuyen;

        this.setLayout(new BorderLayout());
        try {
            Image img = null;
            img = ImageIO.read(new File("images/bg/ticket2.png"));
            bgTicket = new ImagePanel(img);
            this.add(bgTicket);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }
        
        MatteBorder borderTest = new MatteBorder(2, 2, 2, 2, new Color(0, 0, 0));
        Font fontPrice = new Font("SansSerif", Font.PLAIN, 12);
        
        
        JPanel leftTop = new JPanel(new BorderLayout());
        leftTop.setPreferredSize(new Dimension(258, 27));
        leftTop.setBackground(new Color(0, 0, 0, 0));
        
        // giá vé
        
        price = new JLabel(tuyen.getGia() + "");
        price.setFont(fontPrice);
        price.setPreferredSize(new Dimension(130, 27));
        price.setIcon(new ImageIcon(new ImageIcon("images/money.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
        price.setIconTextGap(6);
        price.setForeground(Color.white);
//        price.setBorder(borderTest);
        
        JLabel priceSpace = new JLabel("");
        priceSpace.setPreferredSize(new Dimension(15, 27));
        
        JPanel priceJPanel = new JPanel(new BorderLayout());
        priceJPanel.setBackground(new Color(0, 0, 0, 0));
        priceJPanel.add(priceSpace, BorderLayout.WEST);
        priceJPanel.add(price, BorderLayout.CENTER);
        
        // Số ghế trống
        
        JPanel chairJPanel = new JPanel(new BorderLayout());
        chairJPanel.setBackground(new Color(0, 0, 0, 0));
        
        chair = new JLabel("Trống: " + tuyen.getSoLuong());
        chair.setFont(fontPrice);
        chair.setPreferredSize(new Dimension(80, 27));
        chair.setIcon(new ImageIcon(new ImageIcon("images/armchair2.png").getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT)));
        chair.setIconTextGap(6);
        chair.setForeground(Color.white);
        
        JLabel chairSpace = new JLabel("");
        chairSpace.setPreferredSize(new Dimension(15, 27));
        
        chairJPanel.add(chair, BorderLayout.CENTER);
        chairJPanel.add(chairSpace, BorderLayout.EAST);
        
        leftTop.add(priceJPanel, BorderLayout.WEST);
        leftTop.add(chairJPanel, BorderLayout.EAST);
        
        
        // Chia layout left
        
        
        JPanel leftCenter = new JPanel(new BorderLayout());
        leftCenter.setBackground(new Color(0, 0, 0, 0));
        JPanel leftCenterInfo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        leftCenterInfo.setPreferredSize(new Dimension(218, 27));
        leftCenterInfo.setBackground(new Color(0, 0, 0, 0));
        JPanel leftCenterButton = new JPanel(new BorderLayout());
        leftCenterButton.setPreferredSize(new Dimension(40, 27));
        leftCenterButton.setBackground(new Color(0, 0, 0, 0));
        
        // Tuyến xe
        
//        JPanel leftCenter = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
//        leftCenter.setBackground(new Color(0, 0, 0, 0));
        
        
        JPanel buses = new JPanel(new BorderLayout());
        buses.setPreferredSize(new Dimension(218, 27));
        buses.setBackground(new Color(0, 0, 0, 0));
        
        startingPoint = new JLabel(tuyen.getDiemXuatPhat());
        startingPoint.setPreferredSize(new Dimension(101, 27));
        startingPoint.setFont(fontPrice);
        startingPoint.setForeground(Color.black);
        startingPoint.setVerticalAlignment(JLabel.CENTER);
        startingPoint.setHorizontalAlignment(JLabel.CENTER);
        
        destination = new JLabel(tuyen.getDiemDen());
        destination.setPreferredSize(new Dimension(101, 27));
        destination.setFont(fontPrice);
        destination.setForeground(Color.black);
        destination.setVerticalAlignment(JLabel.CENTER);
        destination.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel arrow = new JLabel();
        arrow.setPreferredSize(new Dimension(16, 27));
        arrow.setIcon(new ImageIcon(new ImageIcon("images/right-arrow.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
        arrow.setIconTextGap(0);
        
        buses.add(startingPoint, BorderLayout.WEST);
        buses.add(arrow, BorderLayout.CENTER);
        buses.add(destination, BorderLayout.EAST);
        
        // Thời gian khởi hành
        
        JPanel time = new JPanel(new BorderLayout());
        time.setPreferredSize(new Dimension(218, 27));
        time.setBackground(new Color(0, 0, 0, 0));

        LocalDateTime date = tuyen.getThoiGianKhoiHanh().toLocalDateTime();

        day = new JLabel(
                date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear()
        );

        day.setPreferredSize(new Dimension(101, 27));
        day.setFont(fontPrice);
        day.setForeground(Color.black);
        day.setVerticalAlignment(JLabel.CENTER);
        day.setHorizontalAlignment(JLabel.CENTER);

         //format giờ
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String timeStart = date.format(timeFormatter);

        JLabel hours = new JLabel(timeStart);
        hours.setPreferredSize(new Dimension(101, 27));
        hours.setFont(fontPrice);
        hours.setForeground(Color.black);
        hours.setVerticalAlignment(JLabel.CENTER);
        hours.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel oclock = new JLabel();
        oclock.setPreferredSize(new Dimension(16, 27));
        oclock.setIcon(new ImageIcon(new ImageIcon("images/oclock.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
        oclock.setIconTextGap(0);
        
        time.add(day, BorderLayout.WEST);
        time.add(oclock, BorderLayout.CENTER);
        time.add(hours, BorderLayout.EAST);
        
        // Tên nhà xe
        
        JPanel company = new JPanel(new BorderLayout());
        company.setPreferredSize(new Dimension(218, 27));
        company.setBackground(new Color(0, 0, 0, 0));
        
        JLabel companyLable = new JLabel("Nhà xe:");
        companyLable.setPreferredSize(new Dimension(84, 27));
        companyLable.setFont(fontPrice);
        companyLable.setIcon(new ImageIcon(new ImageIcon("images/id-card.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
        companyLable.setForeground(Color.black);
        companyLable.setVerticalAlignment(JLabel.CENTER);
        companyLable.setHorizontalAlignment(JLabel.RIGHT);

        JLabel companyName = new JLabel(NhaXeBUS.getTenNX(tuyen.getMaNX()));
        companyName.setPreferredSize(new Dimension(101, 27));
        companyName.setFont(fontPrice);
        companyName.setForeground(Color.black);
        companyName.setVerticalAlignment(JLabel.CENTER);
        companyName.setHorizontalAlignment(JLabel.LEFT);
        companyName.setIconTextGap(0);
        companyName.setIcon(new ImageIcon(new ImageIcon("images/10x10.png").getImage().getScaledInstance(6, 8, Image.SCALE_DEFAULT)));
        
        company.add(companyLable, BorderLayout.WEST);
        company.add(companyName, BorderLayout.CENTER);
        
        leftCenterInfo.add(buses);
        leftCenterInfo.add(time);
        leftCenterInfo.add(company);
        
        // Button submit
        
        JPanel submitBg = new JPanel(new BorderLayout());
        try {
            Image imgButtonLogin = null;
            imgButtonLogin = ImageIO.read(new File("images/bg/submit6.png"));
            submitBg = new ImagePanel(imgButtonLogin, 30, 71);
            submitBg.setPreferredSize(new Dimension(30, 71));
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }
        
        submit = new JButton();
        submit.setPreferredSize(new Dimension(30, 71));
        submit.setBackground(new Color(0, 0, 0));
        submit.setForeground(Color.white);
        submit.setRolloverEnabled(false);
        submit.setBorderPainted(false);
        submit.setFocusPainted(false);
        submit.setContentAreaFilled(false);
        submitBg.add(submit, BorderLayout.NORTH);
        submitBg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel submitSpaceTop = new JLabel();
        submitSpaceTop.setPreferredSize(new Dimension(0, 5));
        JLabel submitSpaceBottom = new JLabel();
        submitSpaceBottom.setPreferredSize(new Dimension(0, 15));
        JLabel submitSpaceRight = new JLabel();
        submitSpaceRight.setPreferredSize(new Dimension(10, 10));
        
        leftCenterButton.add(submitSpaceTop, BorderLayout.NORTH);
        leftCenterButton.add(submitBg, BorderLayout.CENTER);
        leftCenterButton.add(submitSpaceBottom, BorderLayout.SOUTH);
        leftCenterButton.add(submitSpaceRight, BorderLayout.EAST);
        
        leftCenter.add(leftCenterInfo, BorderLayout.WEST);
        leftCenter.add(leftCenterButton, BorderLayout.CENTER);
        
        bgTicket.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JPanel left = new JPanel();
        left.setBackground(new Color(68, 175, 47, 0));
        left.setPreferredSize(new Dimension(258, 118));
        left.setLayout(new BorderLayout());
        
        left.add(leftTop, BorderLayout.NORTH);
        left.add(leftCenter, BorderLayout.CENTER);
        
        JPanel right = new JPanel(new BorderLayout());
        right.setBackground(new Color(178, 122, 39, 0));
        right.setPreferredSize(new Dimension(122, 118));
        
        JPanel rightTop = new JPanel(new BorderLayout());
        rightTop.setPreferredSize(new Dimension(122, 27));
        rightTop.setBackground(new Color(0, 0, 0, 0));
        
        JLabel info = new JLabel("Thông tin xe");
        info.setFont(fontPrice);
        info.setPreferredSize(new Dimension(122, 27));
        info.setForeground(Color.white);
        info.setVerticalAlignment(JLabel.CENTER);
        info.setHorizontalAlignment(JLabel.CENTER);
        
        rightTop.add(info, BorderLayout.NORTH);
        
        JPanel rightCenter = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rightCenter.setPreferredSize(new Dimension(218, 27));
        rightCenter.setBackground(new Color(0, 0, 0, 0));
        
        // Loại xe
        
        JLabel typeBus = new JLabel("");
        typeBus.setPreferredSize(new Dimension(122, 33));
        typeBus.setIcon(new ImageIcon(new ImageIcon("images/32c.png").getImage().getScaledInstance(64, 33, Image.SCALE_DEFAULT)));
        typeBus.setVerticalAlignment(JLabel.CENTER);
        typeBus.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel totalChair = new JLabel(tuyen.getTongGhe()+" chỗ");
        totalChair.setPreferredSize(new Dimension(122, 25));
        totalChair.setFont(fontPrice);
        totalChair.setForeground(Color.black);
        totalChair.setVerticalAlignment(JLabel.CENTER);
        totalChair.setHorizontalAlignment(JLabel.CENTER);
        
//        JLabel licensePlate = new JLabel("BS: " + tuyen.getBienSoXe());
        JLabel licensePlate = new JLabel("BS: "+tuyen.getBienSoXe());
        licensePlate.setPreferredSize(new Dimension(122, 25));
        licensePlate.setFont(fontPrice);
        licensePlate.setForeground(Color.black);
        licensePlate.setVerticalAlignment(JLabel.CENTER);
        licensePlate.setHorizontalAlignment(JLabel.CENTER);
        
        rightCenter.add(totalChair);
        rightCenter.add(typeBus);
        rightCenter.add(licensePlate);
        
        right.add(rightTop, BorderLayout.NORTH);
        right.add(rightCenter, BorderLayout.CENTER);
        
        bgTicket.add(left);
        bgTicket.add(right);
        
        Font fontTextTitle = new Font("SansSerif", Font.PLAIN, 18);
        
        JLabel titleListTicket = new JLabel("Đặt Vé");
        titleListTicket.setPreferredSize(new Dimension(100, 60));
        titleListTicket.setVerticalAlignment(JLabel.CENTER);
        titleListTicket.setHorizontalAlignment(JLabel.CENTER);
        titleListTicket.setFont(fontTextTitle);
        titleListTicket.setForeground(new Color(140, 140, 140));

        this.submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaPanel.removeAll();
                pickTicket = new PickTicket(tuyen);
                areaPanel.add(pickTicket);
                areaPanel.validate();
                areaPanel.repaint();
                navbar.removeAll();
                navbar.add(titleListTicket, BorderLayout.CENTER);
                navbar.add(navBackSelect, BorderLayout.WEST);
                navbar.add(navLogin, BorderLayout.EAST);
                navbar.validate();
                navbar.repaint();
            }
        });
    }
}
