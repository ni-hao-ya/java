package controller;


import view.CourseGuanLiGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuanLiYuanLoginWindowListener {
    public GuanLiYuanLoginWindowListener(JFrame frame,JFrame frame1, JTextField textField, JPasswordField passwdField, JButton LoginBt, JButton ExitBt){

        LoginBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().equals("root")&&"123456".equals(new String (passwdField.getPassword()))){
                    //���ÿγ���Ϣ�������
                    new CourseGuanLiGUI(frame1);
                }
                else{
                    JDialog jDialog = new JDialog(frame1,"ϵͳ��ʾ!");
                    JLabel l = new JLabel("������˺Ŵ���");
                    l.setFont(new Font("΢���ź�",Font.BOLD,12));
                    JButton trueBt = new JButton("ȷ��");
                    trueBt.setBackground(Color.orange);
                    trueBt.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            jDialog.dispose();
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
            }
        });
        ExitBt.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frame1.dispose();
            }
        });
    }
}
