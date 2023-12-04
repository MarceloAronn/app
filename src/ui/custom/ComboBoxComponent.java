package ui.custom;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import utils.CenterLayout;
import utils.Palette;

public class ComboBoxComponent<T> extends JComboBox<T> {
        private Component parent;
    public ComboBoxComponent(Component parent) {
        this.parent = parent;
        this.setStyles();
    }
    private void setStyles() {
        this.setLocation(CenterLayout.getCenter(this.parent, this), 0);
        this.setForeground(Palette.black);
        this.setBackground(Palette.white);
        super.setSize(260, 40);
        // JLabel comboLabel = (JLabel) this.getRenderer();
        // comboLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel) this.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }
    public void setItems(ArrayList<T>  items) {
        for (T item : items) {
            this.addItem(item);
        }
    }
    public void setPosition(Integer x, Integer y) {
        this.setLocation(x, 0);
    }
    public void setPosition (Integer y) {
        this.setLocation(CenterLayout.getCenter(this.parent, this), y);
    }
    public void setSize(Dimension dimension) {
        super.setSize(dimension);
    }
}
