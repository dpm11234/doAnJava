/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import createUI.ImagePanel;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import static layout.Content.areaPanel;

/**
 *
 * @author my pc
 */
public class TicketClient extends JPanel {

    private ImagePanel bgTicket;

    private JLabel price, chair, startingPoint, destination, day;
    public JPanel buttonListBooked, buttonListBookedH, buttonEdit, buttonEditH;

    public TicketClient(TuyenDTO tuyen) {
        this.setLayout(new BorderLayout());
        try {
            Image img = null;
            img = ImageIO.read(new File("images/bg/ticket2.png"));
            bgTicket = new ImagePanel(img);
            this.add(bgTicket);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }

        MatteBorder borderTest = new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0));
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
        leftCenterInfo.setPreferredSize(new Dimension(258, 27));
        leftCenterInfo.setBackground(new Color(0, 0, 0, 0));

        // Tuyến xe
        JPanel buses = new JPanel(new BorderLayout());
        buses.setPreferredSize(new Dimension(258, 27));
        buses.setBackground(new Color(0, 0, 0, 0));

        startingPoint = new JLabel(tuyen.getDiemXuatPhat());
        startingPoint.setPreferredSize(new Dimension(121, 27));
        startingPoint.setFont(fontPrice);
        startingPoint.setForeground(Color.black);
        startingPoint.setVerticalAlignment(JLabel.CENTER);
        startingPoint.setHorizontalAlignment(JLabel.CENTER);

        destination = new JLabel(tuyen.getDiemDen());
        destination.setPreferredSize(new Dimension(121, 27));
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
        time.setPreferredSize(new Dimension(258, 27));
        time.setBackground(new Color(0, 0, 0, 0));

        LocalDateTime date = tuyen.getThoiGianKhoiHanh().toLocalDateTime();

        day = new JLabel(
                date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear()
        );
        day.setPreferredSize(new Dimension(121, 27));
        day.setFont(fontPrice);
        day.setForeground(Color.black);
        day.setVerticalAlignment(JLabel.CENTER);
        day.setHorizontalAlignment(JLabel.CENTER);

        // format giờ
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String timeStart = date.format(timeFormatter);

        JLabel hours = new JLabel(timeStart);
        hours.setPreferredSize(new Dimension(121, 27));
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
        JPanel company = new JPanel(new GridBagLayout());
        company.setPreferredSize(new Dimension(258, 30));
        company.setBackground(new Color(244, 244, 244, 0));

        JPanel areaButton = new JPanel(new BorderLayout());
        areaButton.setPreferredSize(new Dimension(180, 24));
        areaButton.setBackground(new Color(244, 244, 244));

        JLabel spaceButton = new JLabel();
        spaceButton.setPreferredSize(new Dimension(15, 24));
        spaceButton.setBackground(new Color(244, 244, 244));

        // Button ViewList
        buttonListBooked = new JPanel(new GridBagLayout());
        buttonListBooked.setPreferredSize(new Dimension(100, 24));
        buttonListBooked.setBackground(new Color(244, 244, 244));
        try {
            Image imgButtonList = ImageIO.read(new File("images/bg/submitListH.png"));
            buttonListBooked = new ImagePanel(imgButtonList, 100, 24);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }

        JButton clickListBooked = new JButton();
        clickListBooked.setPreferredSize(new Dimension(100, 24));
        clickListBooked.setBackground(new Color(244, 244, 244));
        clickListBooked.setForeground(Color.white);
        clickListBooked.setRolloverEnabled(false);
        clickListBooked.setBorderPainted(false);
        clickListBooked.setFocusPainted(false);
        clickListBooked.setContentAreaFilled(false);
        buttonListBooked.add(clickListBooked);
        buttonListBooked.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover 
        buttonListBookedH = new JPanel(new GridBagLayout());
        buttonListBookedH.setPreferredSize(new Dimension(100, 24));
        buttonListBookedH.setBackground(new Color(244, 244, 244));
        try {
            Image imgButtonList = null;
            imgButtonList = ImageIO.read(new File("images/bg/submitList.png"));
            buttonListBookedH = new ImagePanel(imgButtonList, 100, 24);
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }

        // Button Edit
        buttonEdit = new JPanel(new GridBagLayout());
        buttonEdit.setPreferredSize(new Dimension(65, 24));
        try {
            Image imgButtonLogin = null;
            imgButtonLogin = ImageIO.read(new File("images/bg/submitEditH.png"));
            buttonEdit = new ImagePanel(imgButtonLogin, 65, 24);
            buttonEdit.setPreferredSize(new Dimension(65, 24));
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }
        
        buttonEditH = new JPanel(new GridBagLayout());
        buttonEditH.setPreferredSize(new Dimension(65, 24));
        try {
            Image imgButtonLogin = null;
            imgButtonLogin = ImageIO.read(new File("images/bg/submitEdit.png"));
            buttonEditH = new ImagePanel(imgButtonLogin, 65, 24);
            buttonEditH.setPreferredSize(new Dimension(65, 24));
        } catch (IOException | HeadlessException exp) {
            exp.printStackTrace();
        }

        JButton clickEdit = new JButton();
        clickEdit.setPreferredSize(new Dimension(65, 24));
        clickEdit.setBackground(new Color(0, 0, 0, 0));
        clickEdit.setForeground(Color.white);
        clickEdit.setRolloverEnabled(false);
        clickEdit.setBorderPainted(false);
        clickEdit.setFocusPainted(false);
        clickEdit.setContentAreaFilled(false);
        buttonEdit.add(clickEdit);
        buttonEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        areaButton.add(buttonListBooked, BorderLayout.WEST);
        areaButton.add(spaceButton, BorderLayout.CENTER);
        areaButton.add(buttonEdit, BorderLayout.EAST);

        // Hover ListView
        clickListBooked.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                areaButton.remove(buttonListBooked);
                buttonListBookedH.add(clickListBooked);
                buttonListBookedH.setCursor(new Cursor(Cursor.HAND_CURSOR));
                areaButton.add(buttonListBookedH, BorderLayout.WEST);
                areaPanel.validate();
                areaPanel.repaint();
            }
        });

        clickListBooked.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
                areaButton.remove(buttonListBookedH);
                buttonListBooked.add(clickListBooked);
                areaButton.add(buttonListBooked, BorderLayout.WEST);
                areaPanel.validate();
                areaPanel.repaint();
            }
        });

        // Hover Edit
        clickEdit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                areaButton.remove(buttonEdit);
                buttonEditH.add(clickEdit);
                buttonEditH.setCursor(new Cursor(Cursor.HAND_CURSOR));
                areaButton.add(buttonEditH, BorderLayout.EAST);
                areaPanel.validate();
                areaPanel.repaint();
            }
        });

        clickEdit.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
                areaButton.remove(buttonEditH);
                buttonEdit.add(clickEdit);
                areaButton.add(buttonEdit, BorderLayout.EAST);
                areaPanel.validate();
                areaPanel.repaint();
            }
        });

        company.add(areaButton);

        leftCenterInfo.add(buses);
        leftCenterInfo.add(time);
        leftCenterInfo.add(company);

        // Button submit
        leftCenter.add(leftCenterInfo, BorderLayout.WEST);

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

        JLabel totalChair = new JLabel("32 chỗ");
        totalChair.setPreferredSize(new Dimension(122, 25));
        totalChair.setFont(fontPrice);
        totalChair.setForeground(Color.black);
        totalChair.setVerticalAlignment(JLabel.CENTER);
        totalChair.setHorizontalAlignment(JLabel.CENTER);

        JLabel licensePlate = new JLabel("BS: 60A - 03930");
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
    }
}
