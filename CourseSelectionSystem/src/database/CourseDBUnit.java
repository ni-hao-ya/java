package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class CourseDBUnit {
	private static CourseDBUnit instance=null;
    private HashMap<String,Course> courses= new HashMap<String,Course>();
    private CourseDBUnit()throws Exception{
//        Course s = new Course();
//        s.setName("Java");
//        s.setTeacher("º÷Œ∞∑Â");
//        s.setSelectedNum(59);
//        s.setLimitSelectionNum(60);
//        courses.put(s.getName(),s);
//        FileOutputStream fos = new FileOutputStream("CourseInformation.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(courses);
//        oos.close();
//        fos.close();
        FileInputStream fis = new FileInputStream("CourseInformation.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        courses = (HashMap<String ,Course>)ois.readObject();
        fis.close();
        ois.close();
    }

    public void addCourse(Course course)throws Exception{
        courses.put(course.getName(),course);
        FileOutputStream fos = new FileOutputStream("CourseInformation.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(courses);
        oos.close();
        fos.close();
    }
    public HashMap<String ,Course> getCourses(){
        return courses;
    }
    public void setCourses()throws Exception{
        FileOutputStream fos = new FileOutputStream("CourseInformation.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(courses);
        oos.close();
        fos.close();
    }
    public Course getCourse(String number){
        return courses.get(number);
    }
    public static CourseDBUnit getInstance(){
        if(instance==null){
            synchronized (CourseDBUnit.class){
                if(instance==null){
                    try {
                        instance = new CourseDBUnit();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }
}
