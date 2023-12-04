package ui.custom;

import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelBox extends JPanel {
    private Integer cornerRadius;
    public void roundedBorder(Integer cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false);
    }
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        if (this.cornerRadius != null) {

            java.awt.Graphics2D graphics = (java.awt.Graphics2D) g;
            
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setColor(getBackground());
            graphics.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, this.cornerRadius, this.cornerRadius);
        }
    }
}
