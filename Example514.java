class DeadLockThread implements Runnable {
	static Object chopsticks = new Object();    // ����Object���͵�chopsticks������
	static Object knifeAndFork = new Object(); // ����Object���͵�knifeAndFork������
	private boolean flag; // ����boolean���͵ı���flag
	DeadLockThread(boolean flag) { // �����вεĹ��췽��
		this.flag = flag;
	}
	public void run() {
		if (flag) {
			while (true) {
				synchronized (chopsticks) { // chopsticks�������ϵ�ͬ�������
					System.out.println(Thread.currentThread().getName()
							+ "---if---chopsticks"); 
					synchronized (knifeAndFork) { // knifeAndFork�������ϵ�ͬ�������
						System.out.println(Thread.currentThread().getName()
								+ "---if---knifeAndFork"); 
					}
				}
			}
		} else {
			while (true) {
				synchronized (knifeAndFork) { // knifeAndFork�������ϵ�ͬ�������
					System.out.println(Thread.currentThread().getName()
							+ "---else---knifeAndFork"); 
					synchronized (chopsticks) { // chopsticks�������ϵ�ͬ�������
						System.out.println(Thread.currentThread().getName()
								+ "---else---chopsticks"); 
					}
				}
			}
		}
	}
}
public class Example514 {
	public static void main(String[] args) {
         // ��������DeadLockThread����
		DeadLockThread d1 = new DeadLockThread(true);
		DeadLockThread d2 = new DeadLockThread(false);
         // ���������������߳�
		new Thread(d1, "Chinese").start();   // ���������߳�Chinese
		new Thread(d2, "American").start(); // ���������߳�American
	}
}
