class DamonThread implements Runnable { // ����DamonThread�࣬ʵ��Runnable�ӿ�
	public void run() { // ʵ�ֽӿ��е�run()����
		while (true) {
			System.out.println(Thread.currentThread().getName()
					+ "---is running.");
		}
	}
}
public class Example506 {
	public static void main(String[] args) {
         System.out.println("main�߳��Ǻ�̨�߳���?"+ Thread.currentThread().isDaemon());
		DamonThread dt = new DamonThread();      // ����һ��DamonThread����dt
		Thread t = new Thread(dt,"��̨�߳�");    // �����߳�t����dt��Դ
         System.out.println("t�߳�Ĭ���Ǻ�̨�߳���? "+t.isDaemon()); // �ж��Ƿ�Ϊ��̨�߳�
		t.setDaemon(true);           // ���߳�t����Ϊ��̨�߳�
		t.start();                    // ����start()���������߳�t
		for(int i=0;i<10;i++){ 
			System.out.println(i);
		}
	}
}
