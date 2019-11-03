public class Example504 {
	public static void main(String[] args) {
		new TicketWindow().start();   // 创建一个线程对象TicketWindow并开启
		new TicketWindow().start();   // 创建一个线程对象TicketWindow并开启
		new TicketWindow().start();   // 创建一个线程对象TicketWindow并开启
		new TicketWindow().start();   // 创建一个线程对象TicketWindow并开启
	}
}
class TicketWindow extends Thread {
	private int tickets = 100;
	public void run() {
		while (true) {    // 通过死循环语句打印语句
			if (tickets > 0) {
				Thread th = Thread.currentThread(); // 获取当前线程
				String th_name = th.getName();       // 获取当前线程的名字
				System.out.println(th_name + " 正在发售第 " + tickets--+" 张票 ");
			}
		}
	}
}
