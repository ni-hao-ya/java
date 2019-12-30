package view;

import controller.SelectionCourseWindowListener;
import database.Course;
import database.Student;
import userService.CourseService;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SelectionCourseGUI {

    CourseService cs = new CourseService();

    JFrame frame1;
    JFrame frame3 = new JFrame("ѡ��ϵͳ");
    JPanel pane = new JPanel();//�����Ϊ������Ϣ��ť���л��û���ť�洢���
    JPanel pane1 = new JPanel();//���1Ϊ��ѡ�γ���Ϣ�洢���
    JScrollPane scrollPane1  = new JScrollPane();//���������洢�γ���Ϣ
    JPanel pane2 = new JPanel();//���2Ϊ��ѡ�γ���Ϣ�洢���
    JScrollPane scrollPane2  = new JScrollPane();//���������洢�γ���Ϣ
    JPanel pane3 = new JPanel();//���3Ϊ���пγ���Ϣ�洢���
    JScrollPane scrollPane3  = new JScrollPane();//���������洢�γ���Ϣ
    JPanel pane4 = new JPanel();//���4�Ǵ洢��ѡ�γ̱�ǩ
    JPanel pane5 = new JPanel();//���4�Ǵ洢���пγ̱�ǩ
    public SelectionCourseGUI(JFrame frame1, Student student){
        this.frame1 = frame1;
        this.frame1.setVisible(false);
        frame3.setVisible(true);
        frame3.setResizable(false);
        frame3.setLayout(null);
        frame3.setBackground(Color.GRAY);
        pane.setLayout(null);
        pane.setBackground(Color.PINK);
        pane.setBounds(0,0,1060,80);
        pane1.setLayout(null);
       // pane1.setBounds(0,0,1060,200);
        pane1.setPreferredSize(new Dimension(1000,770));////���ʹ��setBounds��������С���ͻᵼ�¹�������Ч
        pane2.setLayout(null);
        //pane2.setBounds(0,50,1060,200);
        pane2.setPreferredSize(new Dimension(1000,770));////���ʹ��setBounds��������С���ͻᵼ�¹�������Ч
        pane3.setLayout(null);
        //pane3.setBounds(0,50,1060,200);
        pane3.setPreferredSize(new Dimension(1000,770));////���ʹ��setBounds��������С���ͻᵼ�¹�������Ч
        pane4.setLayout(null);
        pane4.setBackground(Color.LIGHT_GRAY);
        pane4.setBounds(0,280,1060,30);
        pane5.setLayout(null);
        pane5.setBackground(Color.MAGENTA);
        pane5.setBounds(0,510,1060,30);
        frame3.setBounds(500,100,1060,770);
        frame3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("��ӭ��,"+student.getName()+"ͬѧ");
        label.setBounds(0,0,300,30);
        label.setFont(new Font("����",Font.BOLD,18));

        JLabel label1 = new JLabel("��ѡ�γ�:");
        label1.setBounds(0,50,300,30);
        label1.setFont(new Font("����",Font.BOLD,24));

        JButton button1 = new JButton("������Ϣ");
        button1.setBounds(860,0,100,30);
        button1.setBackground(Color.CYAN);
        button1.setFont(new Font("΢���ź�",Font.BOLD,12));

        JButton button2 = new JButton("�л��û�");
        button2.setBounds(960,0,100,30);
        button2.setBackground(Color.orange);
        button2.setFont(new Font("΢���ź�",Font.BOLD,12));

        pane.add(label);
        pane.add(label1);
        pane.add(button1);
        pane.add(button2);

        Set keySet = student.getCourses().keySet();
        Iterator it = keySet.iterator();
        int y =0;
        while(it.hasNext()){
            Object key = it.next();
            Course value = student.getCourses().get(key);
            JLabel jLabel = new JLabel("�γ���:"+value.getName()+" �ον�ʦ:"+value.getTeacher()+" ��ѡ����:"+value.getLimitSelectionNum()+" ��ѡ����:"+value.getSelectedNum());
            jLabel.setFont(new Font("΢���ź�",Font.BOLD,14));
            jLabel.setBounds(100,y,1060,30);
            pane1.add(jLabel);
            y+=30;
        }
        scrollPane1.setVisible(true);
        //scrollPane1.setLayout(null);
        //pane1.setBackground(Color.PINK);
        scrollPane1.setViewportView(pane1);
        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane1.setBackground(Color.GRAY);
        scrollPane1.setBounds(0,80,1060,200);

        JLabel label2 = new JLabel("��ѡ�γ�:");
        label2.setFont(new Font("����",Font.BOLD,24));
        label2.setBounds(0,0,300,30);

        HashMap<String ,Course> keXuan = cs.getKeXuanCourses(student);
        Set keySet1 = keXuan.keySet();
        Iterator it1 = keySet1.iterator();
        int y1 =0;
        while(it1.hasNext()){
            Object key = it1.next();
            Course value1 = keXuan.get(key);
            JCheckBox jCheckBox = new JCheckBox("�γ���:"+value1.getName()+" �ον�ʦ:"+value1.getTeacher()+" ��ѡ����:"+value1.getLimitSelectionNum()+" ��ѡ����:"+value1.getSelectedNum());
            jCheckBox.setBounds(100,y1,1060,30);
            jCheckBox.setFont(new Font("΢���ź�",Font.BOLD,14));
            pane2.add(jCheckBox);
            y1+=30;
        }
        JButton button3 = new JButton("�ύ");
        button3.setBounds(150,0,90,30);
        button3.setBackground(Color.GREEN);
        button3.setFont(new Font("΢���ź�",Font.BOLD,12));

        JButton button4 = new JButton("��ѡ");
        button4.setBounds(250,0,90,30);
        button4.setBackground(Color.RED);
        button4.setFont(new Font("΢���ź�",Font.BOLD,12));

        pane4.add(label2);
        pane4.add(button3);
        pane4.add(button4);

        scrollPane2.setVisible(true);
        //scrollPane2.setLayout(null);
        scrollPane2.setViewportView(pane2);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane2.setBackground(Color.GRAY);
        scrollPane2.setBounds(0,310,1060,200);

        JLabel label3 = new JLabel("���пγ�:");
        label3.setFont(new Font("����",Font.BOLD,24));
        label3.setBounds(0,0,300,30);

        Set keySet2 = cs.getCourses().keySet();
        Iterator it2 = keySet2.iterator();
        int y2 =0;
        while(it2.hasNext()){
            Object key = it2.next();
            Course value = cs.getCourses().get(key);
            JLabel jLabel = new JLabel("�γ���:"+value.getName()+" �ον�ʦ:"+value.getTeacher()+" ��ѡ����:"+value.getLimitSelectionNum()+" ��ѡ����:"+value.getSelectedNum());
            jLabel.setFont(new Font("΢���ź�",Font.BOLD,14));
            jLabel.setBounds(100,y2,1060,30);
            pane3.add(jLabel);
            y2+=30;
        }
        pane5.add(label3);
        scrollPane3.setVisible(true);
        //scrollPane3.setLayout(null);
        scrollPane3.setViewportView(pane3);
        scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane3.setBackground(Color.GRAY);
        scrollPane3.setBounds(0,540,1060,200);



        frame3.add(pane);
        //frame3.add(pane2);
        frame3.add(pane4);
        frame3.add(pane5);
        frame3.add(scrollPane1);
        frame3.add(scrollPane2);
        frame3.add(scrollPane3);

        new SelectionCourseWindowListener(frame1,frame3,student,button1,button2,button3,pane2,button4);
    }


}
