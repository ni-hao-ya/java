public class Example503 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();  // ����MyThread��ʵ������    
		Thread thread=new Thread(myThread);  // �����̶߳���
		thread.start();                          // �����̣߳�ִ���߳��е�run()����
		while (true) {
			System.out.println("main()����������");
		 }
	   }
}
class MyThread implements Runnable {
	public void run() {          // �̵߳Ĵ���Σ�������start()����ʱ���̴߳Ӵ˴���ʼִ��
		while (true) {
			System.out.println("MyThread���run()����������");
		}
	}
}
