package ѧ������ϵͳ;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Student> stuList=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		function();
		while(true) {
		String line=sc.next();
		switch(line) {
		case "1":
			System.out.println("���ѧ����Ϣ");
			addStudent(stuList);
			break;
		case "2":
			System.out.println("ɾ��ѧ����Ϣ");
			deleteStudent(stuList);
			break;
		case "3":
			System.out.println("�޸�ѧ����Ϣ");
			changeStudent(stuList);
			break;
		case "4":
			System.out.println("����ѧ����Ϣ");
			findStudent(stuList);
			break;
		case "0":
			System.out.println("ллʹ��");
			System.exit(0);
		

	}}

}

	private static void findStudent(ArrayList<Student> stuList) {
		Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫ���ҵ�ѧ����ѧ�ţ�");
        String xuehao = sc.nextLine();
        for (int i = 0; i < stuList.size(); i++) {
            Student s = stuList.get(i);
            if (s.getxuehao().equals(xuehao)) {
            	 System.out.println("ѧ��" + "   " + "����" + "    " + "����" + "   " + "�Ա�"+" ");
            	
            	 System.out.println(s.getxuehao() + "   \t" + s.getname() + "   \t" + s.getage() + "��" + "    \t"+s.getxinbie() );
function();
            	 break;
            }
            else{
            	System.out.println("��������Ϣ");}}
            }
	private static void changeStudent(ArrayList<Student> stuList) {
		Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫ�޸ĵ�ѧ����ѧ�ţ�");
        String xuehao = sc.nextLine();
        for (int i = 0; i < stuList.size(); i++) {
            Student s = stuList.get(i);
            if (s.getxuehao().equals(xuehao)) {
                System.out.println("������ѧ������������");
                String name = sc.nextLine();
                System.out.println("������ѧ���������䣺");
                int age = sc.nextInt();
                System.out.println("������ѧ�����Ա�");
                String xinbie = sc.nextLine();
                Student a = new Student();
                a.setxuehao(xuehao);
                a.setname(name);
                a.setage(age);
             
                stuList.set(i, a);//���µ�ѧ����Ϣ��������
                System.out.println("�޸�ѧ���ɹ���");
                function();
                return;
            }
        }
        System.out.println("δ�ҵ�Ҫ�޸ĵ�ѧ����");//�Ҳ���Ҫ�޸ĵ�ѧ��
    }

	private static void deleteStudent(ArrayList<Student> stuList) {
		// TODO �Զ����ɵķ������
		 Scanner sc = new Scanner(System.in);
	        System.out.println("��������Ҫɾ����ѧ����ѧ�ţ�");
	        String xuehao = sc.nextLine();
	        for (int i = 0; i < stuList.size(); i++) {
	            Student s = stuList.get(i);
	            if (s.getxuehao().equals(xuehao)) {
	            	stuList.remove(i);
	                System.out.println(s.getname() + "ͬѧ�ѱ�ɾ���ɹ���");
	                function();
	                return;
	            }
	        }
	        System.out.println("û���ҵ���Ҫɾ����ѧ��������");//���ѧ���Ҳ���ѧ������
	    }

	


	private static void addStudent(ArrayList<Student> stuList) {
		// TODO �Զ����ɵķ������
		String xuehao;
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("������ѧ����ѧ�ţ�");
			xuehao=sc.nextLine();
			boolean flag=isUsed(stuList,xuehao);
			if(flag) {
				System.out.println("�������ѧ���ظ�������������");
				
			}else {
				
				
				break;
			}
			
		}
		System.out.println("������ѧ����������");
		String name=sc.nextLine();
		System.out.println("������ѧ�������䣺");
		int age=sc.nextInt();
		System.out.println("������ѧ���Ա�");
		String xinbie=sc.nextLine();
		//����ѧ������
		Student s=new Student();
		s.setname(name);
		s.setage(age);
		s.setxinbie(xinbie);
		s.setxuehao(xuehao);
		stuList.add(s);
		System.out.println("��ӳɹ�");
		function();
		
		
	}public static boolean isUsed(ArrayList<Student> stuList, String xuehao) {
		boolean flag=false;
		for(int i=0;i<stuList.size();i++) {
			Student s1=stuList.get(i);
			 if (s1.getxuehao().equals(xuehao)) {
				 flag=true;
			 }
		
	}
		return flag;

	}

static void function() {
	System.out.println("***********************************************************************************");
	System.out.println("\t\tѧ������ϵͳ");

	System.out.println("\t[1] ���ѧ����Ϣ");
	System.out.println("\t[2] ɾ��ѧ����Ϣ");
	System.out.println("\t[3] �޸�ѧ����Ϣ");
	System.out.println("\t[4] ����ѧ����Ϣ");
	System.out.println("\t[0]  �˳�ϵͳ");
	System.out.println("***********************************************************************************");
	System.out.println("��ѡ��");
}}