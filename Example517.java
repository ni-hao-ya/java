public class Example517 {
	public static void main(String[] args) {
		Storage st = new Storage(); // 创建数据存储类对象
		Input input = new Input(st);	// 创建Input对象传入Storage对象
		Output output = new Output(st); 	// 创建Output对象传入Storage对象
		new Thread(input).start();		// 开启新线程
		new Thread(output).start();		// 开启新线程
	}
}
