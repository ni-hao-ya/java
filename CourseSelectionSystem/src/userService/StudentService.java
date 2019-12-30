package userService;


import entity.Student;
import database.StudentDBUnit;

import java.io.Serializable;

public class StudentService implements Serializable {
    //学生服务
    private static StudentDBUnit studentDBUnit = StudentDBUnit.getInstance();
    private Student student;
    public String login(String account,String password){//登录操作
        student = studentDBUnit.getUser(account);
        if(student!=null){
            if(account.equals(student.getAccount())&&password.equals(student.getPassword())){
                return "登录成功";
            }
            return "密码或账号错误";
        }
        else return "错误，未找到该账号";
    }
    public void register(Student student){//注册操作
        try {
            studentDBUnit.addUser(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("注册成功！");
    }
    public String panDuanAccount(String account){//用于注册时判断学号
        student = studentDBUnit.getUser(account);
        if(student!=null)return "账号已存在";
        if(account.length()!=9){
            return "非法学号";
        } else{
            char [] chars = account.toCharArray();
            for(int i = 0;i<account.length();i++){
                if(chars[i]>'9'||chars[i]<'0'){
                    return "出现非法字符";
                }
            }
        }
        return "合格";
    }
    public Student getStudent(String account){
        return studentDBUnit.getUser(account);
    }
    public void xiuGaiGeRenXinXi(Student student){//修改个人信息
        this.student = studentDBUnit.getUser(student.getAccount());
        this.student.setName(student.getName());
        this.student.setPassword(student.getPassword());
        this.student.setDepartment(student.getDepartment());
        this.student.setSex(student.getSex());
        try {
            studentDBUnit.setUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
