package ui.custom;

import ui.custom.events.EventListener;

import javax.swing.JFrame;

public class BaseWindow  extends JFrame{
    protected String title;
    private EventListener listener;
    public BaseWindow(String title) {
        super(title);
        this.title = title;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 720);
        setLocationRelativeTo(this);
        setLayout(null);
        setResizable(false);
    }
    public void addEventListener(EventListener listener) {
        this.listener = listener;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void showWindow() {
        setVisible(true);
    }
    public void hideWindow() {
        setVisible(false);
    }
    public EventListener getListener() {
        return listener;
    }
    public void setListener(EventListener listener) {
        this.listener = listener;
    }
    
}
