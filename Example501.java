public class Example501 {
	public static void main(String[] args) {
		MyThread myThread=new MyThread(); // ����MyThreadʵ������
		myThread.run();  // ����MyThread���run()����
		while (true) {  // ��ѭ����һ����ѭ������ӡ������
			System.out.println("Main����������");
		}
	}
}
class MyThread {
	public void run() {
		while (true) { // ��ѭ����һ����ѭ������ӡ������
			System.out.println("MyThread���run()����������");
		}
	}
}
