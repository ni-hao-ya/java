package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class StudentDBUnit {
    private static StudentDBUnit instance=null;
    private HashMap<String ,Student> users= new HashMap<String,Student>();
    private StudentDBUnit()throws Exception{
//        users.put("137825265",new Student());
//        FileOutputStream fos = new FileOutputStream("StudentInformation.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(users);
//        oos.close();
//        fos.close();
        FileInputStream fis = new FileInputStream("StudentInformation.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        users = (HashMap<String ,Student>)ois.readObject();
        fis.close();
        ois.close();
    }
//    public HashMap<String ,Student> getUsers(){
//        return users;
//    }
    public void addUser(Student student)throws Exception{
        users.put(student.getAccount(),student);
        FileOutputStream fos = new FileOutputStream("StudentInformation.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();
        fos.close();
    }
    public Student getUser(String account){
        return users.get(account);
    }
    public static StudentDBUnit getInstance(){
        if(instance==null){
            synchronized (StudentDBUnit.class){
                if(instance==null){
                    try {
                        instance = new StudentDBUnit();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }
}
