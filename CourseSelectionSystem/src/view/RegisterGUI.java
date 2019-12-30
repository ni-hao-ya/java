package view;

import controller.RegisterWindowListener;
import entity.College;

import javax.swing.*;
import java.awt.*;

public class RegisterGUI {
    //设计注册界面
    public void createRegisterGUI(JFrame frame1){
        JFrame frame2 = new JFrame("学生注册");
        JPanel pane2 = new JPanel();

        JLabel label = new JLabel("欢迎注册选课系统!");
        label.setBounds(260, 50,650, 50);
        label.setFont(new Font("楷体",Font.BOLD,40));


        JLabel label1 = new JLabel("姓名:");
        label1.setBounds(200,130,80,30);
        label1.setFont(new Font("宋体",Font.BOLD,18));
        JTextField name = new JTextField(16);
        name.setBounds(280,130,300,30);
        name.setFont(new Font("宋体",Font.BOLD,18));

        JLabel label2 = new JLabel("性别:");
        label2.setBounds(200,180,80,30);
        label2.setFont(new Font("宋体",Font.BOLD,18));

        ButtonGroup group = new ButtonGroup();
        JRadioButton sex1 = new JRadioButton("男");
        sex1.setBounds(280,180,40,30);
        sex1.setFont(new Font("宋体",Font.BOLD,12));
        JRadioButton sex2 = new JRadioButton("女");
        sex2.setBounds(320,180,40,30);
        sex2.setFont(new Font("宋体",Font.BOLD,12));
        group.add(sex1);
        group.add(sex2);

        JLabel label3 = new JLabel("所属学院:");
        label3.setBounds(162,230,160,30);
        label3.setFont(new Font("宋体",Font.BOLD,18));
        College college = new College();
        JComboBox comboBox = new JComboBox(college.getV1());
        comboBox.setBounds(280,230,160,30);
        comboBox.setFont(new Font("宋体",Font.BOLD,12));

        JLabel label4 = new JLabel("学号(账号):");
        label4.setBounds(142,280,160,30);
        label4.setFont(new Font("宋体",Font.BOLD,18));
        JTextField account = new JTextField(16);
        account.setBounds(280,280,300,30);
        account.setFont(new Font("宋体",Font.BOLD,18));

        JLabel label5 = new JLabel("新密码:");
        label5.setBounds(180,330,160,30);
        label5.setFont(new Font("宋体",Font.BOLD,18));
        JPasswordField password1 = new JPasswordField(16);
        password1.setBounds(280,330,300,30);
        password1.setEchoChar('*');
        password1.setFont(new Font("黑体",Font.BOLD,18));

        JLabel label6 = new JLabel("确认新密码:");
        label6.setBounds(142,380,160,30);
        label6.setFont(new Font("宋体",Font.BOLD,18));
        JPasswordField password2 = new JPasswordField(16);
        password2.setBounds(280,380,300,30);
        password2.setEchoChar('*');
        password2.setFont(new Font("黑体",Font.BOLD,18));

        JButton registerBt = new JButton("注册");
        registerBt.setBounds(350,450,70,30);
        registerBt.setFont(new Font("微软雅黑",Font.BOLD,16));
        registerBt.setBackground(Color.GREEN);

        pane2.add(label);
        pane2.add(label1);
        pane2.add(label2);
        pane2.add(label3);
        pane2.add(label4);
        pane2.add(label5);
        pane2.add(label6);
        pane2.add(name);
        pane2.add(sex1);
        pane2.add(sex2);
        pane2.add(comboBox);
        pane2.add(account);
        pane2.add(password1);
        pane2.add(password2);
        pane2.add(registerBt);
        frame2.setVisible(true);
        frame2.setResizable(false);
        pane2.setVisible(true);
        pane2.setLayout(null);
        pane2.setBackground(Color.white);
        frame2.add(pane2,BorderLayout.CENTER);
        frame2.setBounds(600,200,860,740);

        frame2.addWindowListener(new RegisterWindowListener(frame1,frame2,name,sex1,sex2,comboBox,account,password1,password2,registerBt));
    }
}
