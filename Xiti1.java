public class Xiti1 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread(); // 创建线程MyThread的线程对象
		myThread.start();                      // 开启线程
			System.out.println("main()方法在运行");
	}
}
class MyThread extends Thread {
	public void run() {
		
			System.out.println("MyThread类的run()方法在运行");
		
	}
}
