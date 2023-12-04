package context;

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
import ui.custom.BaseWindow;
import ui.custom.ButtonComponent;
import ui.custom.ComboBoxComponent;
import ui.custom.PanelBox;
import ui.custom.PasswordTextComponent;
import ui.custom.TextFieldComponent;

public class Login extends BaseWindow {
    private Translations lang;
    // panels
    private PanelBox leftPanel;
    private PanelBox rightPanel;

    // labels
    private JLabel promptLabel;
    private JLabel titleLoginLabel;

    private ComboBoxComponent<String> combo;
    private TextFieldComponent userNameTextField;
    private TextFieldComponent lastNameTextField;
    private PasswordTextComponent passwordTextComponent;

    private ButtonComponent button;
    private ButtonComponent UsersButton;
    public Login(Translations lang, String title) {
        super(title);
        this.lang = lang;
        createPanels();
        createLabels();
        //createTextField();
        //createCombo();
        createButton();
        createButtonP();
    }
    private void createTextField() {
        this.userNameTextField = new TextFieldComponent(this.lang.getI18nText(TextCodes.userNameTextField), this.rightPanel);
        this.userNameTextField.setPosition(40);
        this.rightPanel.add(this.userNameTextField);
        
        this.lastNameTextField = new TextFieldComponent(this.lang.getI18nText(TextCodes.lastNameTextField), this.rightPanel);
        this.lastNameTextField.setPosition(100);
        this.rightPanel.add(this.lastNameTextField);

        this.passwordTextComponent  = new PasswordTextComponent("", this.rightPanel);
        this.passwordTextComponent.setPosition(140);
        this.rightPanel.add(this.passwordTextComponent);
        
    }
    private void createButton() {
        this.button = new ButtonComponent(this.lang.getI18nText(TextCodes.UsersTextNav), this.rightPanel);
        this.button.setPosition(50);
        this.rightPanel.add(this.button);
        this.button.addActionListener(e -> {
            // validations here
            this.getListener().onEvent("click-login", e); // dispatch event to the listener, always the validations are correct
        });
    }
    
    private void createButtonP() {
        this.button = new ButtonComponent(this.lang.getI18nText(TextCodes.ProducTextNav), this.rightPanel);
        this.button.setPosition(100);
        this.rightPanel.add(this.button);
        this.button.addActionListener(e -> {
            // validations here
            this.getListener().onEvent("click-product", e); // dispatch event to the listener, always the validations are correct
        });
    }
    
    private void createLabels() {
        this.promptLabel = new JLabel(this.lang.getI18nText(TextCodes.promptText));
        this.promptLabel.setSize(new Dimension(130, 20));
        this.promptLabel.setLocation(CenterLayout.getCenter(this.leftPanel, promptLabel), 10);
        this.promptLabel.setForeground(Palette.fourth);
        this.promptLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.leftPanel.add(this.promptLabel);

        this.titleLoginLabel = new JLabel(this.lang.getI18nText(TextCodes.registerText));
        this.titleLoginLabel.setSize(new Dimension(130, 20));
        this.titleLoginLabel.setLocation(CenterLayout.getCenter(this.leftPanel, titleLoginLabel), 30);
        this.titleLoginLabel.setForeground(Palette.fourth);
        this.titleLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.leftPanel.add(this.titleLoginLabel);
    }

    private void  createPanels() {
        this.leftPanel = new PanelBox();
        this.leftPanel.roundedBorder(20);
        this.leftPanel.setSize(new Dimension(750, 670));
        this.leftPanel.setLocation(10, 10);
        this.leftPanel.setBackground(Palette.primary);
        this.leftPanel.setLayout(null);
        this.add(this.leftPanel);
        this.rightPanel = new PanelBox();
        this.rightPanel.roundedBorder(20);
        this.rightPanel.setSize(new Dimension(350, 670));
        this.rightPanel.setLocation(810, 10);
        this.rightPanel.setBackground(Palette.secondary);
        this.rightPanel.setLayout(null);
        this.add(this.rightPanel);
    }
    private void createCombo() {
        combo = new ComboBoxComponent<>(this.rightPanel);
        combo.addItem(this.lang.getI18nText(TextCodes.adminText));
        combo.addItem(this.lang.getI18nText(TextCodes.cashierText));
        combo.addItem(this.lang.getI18nText(TextCodes.clientText));
        combo.setPosition(180);
        this.rightPanel.add(combo);
    }

}