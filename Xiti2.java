public class 	Xiti2  {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();  // 创建MyThread的实例对象    
		Thread thread=new Thread(myThread);  // 创建线程对象
		int i;
		thread.start();                          // 开启线程，执行线程中的run()方法
	for(i=0;i<100;i++) {
			System.out.println("main");			
		 }
	   }
}
class MyThread implements Runnable {
		int j;
	public void run() {          // 线程的代码段，当调用start()方法时，线程从此处开始执行
		for(j=0;j<50;j++) {
				System.out.println("new");
				
			}
		}
}
