package zuoye;
import java.util.ArrayList;
import java.util.Random;



public class Storage {
	private int[] cells=new int[10];
	private int inpos,outpos;

    int count=0;
	public synchronized void put(int r2){
		try{
			while(count==cells.length){
				this.wait();
			}
		
		
	
		 cells[inpos]= r2;
		 String s=String.valueOf(cells[inpos]);
	
		System.out.println(s+"用户登录");
		inpos++;
		if(inpos==cells.length)
			inpos=0;
			 count++;
		this.notify();
		
	}catch(Exception e){
		e.printStackTrace();
	}}
	public synchronized void get(){
		try{
			while(count==0){
				this.wait();
			}
	int data=cells[outpos];
	String t=String.valueOf(cells[outpos]);
	System.out.println(t+"用户注销");
	System.out.println("系统在线人数"+count);
	cells[outpos]=0;
	outpos++;
	if(outpos==cells.length)
		outpos=0;
	count--;
	this.notify();
	}catch(Exception e){
		e.printStackTrace();
	}
}}
	