package context;

import data.models.Product;
import data.models.User;
import java.awt.Dimension;
import java.awt.TextField;

import utils.CenterLayout;
import utils.Palette;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import i18n.TextCodes;
import i18n.Translations;
import java.util.ArrayList;
import ui.custom.BaseWindow;
import ui.custom.ButtonComponent;
import ui.custom.ComboBoxComponent;
import ui.custom.PanelBox;
import ui.custom.PasswordTextComponent;
import ui.custom.TextFieldComponent;
import ui.custom.grid.GridTable;
import ui.custom.grid.table.ProductTableModel;
import ui.custom.grid.table.UserTableModel;

public class ViewProducts extends BaseWindow {
    private PanelBox leftBox;
    private PanelBox middle;
    private PanelBox rightBox;
    private Translations lang;
    private ProductTableModel model;
    private ArrayList<String> navList;
    public ViewProducts(Translations lang, String title) {
        super(title);
        this.lang = lang;
        navList = new ArrayList<>();
        navList.add((this.lang.getI18nText(TextCodes.RegisterProductTextNav)));
        createPanels();
        createGrid();
        createMenu();
    }
    public void setData(ArrayList<Product> products) {
        for (Product product : products) {
            model.addRow(product);
        }
    }
    
   
    
    public void refresh(Product product) {
        model.addRow(product);
        model.fireTableDataChanged();
    }
    private void createMenu() {
        Integer bottomMargin = 10;
        for (String item : this.navList) {
            ButtonComponent button = new ButtonComponent(item, this.leftBox);
            button.setActionCommand(item);
            button.setSize(new Dimension(200, 40));
            Integer y = button.getHeight() * this.navList.indexOf(item) + bottomMargin;
            button.setPosition(y);
            button.addActionListener((event) -> {
                this.getListener().onEvent("click-register", event);
                    //RegisterForm registerForm = new RegisterForm(this.lang, this.lang.getI18nText(TextCodes.registerUserNav));
                    //registerForm.showWindow();
                
            });
            this.leftBox.add(button);
        }
    }
    private void createGrid() {
        ArrayList<Product> products = new ArrayList<Product>();
        model = new ProductTableModel(products);
        GridTable grid = new GridTable(model);
        this.middle.add(grid.getScrollPane());
    }
    public void createPanels() {
        this.leftBox = new PanelBox();
        leftBox.roundedBorder(20);
        leftBox.setSize(new Dimension(300, 670));
        leftBox.setLocation(10, 10);
        leftBox.setBackground(Palette.secondary);
        leftBox.setLayout(null);
        this.add(leftBox);

        this.middle = new PanelBox();
        middle.roundedBorder(20);
        middle.setSize(new Dimension(600, 670));
        middle.setLocation(320, 10);
        middle.setBackground(Palette.primary);
        middle.setLayout(null);
        this.add(middle);

        this.rightBox = new PanelBox();
        rightBox.roundedBorder(20);
        rightBox.setSize(new Dimension(250, 670));
        rightBox.setLocation(930, 10);
        rightBox.setBackground(Palette.third);
        rightBox.setLayout(null);
        this.add(rightBox);

    }
    

}