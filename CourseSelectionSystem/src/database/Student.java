package database;

import java.io.Serializable;

public class Student implements Serializable {
    //此类为单纯的学生信息类
    private String name=null;//姓名
    private String account=null;//学号
    private String sex=null;//性别
    private String password=null;//密码
    private String department=null;//学院
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAccount(){
        return this.account;
    }
    public void setAccount(String account){
        this.account = account;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepartment() {
        return this.department;
    }
}
