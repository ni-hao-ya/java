package controller;

import entity.Student;
import userService.CourseService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tuiXuanCourseWindowListener {
    public tuiXuanCourseWindowListener(Student student,JFrame frame1,JFrame frame3,JFrame frame5,JButton button1,JButton button2,JPanel panel){
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Component[] components=panel.getComponents();
                for(int i = 0;i<components.length;i++){
                    JCheckBox jCheckBox = (JCheckBox) components[i];
                    if(jCheckBox.isSelected()){
                        CourseService cs = new CourseService();
                        String course = jCheckBox.getText();
                        cs.tuiXuan(student,cs.getCourse(course));
                    }
                }
                JDialog jDialog = new JDialog(frame3,"ϵͳ��ʾ!");
                JLabel l = new JLabel("�ύ�ɹ��������µ�¼��");
                l.setFont(new Font("΢���ź�",Font.BOLD,12));
                JButton trueBt = new JButton("ȷ��");
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
                frame5.dispose();
                frame1.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame5.dispose();
                frame3.setVisible(true);
            }
        });



    }
}
