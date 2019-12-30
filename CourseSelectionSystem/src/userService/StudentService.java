package userService;


import entity.Student;
import database.StudentDBUnit;

import java.io.Serializable;

public class StudentService implements Serializable {
    //ѧ������
    private static StudentDBUnit studentDBUnit = StudentDBUnit.getInstance();
    private Student student;
    public String login(String account,String password){//��¼����
        student = studentDBUnit.getUser(account);
        if(student!=null){
            if(account.equals(student.getAccount())&&password.equals(student.getPassword())){
                return "��¼�ɹ�";
            }
            return "������˺Ŵ���";
        }
        else return "����δ�ҵ����˺�";
    }
    public void register(Student student){//ע�����
        try {
            studentDBUnit.addUser(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ע��ɹ���");
    }
    public String panDuanAccount(String account){//����ע��ʱ�ж�ѧ��
        student = studentDBUnit.getUser(account);
        if(student!=null)return "�˺��Ѵ���";
        if(account.length()!=9){
            return "�Ƿ�ѧ��";
        } else{
            char [] chars = account.toCharArray();
            for(int i = 0;i<account.length();i++){
                if(chars[i]>'9'||chars[i]<'0'){
                    return "���ַǷ��ַ�";
                }
            }
        }
        return "�ϸ�";
    }
    public Student getStudent(String account){
        return studentDBUnit.getUser(account);
    }
    public void xiuGaiGeRenXinXi(Student student){//�޸ĸ�����Ϣ
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
