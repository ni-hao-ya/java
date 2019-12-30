package view;

import entity.Course;
import entity.Student;
import controller.tuiXuanCourseWindowListener;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class tuiXuanCourseGUI {
    JFrame frame5 = new JFrame("��ѡ����");
    JPanel panel = new JPanel();
    JScrollPane jScrollPane = new JScrollPane();
    public tuiXuanCourseGUI(JFrame frame1, JFrame frame3, Student student){
        frame3.setVisible(false);

        frame5.setVisible(true);
        frame5.setResizable(false);
        frame5.setLayout(null);
        frame5.setBounds(600,200,860,740);
        frame5.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0,0,860,300);

        Set keySet = student.getCourses().keySet();
        Iterator it = keySet.iterator();
        int y =30;
        while(it.hasNext()){
            Object key = it.next();
            Course value = student.getCourses().get(key);
            JCheckBox jCheckBox = new JCheckBox("�γ���:"+value.getName()+" �ον�ʦ:"+value.getTeacher()+" ��ѡ����:"+value.getLimitSelectionNum()+" ��ѡ����:"+value.getSelectedNum());
            jCheckBox.setBackground(Color.gray);
            jCheckBox.setBounds(0,y,860,30);
            jCheckBox.setFont(new Font("΢���ź�",Font.BOLD,14));
            panel.add(jCheckBox);
            y+=30;
        }
        JButton button1 = new JButton("�ύ");
        button1.setBounds(300,620,90,30);
        button1.setBackground(Color.RED);
        button1.setFont(new Font("΢���ź�",Font.BOLD,12));

        JButton button2 = new JButton("����");
        button2.setBounds(450,620,90,30);
        button2.setBackground(Color.GREEN);
        button2.setFont(new Font("΢���ź�",Font.BOLD,12));


        jScrollPane.setVisible(true);
        jScrollPane.setLayout(null);
        jScrollPane.setViewportView(panel);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setBackground(Color.GRAY);
        jScrollPane.setBounds(0,0,860,610);

        frame5.add(button1);
        frame5.add(button2);
        frame5.add(panel);
        frame5.add(jScrollPane);

        new tuiXuanCourseWindowListener(student,frame1,frame3,frame5,button1,button2,panel);

    }
}
