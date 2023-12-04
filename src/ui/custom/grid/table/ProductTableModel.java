package ui.custom.grid.table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import data.models.Product;

public class ProductTableModel extends AbstractTableModel{
    private ArrayList<Product> Products;
    private String[] columns = {"Name", "Description", "Type", "Price"};
    public ProductTableModel(ArrayList<Product> Products) {
        this.Products = Products;
    }
    public void addRow(Product Product) {
        this.Products.add(Product);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.Products.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product Product = this.Products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Product.getName();
            case 1:
                return Product.getDescription();
            case 2:
                return Product.getType();
            case 3:
                return Product.getPrice();
            default:
                return null;
        }
    }
    
}