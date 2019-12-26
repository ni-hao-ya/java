package userService;

import database.Student;
import database.StudentDBUnit;

import java.io.Serializable;

public class StudentService implements Serializable {
    private static StudentDBUnit studentDBUnit = StudentDBUnit.getInstance();
    private Student student;
    public String login(String account,String password){
        student = studentDBUnit.getUser(account);
        if(student!=null){
            if(account.equals(student.getAccount())&&password.equals(student.getPassword())){
                return "登录成功";
            }
            return "密码或账号错误";
        }
        else return "错误，未找到该账号";
    }
    public void register(String account,String password){
        student = new Student();
        student.setAccount(account);
        student.setPassword(password);
        student.setSex("男");
        student.setDepartment("软件学院");
        student.setName("盐行动");
        try {
            studentDBUnit.addUser(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("注册成功！");
    }
}
