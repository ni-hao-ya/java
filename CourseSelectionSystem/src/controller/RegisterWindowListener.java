package controller;

import entity.Student;
import userService.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterWindowListener extends WindowAdapter {
    //ע����水ť������
    JFrame frame1;
    JFrame frame2;
    private  Student student =new Student();
    public RegisterWindowListener(JFrame frame1,JFrame frame2,JTextField name,JRadioButton sex1,JRadioButton sex2,JComboBox comboBox,JTextField account,JPasswordField password1,JPasswordField password2,JButton register ){
        this.frame1 = frame1;
        this.frame2 = frame2;
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentService studentService = new StudentService();
                int flag = 0; int ans = 0;
                String passwd1 = new String (password1.getPassword());
                String passwd2 = new String (password2.getPassword());
                String item = (String) comboBox.getSelectedItem();
                JDialog jDialog = new JDialog(frame1,"ϵͳ��ʾ!");
                JLabel l = null;
                if(!name.getText().equals("")&&!passwd1.equals("")&&!passwd2.equals("")&&(sex1.isSelected()||sex2.isSelected())) {
                    if(studentService.panDuanAccount(account.getText()).equals("�ϸ�")){
                        if(item.equals("��ѡ������ѧԺ")){
                            flag = 1;
                        }
                        else{
                            if(passwd1.equals(passwd2)){
                                student.setName(name.getText());
                                if (sex1.isSelected())student.setSex("��");
                                if (sex2.isSelected())student.setSex("Ů");
                                student.setDepartment(item);
                                student.setAccount(account.getText());
                                student.setPassword(passwd1);
                                studentService.register(student);
                            }
                            else {
                                ans = 1;
                            }
                        }
                    }else{
                        flag = 1;ans = 1;
                    }
                    if(flag ==1 && ans==0){
                        l = new JLabel("��ѡ������ѧԺ��");
                    } else if(flag == 0 && ans == 1){
                        l = new JLabel("�����������벻һ�£�");
                    }else if (flag == 1 && ans == 1){
                        l = new JLabel("�Ƿ�ѧ�ţ����˺��Ѵ���");
                    } else{
                        l = new JLabel("ע��ɹ���");
                    }
                }else{
                    l = new JLabel("������������Ϣ��");
                }
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
                if(l.getText().equals("ע��ɹ���")){
                    frame2.dispose();
                    frame1.setVisible(true);
                }
            }
        });

    }
    public void windowClosing(WindowEvent e) {
        Window window = (Window) e.getComponent();
        window.dispose();
        frame1.setVisible(true);
    }
}
