package createUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.Color;
import java.awt.Component;

public class EnableComboBoxRender extends BasicComboBoxRenderer {
    static final long serialVersionUID = -984932432414L;
    private final ListSelectionModel enabledItems;
    private Color disabledColor = Color.gray;

    public EnableComboBoxRender(ListSelectionModel enabled) {
        super();
        this.enabledItems = enabled;
    }

    public void setDisabledColor(Color disabledColor) {
        this.disabledColor = disabledColor;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if(!enabledItems.isSelectedIndex(index)) {
            if(isSelected) {
                c.setBackground(UIManager.getColor("ComboBox.background"));
            } else {
                c.setBackground(super.getBackground());
            }
            c.setForeground(disabledColor);
        } else {
            c.setBackground(super.getBackground());
            c.setForeground(super.getForeground());
        }

        return c;
    }
}
