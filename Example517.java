public class Example517 {
	public static void main(String[] args) {
		Storage st = new Storage(); // �������ݴ洢�����
		Input input = new Input(st);	// ����Input������Storage����
		Output output = new Output(st); 	// ����Output������Storage����
		new Thread(input).start();		// �������߳�
		new Thread(output).start();		// �������߳�
	}
}
