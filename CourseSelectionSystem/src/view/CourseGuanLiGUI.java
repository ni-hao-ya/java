package view;

import controller.CourseGuanLiWindowListener;
import entity.Course;
import userService.CourseService;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class CourseGuanLiGUI {
    CourseService cs = new CourseService();
    JFrame frame2 = new JFrame("课程管理");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JScrollPane jScrollPane = new JScrollPane(panel2);
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();

    public CourseGuanLiGUI(JFrame frame1){
        frame1.setVisible(false);
        frame2.setVisible(true);
        frame2.setLayout(null);
        frame2.setResizable(false);
        frame2.setBounds(500,100,1060,770);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel1.setLayout(null);
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBounds(0,0,1060,30);
        panel2.setLayout(null);
        //panel2.setBounds(0,0,1060,200);
        panel2.setPreferredSize(new Dimension(1000,770));//如果使用setBounds设置面板大小，就会导致滚动条无效
        panel3.setLayout(null);
        panel3.setBackground(Color.cyan);
        panel3.setBounds(0,230,1060,30);
        panel4.setLayout(null);
        panel4.setBounds(0,260,1060,200);

        JLabel label1 = new JLabel("所有课程:                                             如需删除课程请勾选并点击删除");
        label1.setFont(new Font("楷体",Font.BOLD,24));
        label1.setBounds(0,0,1060,30);

        panel1.add(label1);

        Set keySet2 = cs.getCourses().keySet();
        Iterator it2 = keySet2.iterator();
        int y2 =0;
        while(it2.hasNext()){
            Object key = it2.next();
            Course value = cs.getCourses().get(key);
            JCheckBox jCheckBox = new JCheckBox("课程名:"+value.getName()+" 任课教师:"+value.getTeacher()+" 限选人数:"+value.getLimitSelectionNum()+" 已选人数:"+value.getSelectedNum());
            jCheckBox.setFont(new Font("微软雅黑",Font.BOLD,14));
            jCheckBox.setBounds(100,y2,1060,30);
            panel2.add(jCheckBox);
            y2+=30;
        }
        //jScrollPane.setViewportView(panel2);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setBounds(0,30,1060,200);

        JLabel label2 = new JLabel("如需添加或更改已有课程信息，请在以下填写课程信息并点击提交");
        label2.setFont(new Font("楷体",Font.BOLD,24));
        label2.setBounds(0,0,1060,30);

        JButton deleteBt = new JButton("删除");
        deleteBt.setFont(new Font("微软雅黑",Font.BOLD,14));
        deleteBt.setBackground(Color.RED);
        deleteBt.setBounds(980,0,70,30);

        panel3.add(label2);
        panel3.add(deleteBt);

        JLabel label3 = new JLabel("课程名：");
        label3.setBounds(300,0,80,30);
        label3.setFont(new Font("宋体",Font.BOLD,18));
        JTextField name = new JTextField(16);
        name.setBounds(420,0,300,30);
        name.setFont(new Font("宋体",Font.BOLD,18));

        JLabel label4 = new JLabel("任课教师：");
        label4.setBounds(280,30,150,30);
        label4.setFont(new Font("宋体",Font.BOLD,18));
        JTextField teacher = new JTextField(16);
        teacher.setBounds(420,30,300,30);
        teacher.setFont(new Font("宋体",Font.BOLD,18));

        JLabel label5 = new JLabel("人数上限：");
        label5.setBounds(280,60,150,30);
        label5.setFont(new Font("宋体",Font.BOLD,18));
        JTextField num = new JTextField(16);
        num.setBounds(420,60,300,30);
        num.setFont(new Font("宋体",Font.BOLD,18));

        JButton tiJiaoBt = new JButton("提交");
        tiJiaoBt.setFont(new Font("微软雅黑",Font.BOLD,14));
        tiJiaoBt.setBackground(Color.GREEN);
        tiJiaoBt.setBounds(500,90,70,30);

        panel4.add(label3);
        panel4.add(label4);
        panel4.add(label5);
        panel4.add(name);
        panel4.add(teacher);
        panel4.add(num);
        panel4.add(tiJiaoBt);

        frame2.add(panel1);
        frame2.add(panel3);
        frame2.add(panel4);
        frame2.add(jScrollPane);

        new CourseGuanLiWindowListener(frame1,frame2,panel2,name,teacher,num,deleteBt,tiJiaoBt);
    }
}
