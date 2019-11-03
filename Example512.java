//����Ticket1��̳�Runnable�ӿ�
class Ticket1 implements Runnable {
	private int tickets = 10; // �������tickets������ֵ10
	Object lock = new Object(); // ��������һ����������ͬ����������
	public void run() {
		while (true) {
			synchronized (lock) { // ����ͬ�������
				try {
					Thread.sleep(10); // �������߳�����10����
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (tickets > 0) {
					System.out.println(Thread.currentThread().getName()
							+ "---������Ʊ" + tickets--);
				} else { // ��� ticketsС��0������ѭ��
					break;
				}
			}
		}
	}
}
public class Example512 {
	public static void main(String[] args) {
		Ticket1 ticket = new Ticket1(); // ����Ticket1����
		// �����������ĸ��߳�
		new Thread(ticket, "�߳�һ").start();
		new Thread(ticket, "�̶߳�").start();
		new Thread(ticket, "�߳���").start();
		new Thread(ticket, "�߳���").start();
	}
}
