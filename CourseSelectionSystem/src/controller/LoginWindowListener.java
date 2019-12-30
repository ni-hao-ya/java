package controller;

import entity.Student;
import userService.StudentService;
import view.RegisterGUI;
import view.SelectionCourseGUI;
import view.GuanLiYuanLoginGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;

public class LoginWindowListener {
    //��¼���水ť������
    private StudentService ss = new StudentService();
    final RegisterGUI registerGUI=new RegisterGUI();
    private Student student = new Student();

    public LoginWindowListener(JFrame frame1,JTextField textField,JPasswordField passwdField,JButton LoginBt,JButton ExitBt,JButton RegisterBt,JButton GuanLiYuanBt){
        LoginBt.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String s =  ss.login(textField.getText(),new String (passwdField.getPassword()));
                JDialog jDialog = new JDialog(frame1,"ϵͳ��ʾ!");
                JLabel l = new JLabel(s);
                l.setFont(new Font("΢���ź�",Font.BOLD,12));
                JButton trueBt = new JButton("ȷ��");
                trueBt.setBackground(Color.orange);
                trueBt.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jDialog.dispose();
                        if(s.equals("��¼�ɹ�")){
                            //����ѡ�ν���
                            new SelectionCourseGUI(frame1,ss.getStudent(textField.getText()));
                        }
                    }
                });
                jDialog.setBounds(900,500,200,100);
                jDialog.setModal(true);
                jDialog.setLayout(new FlowLayout());
                jDialog.add(l);
                jDialog.add(trueBt);
                jDialog.setResizable(false);
                jDialog.setVisible(true);
            }
        });
        ExitBt.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        RegisterBt.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                registerGUI.createRegisterGUI(frame1);
            }
        });
        GuanLiYuanBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                new GuanLiYuanLoginGUI(frame1);
            }
        });
    }
}
