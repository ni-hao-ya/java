package controller;

import database.Course;
import userService.CourseService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseGuanLiWindowListener {
    public CourseGuanLiWindowListener(JFrame frame1,JFrame frame2,JPanel panel2,JTextField name,JTextField teacher,JTextField num,JButton deleteBt,JButton tiJiaoBt){
        deleteBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int flag=0;
                Component[] components=panel2.getComponents();
                for(int i = 0;i<components.length;i++){
                    JCheckBox jCheckBox = (JCheckBox) components[i];
                    if(jCheckBox.isSelected()){
                        flag=1;
                        CourseService cs = new CourseService();
                        String course = jCheckBox.getText();
                        cs.deleteCourse(cs.getCourse(course));
                    }
                }
                JDialog jDialog = new JDialog(frame2,"ϵͳ��ʾ!");
                JLabel l=null;
                if(flag==1)l = new JLabel("ɾ���ɹ��������µ�¼��");
                else l = new JLabel("��ѡ��γ̣�");
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
                if(flag==1){
                    frame2.dispose();
                    frame1.setVisible(true);
                }
            }
        });
        tiJiaoBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int flag=1;
                if(name.getText().equals("")||teacher.getText().equals("")||num.getText().equals("")){
                    flag = 0;
                }
                else{
                    Course course = new Course();
                    course.setName(name.getText());
                    course.setTeacher(teacher.getText());
                    course.setLimitSelectionNum(Integer.parseInt(num.getText()));
                    course.setSelectedNum(0);
                    CourseService cs = new CourseService();
                    cs.addCourse(course);
                }
                JDialog jDialog = new JDialog(frame2,"ϵͳ��ʾ!");
                JLabel l=null;
                if(flag==1)l = new JLabel("��ӳɹ��������µ�¼��");
                else l = new JLabel("��������Ϣ��");
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
                if(flag==1){
                    frame2.dispose();
                    frame1.setVisible(true);
                }
            }
        });

    }
}
