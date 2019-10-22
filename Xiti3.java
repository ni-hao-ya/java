public class Xiti3{
	public static void main(String[] args) {
		teacher tw = new teacher();
		new Thread(tw, "teacher1").start();     
		new Thread(tw, "teacher2").start();      
		new Thread(tw, "teacher3").start();  
	}
}
class teacher implements Runnable {
	private int notebook = 80;

	public void run() {
		while (true) {
			if (notebook > 0) {
				Thread th = Thread.currentThread(); 
				String th_name = th.getName(); 
				System.out.println(th_name + "  " + notebook-- + "    Notebook");
			}
		}
	}
}
