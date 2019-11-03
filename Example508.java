public class Example508 {
	public static void main(String[] args) throws Exception {
         // 创建一个线程
		new Thread(new SleepThread()).start();
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				Thread.sleep(2000);  // 当前线程休眠2秒
			}
			System.out.println("主线程正在输出:" + i);
			Thread.sleep(500); // 当前线程休眠500毫秒
		}
	}
}
// 定义SleepThread类实现Runnable接口
class SleepThread implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i == 3) {
				try {
					Thread.sleep(2000); // 当前线程休眠2秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("线程一正在输出:" + i);
			try {
				Thread.sleep(500); // 当前线程休眠500毫秒
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
