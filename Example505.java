public class Example505 {
	public static void main(String[] args) {
		TicketWindow tw = new TicketWindow(); // ����TicketWindowʵ������tw
		new Thread(tw, "����1").start();      // �����̶߳�������Ϊ����1�������߳�
		new Thread(tw, "����2").start();      // �����̶߳�������Ϊ����2�������߳�
		new Thread(tw, "����3").start();      // �����̶߳�������Ϊ����3�������߳�
		new Thread(tw, "����4").start();      // �����̶߳�������Ϊ����4�������߳�
	}
}
class TicketWindow implements Runnable {
	private int tickets = 100;

	public void run() {
		while (true) {
			if (tickets > 0) {
				Thread th = Thread.currentThread(); // ��ȡ��ǰ�߳�
				String th_name = th.getName(); // ��ȡ��ǰ�̵߳�����
				System.out.println(th_name + " ���ڷ��۵� " + tickets-- + " ��Ʊ ");
			}
		}
	}
}
