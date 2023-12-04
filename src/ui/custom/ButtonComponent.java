package ui.custom;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import utils.CenterLayout;
import utils.Palette;

public class ButtonComponent extends JButton {
    private Component parent;
    public ButtonComponent(String title, Component parent) {
        super(title);
        this.parent = parent;
        this.setStyles();
    }
    private void setStyles() {
        this.setLocation(CenterLayout.getCenter(this.parent, this), 0);
        this.setForeground(Palette.black);
        this.setFocusable(false);
        this.setBackground(Palette.third);
        super.setSize(260, 40);
        this.setHorizontalAlignment(SwingConstants.CENTER);
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
