/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createUI;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import org.jdatepicker.impl.*;

/**
 *
 * @author my pc
 */
public class DatePickerAdd extends JPanel {
    JLabel datePickerSpace, leftAlignDatePicker, rightAlignDatePicker;
    JPanel alignDatePicker;
    JButton changeButton;
    private JFormattedTextField textField;

    public DatePickerAdd(int heightSpace) {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(255, 255, 255));

        addControls(heightSpace);
    }
    
    public void addControls(int heightSpace) {
        
        MatteBorder borderPicker = new MatteBorder(0, 0, 0, 0, new Color(26, 126, 218)); 
        MatteBorder borderTest = new MatteBorder(1, 1, 1, 1, new Color(48, 148, 238));
        
        leftAlignDatePicker = new JLabel("<html><font color='#5898DD'>Ngày</font></html>");
        rightAlignDatePicker = new JLabel("");
        datePickerSpace = new JLabel("");
        datePickerSpace.setPreferredSize(new Dimension(120, heightSpace));
        leftAlignDatePicker.setPreferredSize(new Dimension(50, 0));
        rightAlignDatePicker.setPreferredSize(new Dimension(15, 25));
        leftAlignDatePicker.setHorizontalAlignment(JLabel.CENTER);
        leftAlignDatePicker.setVerticalAlignment(JLabel.NORTH);
        
        alignDatePicker = new JPanel(new BorderLayout());
        alignDatePicker.setBackground(new Color(230, 230, 230));
        
        
        alignDatePicker.add(leftAlignDatePicker, BorderLayout.WEST);
        alignDatePicker.add(rightAlignDatePicker, BorderLayout.EAST);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(new Date());
        String[] parts = date.split("/"); //returns an array with the 2 parts
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];
        int month2 = Integer.parseInt(parts[1]) - 1;
        UtilDateModel model = new UtilDateModel();
        model.setDate(Integer.parseInt(year), month2, Integer.parseInt(day));
        Properties p = new Properties();
        p.put("text.today", "Hôm nay");
        p.put("text.month", "tháng");
        p.put("text.year", "năm");
        
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        textField = datePicker.getJFormattedTextField();

        datePicker.setShowYearButtons(false);
        datePicker.setTextEditable(false);
        datePicker.setButtonFocusable(false);
        
        
        changeButton = (JButton) datePicker.getComponent(1);
        changeButton.setToolTipText("OK");
        changeButton.setText("");

        changeButton.setIcon(new ImageIcon(new ImageIcon("images/calendar@13px.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
        changeButton.setPreferredSize(new Dimension(15, 15));
        changeButton.setBackground(new Color(230, 230, 230));
        changeButton.setBorder(borderPicker);
        changeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        datePicker.getJFormattedTextField().setPreferredSize(new Dimension(120, 30));
        datePicker.getJFormattedTextField().setBackground(new Color(0xeaeaea));
        datePicker.getJFormattedTextField().setText(day + '-' + month + '-' + year);
        datePicker.setBackground(new Color(230, 230, 230));
        textField.setBackground(new Color(230, 230, 230));
        textField.setForeground(new Color(180, 180, 180));
        textField.setBorder(borderPicker);
        textField.setPreferredSize(new Dimension(100, 15));
        Font font1 = new Font("SansSerif", Font.BOLD, 16);
        textField.setFont(font1);

        
        alignDatePicker.add(datePicker, BorderLayout.CENTER);
        
        
        JPanel datepicker = new JPanelInput(25);
        datepicker.setLayout(new BorderLayout());
        datepicker.setBackground(new Color(230, 230, 230));
        datepicker.setPreferredSize(new Dimension(220, 40));
        
        datepicker.add(datePickerSpace, BorderLayout.NORTH);
        datepicker.add(alignDatePicker, BorderLayout.CENTER);
        
        this.add(datepicker);
        
    }
    
    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "dd-MM-yyyy";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }
    }

    public JFormattedTextField getTextField() {
        return textField;
    }
}
