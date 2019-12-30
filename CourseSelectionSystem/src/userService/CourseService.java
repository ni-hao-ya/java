package userService;

import database.Course;
import database.CourseDBUnit;
import database.Student;
import database.StudentDBUnit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CourseService {
    private static CourseDBUnit courseDBUnit =  CourseDBUnit.getInstance();
    private static StudentDBUnit studentDBUnit = StudentDBUnit.getInstance();
    private Student student;
    public HashMap<String,Course> getCourses(){
        return courseDBUnit.getCourses();
    }
    public HashMap<String,Course> getKeXuanCourses(Student student){
        HashMap<String, Course> keXuan = new HashMap<String, Course>();
        HashMap<String, Course> yiXuan = student.getCourses();
        HashMap<String, Course> allCourses = courseDBUnit.getCourses();
        Set keySet = allCourses.keySet();
        Iterator it = keySet.iterator();
        while(it.hasNext()){
            Object key = it.next();
            if(yiXuan.get(key)==null){
                Course value = allCourses.get(key);
                if(value.getLimitSelectionNum()>value.getSelectedNum()){
                    keXuan.put(value.getName(),value);
                }
            }
        }
        return keXuan;
    }
    public Course getCourse(String course){
        Course course1 = new Course();
        String [] strArray = course.split(" ");
        for(int i=0;i<strArray.length;i++){
            if(i==0){
                course1.setName(strArray[i].substring(4));
            }else if (i==1){
                course1.setTeacher(strArray[i].substring(5));
            }else if(i==2){
                course1.setLimitSelectionNum(Integer.parseInt(strArray[i].substring(5)));
            }else if(i==3){
                course1.setSelectedNum(Integer.parseInt(strArray[i].substring(5)));
            }
        }
        return course1;
    }
    public void tuiXuan(Student student,Course course){//退选操作
        this.student = studentDBUnit.getUser(student.getAccount());
        this.student.decreaseCourse(course);
        courseDBUnit.getCourse(course.getName()).setSelectedNum(courseDBUnit.getCourse(course.getName()).getSelectedNum()-1);
        try {
            studentDBUnit.setUsers();
            courseDBUnit.setCourses();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void xuanKe(Student student,Course course){//选课操作
        this.student = studentDBUnit.getUser(student.getAccount());
        this.student.addCourse(course);
        courseDBUnit.getCourse(course.getName()).setSelectedNum(courseDBUnit.getCourse(course.getName()).getSelectedNum()+1);
        try {
            studentDBUnit.setUsers();
            courseDBUnit.setCourses();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteCourse(Course course){
        courseDBUnit.getCourses().remove(course.getName());
        HashMap users= studentDBUnit.getUsers();
        Set keySet = users.keySet();
        Iterator it = keySet.iterator();
        while(it.hasNext()){
            Object key = it.next();
            this.student = (Student) users.get(key);
            if(this.student.getCourses().get(course.getName())!=null){
                this.student.getCourses().remove(course.getName());
            }
        }
        try {
            studentDBUnit.setUsers();
            courseDBUnit.setCourses();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addCourse(Course course){
        try {
            courseDBUnit.addCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
