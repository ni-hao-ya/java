public class Example510{
	public static void main(String[] args) throws Exception {
		// �����߳�
		Thread t = new Thread(new EmergencyThread(),"�߳�һ");
		t.start(); // �����߳�
		for (int i = 1; i < 6; i++) {
			System.out.println(Thread.currentThread().getName()+"���룺"+i);
			if (i == 2) {
				t.join(); // ����join()����
			}
			Thread.sleep(500); // �߳�����500����
		}
	}
}
class EmergencyThread implements Runnable {
	public void run() {
		for (int i = 1; i < 6; i++) {
			System.out.println(Thread.currentThread().getName()+"���룺"+i);
			try {
				Thread.sleep(500); // �߳�����500����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
