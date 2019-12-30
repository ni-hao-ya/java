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
                    //调用课程信息管理界面
                    new CourseGuanLiGUI(frame1);
                }
                else{
                    JDialog jDialog = new JDialog(frame1,"系统提示!");
                    JLabel l = new JLabel("密码或账号错误！");
                    l.setFont(new Font("微软雅黑",Font.BOLD,12));
                    JButton trueBt = new JButton("确定");
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
