package controller;

import userService.StudentService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;

public class MyWindowListener{

    private String account;
    private String password;
    private static MyWindowListener mwl=new MyWindowListener();
    private JTextField textField;
    private JPasswordField passwdField;

    public String getAccount(){
        return this.account;
    }
    protected void setAccount(String account){
        this.account = account;
    }
    public String getPassword(){
        return this.password;
    }
    protected void setPassword(String password){
        this.password = password;
    }
    public MyWindowListener(){}
    public MyWindowListener(JTextField textField){
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mwl.setAccount(textField.getText());
                System.out.println(mwl.getAccount()+"   zs");
            }
        });
    }
    public MyWindowListener(JPasswordField passwdField){
        passwdField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                char [] value = passwdField.getPassword();
//                String password = new String (value);
//                new MyWindowListener().setPassword(password);
                mwl.setPassword(new String (passwdField.getPassword()));
            }
        });
    }
    public MyWindowListener(JButton bt,String name){
        StudentService ss = new StudentService();
        switch (name){
            case "登录":
                bt.addActionListener(new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        String s =  ss.login(mwl.getAccount(),mwl.getPassword());
                        System.out.println(s);
                    }
                });
                break;
            case "注册":
                bt.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ss.register(account,password);
                    }
                });
                break;
            default:
                System.out.println("异常错误!");
                break;
        }
    }
}
