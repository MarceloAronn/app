package context;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.TextField;

import data.models.User;
import i18n.TextCodes;
import i18n.Translations;
import ui.custom.BaseWindow;
import ui.custom.ButtonComponent;
import ui.custom.PanelBox;
import ui.custom.TextFieldComponent;

public class RegisterForm extends BaseWindow{
    private TextFieldComponent nameField;
    private TextFieldComponent emailField;
    private TextFieldComponent passwordField;
    private  TextFieldComponent phoneField;
    private ButtonComponent registerButton;
    private Translations lang;
    private PanelBox panel;
    public RegisterForm(Translations lang, String title) {
        super(title);
        this.lang = lang;
        this.setSize(new Dimension(350, 400));
        
        createForm();
    }
    public void createForm() {
        panel = new PanelBox();
        panel.setSize(new Dimension(350, 400));
        panel.roundedBorder(20);
        panel.setLayout(null);
        
        nameField = new TextFieldComponent(lang.getI18nText(TextCodes.userNameTextField), this.panel);
        nameField.setPosition(40);
        nameField.setSize(new Dimension(260, 40));
        nameField.setPlaceHolder(lang.getI18nText(TextCodes.userNameTextField));
        this.panel.add(nameField);
        emailField = new TextFieldComponent(lang.getI18nText(TextCodes.emailTextField), this.panel);
        emailField.setPosition(80);
        emailField.setSize(new Dimension(260, 40));
        emailField.setPlaceHolder(lang.getI18nText(TextCodes.emailTextField));
        this.panel.add(emailField);
        passwordField = new TextFieldComponent(title, this.panel);
        passwordField.setPosition(120);
        passwordField.setSize(new Dimension(260, 40));
        this.panel.add(passwordField);
        phoneField = new TextFieldComponent(lang.getI18nText(TextCodes.phone), this.panel);
        phoneField.setPosition(160);
        phoneField.setSize(new Dimension(260, 40));
        phoneField.setPlaceHolder(lang.getI18nText(TextCodes.phone));
        this.panel.add(phoneField);
        registerButton = new ButtonComponent(lang.getI18nText(TextCodes.registerText), this.panel);
        registerButton.setPosition(200);
        registerButton.setSize(new Dimension(260, 40));
        registerButton.addActionListener((event) -> {
            User user = new User(this.nameField.getText(), this.emailField.getText(), this.passwordField.getText(), this.phoneField.getText());
            this.getListener().onEvent("click-register", user); 
        });
        this.panel.add(registerButton);
        this.add(this.panel);
    }
}
