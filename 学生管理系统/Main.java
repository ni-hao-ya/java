package 学生管理系统;

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
			System.out.println("添加学生信息");
			addStudent(stuList);
			break;
		case "2":
			System.out.println("删除学生信息");
			deleteStudent(stuList);
			break;
		case "3":
			System.out.println("修改学生信息");
			changeStudent(stuList);
			break;
		case "4":
			System.out.println("查找学生信息");
			findStudent(stuList);
			break;
		case "0":
			System.out.println("谢谢使用");
			System.exit(0);
		

	}}

}

	private static void findStudent(ArrayList<Student> stuList) {
		Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查找的学生的学号：");
        String xuehao = sc.nextLine();
        for (int i = 0; i < stuList.size(); i++) {
            Student s = stuList.get(i);
            if (s.getxuehao().equals(xuehao)) {
            	 System.out.println("学号" + "   " + "姓名" + "    " + "年龄" + "   " + "性别"+" ");
            	
            	 System.out.println(s.getxuehao() + "   \t" + s.getname() + "   \t" + s.getage() + "岁" + "    \t"+s.getxinbie() );
function();
            	 break;
            }
            else{
            	System.out.println("不存在信息");}}
            }
	private static void changeStudent(ArrayList<Student> stuList) {
		Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号：");
        String xuehao = sc.nextLine();
        for (int i = 0; i < stuList.size(); i++) {
            Student s = stuList.get(i);
            if (s.getxuehao().equals(xuehao)) {
                System.out.println("请输入学生的新姓名：");
                String name = sc.nextLine();
                System.out.println("请输入学生的新年龄：");
                int age = sc.nextInt();
                System.out.println("请输入学生的性别：");
                String xinbie = sc.nextLine();
                Student a = new Student();
                a.setxuehao(xuehao);
                a.setname(name);
                a.setage(age);
             
                stuList.set(i, a);//将新的学生信息交给集合
                System.out.println("修改学生成功！");
                function();
                return;
            }
        }
        System.out.println("未找到要修改的学生！");//找不到要修改的学生
    }

	private static void deleteStudent(ArrayList<Student> stuList) {
		// TODO 自动生成的方法存根
		 Scanner sc = new Scanner(System.in);
	        System.out.println("请输入你要删除的学生的学号：");
	        String xuehao = sc.nextLine();
	        for (int i = 0; i < stuList.size(); i++) {
	            Student s = stuList.get(i);
	            if (s.getxuehao().equals(xuehao)) {
	            	stuList.remove(i);
	                System.out.println(s.getname() + "同学已被删除成功！");
	                function();
	                return;
	            }
	        }
	        System.out.println("没有找到你要删除的学生！！！");//输错学号找不到学生机制
	    }

	


	private static void addStudent(ArrayList<Student> stuList) {
		// TODO 自动生成的方法存根
		String xuehao;
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("请输入学生的学号：");
			xuehao=sc.nextLine();
			boolean flag=isUsed(stuList,xuehao);
			if(flag) {
				System.out.println("你输入的学号重复，请重新输入");
				
			}else {
				
				
				break;
			}
			
		}
		System.out.println("请输入学生的姓名：");
		String name=sc.nextLine();
		System.out.println("请输入学生的年龄：");
		int age=sc.nextInt();
		System.out.println("请输入学生性别：");
		String xinbie=sc.nextLine();
		//创建学生对象
		Student s=new Student();
		s.setname(name);
		s.setage(age);
		s.setxinbie(xinbie);
		s.setxuehao(xuehao);
		stuList.add(s);
		System.out.println("添加成功");
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
	System.out.println("\t\t学生管理系统");

	System.out.println("\t[1] 添加学生信息");
	System.out.println("\t[2] 删除学生信息");
	System.out.println("\t[3] 修改学生信息");
	System.out.println("\t[4] 查找学生信息");
	System.out.println("\t[0]  退出系统");
	System.out.println("***********************************************************************************");
	System.out.println("请选择：");
}}