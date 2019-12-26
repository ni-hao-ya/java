package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterWindowListener extends WindowAdapter {
    JFrame frame1;
    JFrame frame2;
    public RegisterWindowListener(JFrame frame1,JFrame frame2){
        this.frame1 = frame1;
        this.frame2 = frame2;
    }
    public void windowClosing(WindowEvent e) {
        Window window = (Window) e.getComponent();
        window.dispose();
        frame1.setVisible(true);
    }
}
