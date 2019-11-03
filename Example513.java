// 定义Ticket1类实现Runnable接口
class Ticket1 implements Runnable {
	private int tickets = 10;
	public void run() {
		while (true) {
			saleTicket(); // 调用售票方法
			if (tickets <= 0) { 
				break;
			}
		}
	}
    // 定义一个同步方法saleTicket()
	private synchronized void saleTicket() {
		if (tickets > 0) {
			try {
				Thread.sleep(10); // 经过的线程休眠10毫秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "---卖出的票"
					+ tickets--);
		}
	}
}
public class Example513 {
	public static void main(String[] args) {
		Ticket1 ticket = new Ticket1(); // 创建Ticket1对象
         // 创建并开启四个线程
		new Thread(ticket,"线程一").start();
		new Thread(ticket,"线程二").start();
		new Thread(ticket,"线程三").start();
		new Thread(ticket,"线程四").start();
	}
}
