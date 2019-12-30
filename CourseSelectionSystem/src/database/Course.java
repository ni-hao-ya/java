package database;

import java.io.Serializable;

public class Course implements Serializable{
	//此类为单纯的课程信息类
	private String name;
	private int limitSelectionNum;//限选
	private int selectedNum;  //已选
	private String teacher;//任课教师
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
