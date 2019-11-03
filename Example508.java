public class Example508 {
	public static void main(String[] args) throws Exception {
         // ����һ���߳�
		new Thread(new SleepThread()).start();
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				Thread.sleep(2000);  // ��ǰ�߳�����2��
			}
			System.out.println("���߳��������:" + i);
			Thread.sleep(500); // ��ǰ�߳�����500����
		}
	}
}
// ����SleepThread��ʵ��Runnable�ӿ�
class SleepThread implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i == 3) {
				try {
					Thread.sleep(2000); // ��ǰ�߳�����2��
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("�߳�һ�������:" + i);
			try {
				Thread.sleep(500); // ��ǰ�߳�����500����
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
