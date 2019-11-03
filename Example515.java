public class Example515 {
	public static void main(String[] args) {
		Storage st = new Storage(); // 创建数据存储类对象
		Input input = new Input(st);
		Output output = new Output(st);
		new Thread(input).start();
		new Thread(output).start();
	}
}
