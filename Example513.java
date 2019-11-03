// ����Ticket1��ʵ��Runnable�ӿ�
class Ticket1 implements Runnable {
	private int tickets = 10;
	public void run() {
		while (true) {
			saleTicket(); // ������Ʊ����
			if (tickets <= 0) { 
				break;
			}
		}
	}
    // ����һ��ͬ������saleTicket()
	private synchronized void saleTicket() {
		if (tickets > 0) {
			try {
				Thread.sleep(10); // �������߳�����10����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "---������Ʊ"
					+ tickets--);
		}
	}
}
public class Example513 {
	public static void main(String[] args) {
		Ticket1 ticket = new Ticket1(); // ����Ticket1����
         // �����������ĸ��߳�
		new Thread(ticket,"�߳�һ").start();
		new Thread(ticket,"�̶߳�").start();
		new Thread(ticket,"�߳���").start();
		new Thread(ticket,"�߳���").start();
	}
}
