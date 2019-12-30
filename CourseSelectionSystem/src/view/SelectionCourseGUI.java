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
    JFrame frame3 = new JFrame("选课系统");
    JPanel pane = new JPanel();//此面板为个人信息按钮及切换用户按钮存储面板
    JPanel pane1 = new JPanel();//面板1为已选课程信息存储面板
    JScrollPane scrollPane1  = new JScrollPane();//滚动条面板存储课程信息
    JPanel pane2 = new JPanel();//面板2为可选课程信息存储面板
    JScrollPane scrollPane2  = new JScrollPane();//滚动条面板存储课程信息
    JPanel pane3 = new JPanel();//面板3为所有课程信息存储面板
    JScrollPane scrollPane3  = new JScrollPane();//滚动条面板存储课程信息
    JPanel pane4 = new JPanel();//面板4是存储可选课程标签
    JPanel pane5 = new JPanel();//面板4是存储所有课程标签
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
        pane1.setPreferredSize(new Dimension(1000,770));////如果使用setBounds设置面板大小，就会导致滚动条无效
        pane2.setLayout(null);
        //pane2.setBounds(0,50,1060,200);
        pane2.setPreferredSize(new Dimension(1000,770));////如果使用setBounds设置面板大小，就会导致滚动条无效
        pane3.setLayout(null);
        //pane3.setBounds(0,50,1060,200);
        pane3.setPreferredSize(new Dimension(1000,770));////如果使用setBounds设置面板大小，就会导致滚动条无效
        pane4.setLayout(null);
        pane4.setBackground(Color.LIGHT_GRAY);
        pane4.setBounds(0,280,1060,30);
        pane5.setLayout(null);
        pane5.setBackground(Color.MAGENTA);
        pane5.setBounds(0,510,1060,30);
        frame3.setBounds(500,100,1060,770);
        frame3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("欢迎你,"+student.getName()+"同学");
        label.setBounds(0,0,300,30);
        label.setFont(new Font("楷体",Font.BOLD,18));

        JLabel label1 = new JLabel("已选课程:");
        label1.setBounds(0,50,300,30);
        label1.setFont(new Font("宋体",Font.BOLD,24));

        JButton button1 = new JButton("个人信息");
        button1.setBounds(860,0,100,30);
        button1.setBackground(Color.CYAN);
        button1.setFont(new Font("微软雅黑",Font.BOLD,12));

        JButton button2 = new JButton("切换用户");
        button2.setBounds(960,0,100,30);
        button2.setBackground(Color.orange);
        button2.setFont(new Font("微软雅黑",Font.BOLD,12));

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
            JLabel jLabel = new JLabel("课程名:"+value.getName()+" 任课教师:"+value.getTeacher()+" 限选人数:"+value.getLimitSelectionNum()+" 已选人数:"+value.getSelectedNum());
            jLabel.setFont(new Font("微软雅黑",Font.BOLD,14));
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

        JLabel label2 = new JLabel("可选课程:");
        label2.setFont(new Font("宋体",Font.BOLD,24));
        label2.setBounds(0,0,300,30);

        HashMap<String ,Course> keXuan = cs.getKeXuanCourses(student);
        Set keySet1 = keXuan.keySet();
        Iterator it1 = keySet1.iterator();
        int y1 =0;
        while(it1.hasNext()){
            Object key = it1.next();
            Course value1 = keXuan.get(key);
            JCheckBox jCheckBox = new JCheckBox("课程名:"+value1.getName()+" 任课教师:"+value1.getTeacher()+" 限选人数:"+value1.getLimitSelectionNum()+" 已选人数:"+value1.getSelectedNum());
            jCheckBox.setBounds(100,y1,1060,30);
            jCheckBox.setFont(new Font("微软雅黑",Font.BOLD,14));
            pane2.add(jCheckBox);
            y1+=30;
        }
        JButton button3 = new JButton("提交");
        button3.setBounds(150,0,90,30);
        button3.setBackground(Color.GREEN);
        button3.setFont(new Font("微软雅黑",Font.BOLD,12));

        JButton button4 = new JButton("退选");
        button4.setBounds(250,0,90,30);
        button4.setBackground(Color.RED);
        button4.setFont(new Font("微软雅黑",Font.BOLD,12));

        pane4.add(label2);
        pane4.add(button3);
        pane4.add(button4);

        scrollPane2.setVisible(true);
        //scrollPane2.setLayout(null);
        scrollPane2.setViewportView(pane2);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane2.setBackground(Color.GRAY);
        scrollPane2.setBounds(0,310,1060,200);

        JLabel label3 = new JLabel("所有课程:");
        label3.setFont(new Font("宋体",Font.BOLD,24));
        label3.setBounds(0,0,300,30);

        Set keySet2 = cs.getCourses().keySet();
        Iterator it2 = keySet2.iterator();
        int y2 =0;
        while(it2.hasNext()){
            Object key = it2.next();
            Course value = cs.getCourses().get(key);
            JLabel jLabel = new JLabel("课程名:"+value.getName()+" 任课教师:"+value.getTeacher()+" 限选人数:"+value.getLimitSelectionNum()+" 已选人数:"+value.getSelectedNum());
            jLabel.setFont(new Font("微软雅黑",Font.BOLD,14));
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
