package controller;


import entity.Student;
import userService.CourseService;
import view.GeRenXinXiGUI;
import view.tuiXuanCourseGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionCourseWindowListener {
    public SelectionCourseWindowListener(JFrame frame1,JFrame frame3, Student student, JButton button1,JButton button2,JButton button3,JPanel pane2,JButton button4) {
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GeRenXinXiGUI(frame3,student);
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame3.dispose();
                frame1.setVisible(true);
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int flag=0;
                Component [] components=pane2.getComponents();
                for(int i = 0;i<components.length;i++){
                    JCheckBox jCheckBox = (JCheckBox) components[i];
                    if(jCheckBox.isSelected()){
                        flag=1;
                        CourseService cs = new CourseService();
                        String course = jCheckBox.getText();
                        cs.xuanKe(student,cs.getCourse(course));
                    }
                }
                JDialog jDialog = new JDialog(frame3,"系统提示!");
                JLabel l=null;
                if(flag==1)l = new JLabel("提交成功！请重新登录。");
                else l = new JLabel("请选择课程！");
                l.setFont(new Font("微软雅黑",Font.BOLD,12));
                JButton trueBt = new JButton("确定");
                trueBt.setBackground(Color.orange);
                trueBt.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jDialog.dispose();
                    }
                });
                jDialog.setBounds(900,500,250,100);
                jDialog.setModal(true);
                jDialog.setLayout(new FlowLayout());
                jDialog.add(l);
                jDialog.add(trueBt);
                jDialog.setResizable(false);
                jDialog.setVisible(true);
                if(flag==1){
                    frame3.dispose();
                    frame1.setVisible(true);
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new tuiXuanCourseGUI(frame1,frame3,student);


            }
        });
    }
}