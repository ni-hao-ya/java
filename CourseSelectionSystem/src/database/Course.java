package database;

import java.io.Serializable;

public class Course implements Serializable{
	//����Ϊ�����Ŀγ���Ϣ��
	private String name;
	private int limitSelectionNum;//��ѡ
	private int selectedNum;  //��ѡ
	private String teacher;//�ον�ʦ
	public String getName(){return this.name;}
	public void setName(String name){this.name = name;}
	public int getLimitSelectionNum(){
		return this.limitSelectionNum;
	}
	public void setLimitSelectionNum(int limitSelectionNum){
		this.limitSelectionNum = limitSelectionNum;
	}
	public int getSelectedNum(){
		return this.selectedNum;
	}
	public void setSelectedNum(int selectedNum){
		this.selectedNum = selectedNum;
	}
	public String getTeacher(){
		return this.teacher;
	}
	public void setTeacher(String teacher){
		this.teacher = teacher;
	}

}
