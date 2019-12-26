package view;

import controller.LoginWindowListener;

import javax.swing.*;
import java.awt.*;

public class LoginGUI {
    //设计用户登录图形初始界面
    JFrame frame1 = new JFrame("选课系统");
    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("欢迎使用选课系统!");
    JLabel label2 = new JLabel("学号:");
    JLabel label3 = new JLabel("密码:");
    JLabel label4 = new JLabel("没有账号？点击注册");

    JTextField textField = new JTextField(16);
    JPasswordField passwdField = new JPasswordField(16);
    JButton LoginBt = new JButton("登录");
    JButton ExitBt = new JButton("退出");
    JButton RegisterBt = new JButton("注册");

    public LoginGUI(){
        frame1.setVisible(true);
        frame1.setResizable(false);
        panel.setLayout(null);
        panel.setBackground(Color.white);
        frame1.setBounds(500,100,1060,840);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        label1.setBounds(360, 200,650, 50);
        label1.setFont(new Font("楷体",Font.BOLD,40));

        label2.setBounds(350,274,90,30);
        label2.setFont(new Font("宋体",Font.BOLD,18));

        textField.setBounds(415,274,260,30);
        textField.setFont(new Font("宋体",Font.BOLD,18));

        label3.setBounds(350,334,90,30);
        label3.setFont(new Font("宋体",Font.BOLD,18));

        label4.setBounds(575,260,260,11);
        label4.setFont(new Font("微软雅黑",Font.BOLD,11));

        passwdField.setEchoChar('*');
        passwdField.setBounds(415,334,260,30);
        passwdField.setFont(new Font("黑体",Font.BOLD,18));

        LoginBt.setBounds(450,400,70,30);
        LoginBt.setFont(new Font("微软雅黑",Font.BOLD,16));
        LoginBt.setBackground(Color.GREEN);

        ExitBt.setBounds(520,400,70,30);
        ExitBt.setFont(new Font("微软雅黑",Font.BOLD,16));
        ExitBt.setBackground(Color.RED);

        RegisterBt.setBounds(690,280,65,20);
        RegisterBt.setFont(new Font("楷体",Font.BOLD,14));
        RegisterBt.setBackground(Color.orange);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(textField);
        panel.add(passwdField);
        panel.add(LoginBt);
        panel.add(ExitBt);
        panel.add(RegisterBt);
        frame1.add(panel,BorderLayout.CENTER);
        LoginWindowListener loginWindowListener = new LoginWindowListener(frame1,textField,passwdField,LoginBt,ExitBt,RegisterBt);
    }
}