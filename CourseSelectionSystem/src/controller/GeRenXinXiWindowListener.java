package controller;

import database.Student;
import userService.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GeRenXinXiWindowListener extends WindowAdapter {
    JFrame frame3;
    Student student = new Student();
    public GeRenXinXiWindowListener(JFrame frame3, JFrame frame4, JTextField name, JRadioButton sex1, JRadioButton sex2, JComboBox comboBox, JPasswordField password1, JPasswordField password2, JButton xiuGaiBt,JButton fanHuiBt,JLabel account){
        this.frame3 = frame3;

        xiuGaiBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentService studentService = new StudentService();
                int flag = 0; int ans = 0;
                String passwd1 = new String (password1.getPassword());
                String passwd2 = new String (password2.getPassword());
                String item = (String) comboBox.getSelectedItem();
                JDialog jDialog = new JDialog(frame4,"系统提示!");
                JLabel l = null;
                if(!name.getText().equals("")&&!passwd1.equals("")&&!passwd2.equals("")&&(sex1.isSelected()||sex2.isSelected())) {
                        if(item.equals("请选择所属学院")){
                            flag = 1;
                        }
                        else{
                            if(passwd1.equals(passwd2)){
                                student.setAccount(account.getText());
                                student.setName(name.getText());
                                if (sex1.isSelected())student.setSex("男");
                                if (sex2.isSelected())student.setSex("女");
                                student.setDepartment(item);
                                student.setPassword(passwd1);
                                studentService.xiuGaiGeRenXinXi(student);
                            }
                            else {
                                ans = 1;
                            }
                        }
                    if(flag ==1 && ans==0){
                        l = new JLabel("请选择所属学院！");
                    } else if(flag == 0 && ans == 1){
                        l = new JLabel("两次输入密码不一致！");
                    } else{
                        l = new JLabel("修改成功！请点击切换用户重新登录！");
                    }
                }else{
                    l = new JLabel("请完善所有信息！");
                }
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
                if(l.getText().equals("修改成功！请点击切换用户重新登录！")){
                    frame4.dispose();
                    frame3.setVisible(true);
                }
            }
        });
        fanHuiBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame4.dispose();
                frame3.setVisible(true);
            }
        });
    }
    public void windowClosing(WindowEvent e) {
        Window window = (Window) e.getComponent();
        window.dispose();
        frame3.setVisible(true);
    }
}
