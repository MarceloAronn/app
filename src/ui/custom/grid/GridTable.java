package ui.custom.grid;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class GridTable extends JTable {
    private JScrollPane scrollPane;
    public GridTable(AbstractTableModel model) {
        super(model);
        scrollPane = new JScrollPane(this);
        scrollPane.setBounds(10, 10, 580, 650);
        this.setFillsViewportHeight(true);
    }
    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}
