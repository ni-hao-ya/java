public class Example511 {
	public static void main(String[] args) {
		SaleThread saleThread = new SaleThread(); // ����Ticket1 ����
		// �����������ĸ��߳�
		new Thread(saleThread, "�߳�һ").start();
		new Thread(saleThread, "�̶߳�").start();
		new Thread(saleThread, "�߳���").start();
		new Thread(saleThread, "�߳���").start();
	   }
}
// ����Ticket1��ʵ��Runnable�ӿ�
class SaleThread implements Runnable {
	private int tickets = 10; // 10��Ʊ
	public void run() {
		while (tickets > 0) {
			try {
				Thread.sleep(10); // �����˴����߳�����10����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "---������Ʊ"
					+ tickets--);
		}
	}
}
