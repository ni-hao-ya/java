package zuoye;

import java.util.Random;

class Input implements Runnable{
private Storage st;
private  Random r;
Input(Storage st){
	this.st=st;
}
public void run(){
	while(true){
		Random r=new Random();
		int r2=r.nextInt();
		st.put( r2);
		
	}
}}

