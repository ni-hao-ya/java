package view;

import controller.GeRenXinXiWindowListener;
import entity.College;
import entity.Student;

import javax.swing.*;
import java.awt.*;

public class GeRenXinXiGUI {
    public GeRenXinXiGUI(JFrame frame3, Student student){
        frame3.setVisible(false);

        JFrame frame4 = new JFrame("�ҵ���Ϣ");
        JPanel panel1 = new JPanel();

        JLabel label1 = new JLabel("����:");
        label1.setBounds(200,130,80,30);
        label1.setFont(new Font("����",Font.BOLD,18));
        JTextField name = new JTextField(student.getName(),16);
        name.setBounds(280,130,300,30);
        name.setFont(new Font("����",Font.BOLD,18));

        JLabel label2 = new JLabel("�Ա�:");
        label2.setBounds(200,180,80,30);
        label2.setFont(new Font("����",Font.BOLD,18));

        ButtonGroup group = new ButtonGroup();
        JRadioButton sex1,sex2;
        if(student.getSex().equals("��")){
            sex1 = new JRadioButton("��",true);
            sex2 = new JRadioButton("Ů",false);
        }else{
            sex2 = new JRadioButton("Ů",true);
            sex1 = new JRadioButton("��",false);
        }
        sex1.setBounds(280,180,40,30);
        sex1.setFont(new Font("����",Font.BOLD,12));
        sex2.setBounds(320,180,40,30);
        sex2.setFont(new Font("����",Font.BOLD,12));
        group.add(sex1);
        group.add(sex2);

        JLabel label3 = new JLabel("����ѧԺ:");
        label3.setBounds(162,230,160,30);
        label3.setFont(new Font("����",Font.BOLD,18));
        College college = new College();
        JComboBox comboBox = new JComboBox(college.getV1());
        comboBox.setBackground(Color.white);
        comboBox.setBounds(280,230,160,30);
        comboBox.setFont(new Font("����",Font.BOLD,12));

        JLabel label4 = new JLabel("ѧ��(�˺�):");
        label4.setBounds(142,280,160,30);
        label4.setFont(new Font("����",Font.BOLD,18));
        JLabel account = new JLabel(student.getAccount());
        account.setBounds(280,280,300,30);
        account.setFont(new Font("����",Font.BOLD,18));

        JLabel label5 = new JLabel("������:");
        label5.setBounds(180,330,160,30);
        label5.setFont(new Font("����",Font.BOLD,18));
        JPasswordField password1 = new JPasswordField(16);
        password1.setBounds(280,330,300,30);
        password1.setEchoChar('*');
        password1.setFont(new Font("����",Font.BOLD,18));

        JLabel label6 = new JLabel("ȷ��������:");
        label6.setBounds(142,380,160,30);
        label6.setFont(new Font("����",Font.BOLD,18));
        JPasswordField password2 = new JPasswordField(16);
        password2.setBounds(280,380,300,30);
        password2.setEchoChar('*');
        password2.setFont(new Font("����",Font.BOLD,18));

        JButton xiuGaiBt = new JButton("�޸�");
        xiuGaiBt.setBounds(350,450,70,30);
        xiuGaiBt.setFont(new Font("΢���ź�",Font.BOLD,16));
        xiuGaiBt.setBackground(Color.RED);

        JButton fanHuiBt = new JButton("����");
        fanHuiBt.setBounds(420,450,70,30);
        fanHuiBt.setFont(new Font("΢���ź�",Font.BOLD,16));
        fanHuiBt.setBackground(Color.GREEN);


        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        panel1.add(account);
        panel1.add(label5);
        panel1.add(label6);
        panel1.add(name);
        panel1.add(sex1);
        panel1.add(sex2);
        panel1.add(comboBox);
        panel1.add(account);
        panel1.add(password1);
        panel1.add(password2);
        panel1.add(xiuGaiBt);
        panel1.add(fanHuiBt);

        panel1.setLayout(null);
        panel1.setBackground(Color.CYAN);
        frame4.add(panel1,BorderLayout.CENTER);
        frame4.setVisible(true);
        frame4.setResizable(false);
        frame4.setBounds(600,200,860,740);
        new GeRenXinXiWindowListener(frame3,frame4,name,sex1,sex2,comboBox,password1,password2,xiuGaiBt,fanHuiBt,account);
    }
}