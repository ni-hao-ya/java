public class Example502 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread(); // �����߳�MyThread���̶߳���
		myThread.start();                      // �����߳�
		while (true) {                          // ͨ����ѭ������ӡ���
			System.out.println("main()����������");
		}
	}
}
class MyThread extends Thread {
	public void run() {
		while (true) {    // ͨ����ѭ������ӡ���
			System.out.println("MyThread���run()����������");
		}
	}
}
