package entity;

import java.io.Serializable;
import java.util.HashMap;

public class Student implements Serializable {
    //此类为单纯的学生信息类
    private String name=null;//姓名
    private String account=null;//学号
    private String sex=null;//性别
    private String password=null;//密码
    private String department=null;//学院
    private HashMap<String, Course> courses = new HashMap<String,Course>();//已选课程
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
    public void addCourse(Course course){
        course.setSelectedNum(course.getSelectedNum()+1);
        this.courses.put(course.getName(),course);
    }
    public void decreaseCourse(Course course){
        course.setSelectedNum(course.getSelectedNum()-1);
        this.courses.remove(course.getName());
    }
    public HashMap<String,Course> getCourses(){
        return this.courses;
    }
}
