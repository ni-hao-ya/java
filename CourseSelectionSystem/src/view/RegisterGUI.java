package view;

import controller.RegisterWindowListener;

import javax.swing.*;
import java.awt.*;

public class RegisterGUI {


    public void createRegisterGUI(JFrame frame1){
        JFrame frame2 = new JFrame("学生注册");
        JPanel pane2 = new JPanel();
        JLabel label1 = new JLabel("姓名:");
        JLabel label2 = new JLabel("性别:");
        JLabel label3 = new JLabel("所属学院:");
        JLabel label4 = new JLabel("学号(账号):");
        JLabel label5 = new JLabel("新密码:");
        JLabel label6 = new JLabel("确认新密码:");
        JTextField name = new JTextField(16);
        JTextField account = new JTextField(16);
        JTextField password1 = new JTextField(16);
        JTextField password2 = new JTextField(16);


        frame2.setVisible(true);
        frame2.setResizable(false);
        pane2.setLayout(null);
        pane2.setBackground(Color.white);
        frame2.setBounds(600,200,860,740);




        frame2.addWindowListener(new RegisterWindowListener(frame1,frame2));
    }
}
