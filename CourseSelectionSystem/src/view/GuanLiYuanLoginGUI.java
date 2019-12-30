package view;

import controller.GuanLiYuanLoginWindowListener;

import javax.swing.*;
import java.awt.*;

public class GuanLiYuanLoginGUI {
    JFrame frame1 = new JFrame("ѡ��ϵͳ");
    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("   ����Ա��¼");
    JLabel label2 = new JLabel("�˺�:");
    JLabel label3 = new JLabel("����:");

    JTextField textField = new JTextField(16);
    JPasswordField passwdField = new JPasswordField(16);
    JButton LoginBt = new JButton("��¼");
    JButton ExitBt = new JButton("����");
    public GuanLiYuanLoginGUI(JFrame frame){
        frame1.setVisible(true);
        frame1.setResizable(false);
        panel.setLayout(null);
        panel.setBackground(Color.white);
        frame1.setBounds(500,100,1060,840);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        label1.setBounds(360, 200,650, 50);
        label1.setFont(new Font("����",Font.BOLD,40));

        label2.setBounds(350,274,90,30);
        label2.setFont(new Font("����",Font.BOLD,18));

        textField.setBounds(415,274,260,30);
        textField.setFont(new Font("����",Font.BOLD,18));

        label3.setBounds(350,334,90,30);
        label3.setFont(new Font("����",Font.BOLD,18));


        passwdField.setEchoChar('*');
        passwdField.setBounds(415,334,260,30);
        passwdField.setFont(new Font("����",Font.BOLD,18));

        LoginBt.setBounds(450,400,70,30);
        LoginBt.setFont(new Font("΢���ź�",Font.BOLD,16));
        LoginBt.setBackground(Color.GREEN);

        ExitBt.setBounds(520,400,70,30);
        ExitBt.setFont(new Font("΢���ź�",Font.BOLD,16));
        ExitBt.setBackground(Color.RED);


        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(textField);
        panel.add(passwdField);
        panel.add(LoginBt);
        panel.add(ExitBt);
        frame1.add(panel,BorderLayout.CENTER);
        new GuanLiYuanLoginWindowListener(frame,frame1,textField,passwdField,LoginBt,ExitBt);
    }
}
