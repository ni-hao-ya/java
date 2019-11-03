class Storage {
	// ���ݴ洢����
	private int[] cells = new int[10];
	// inPos��ʾ����ʱ�����±꣬outPos��ʾȡ��ʱ�����±�
	private int inPos, outPos;
    // ����һ��put()�����������д�������
	public void put(int num) {
		cells[inPos] = num;
		System.out.println("��cells[" + inPos + "]�з�������---" + cells[inPos]);
		inPos++;// ����Ԫ����λ�ü�1
		if (inPos == cells.length)
			inPos = 0;      // ��inPosΪ���鳤��ʱ��������Ϊ0
	}
    // ����һ��get()������������ȡ������
	public void get() {
		int data = cells[outPos];
		System.out.println("��celss[" + outPos + "]��ȡ������" + data);
		outPos++;            // ȡ��Ԫ����λ�ü�1
		if (outPos == cells.length)
			outPos = 0;
	}
}


/*
class Storage {
	private int[] cells = new int[10];   // ���ݴ洢����
	private int inPos, outPos;            // inPos����ʱ�����±꣬outPosȡ��ʱ�����±�
	private int count;                      // �������ȡ�����ݵ�����
	public synchronized void put(int num) {
		try {
			// ����������ݵ���cells�ĳ��ȣ����̵߳ȴ�
			while (count == cells.length) {
				this.wait();
			}
			cells[inPos] = num;          // �������з�������
			System.out.println("��cells[" + inPos + "]�з�������---" + cells[inPos]);
			inPos++;// ����Ԫ����λ�ü�1
			if (inPos == cells.length) // ����cells[9]�������ݺ��ٴ�cells[0]��ʼ
				inPos = 0;
			count++; // ÿ��һ������count��1
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized void get() {
		try {
			while (count == 0) {          // ��� countΪ0�����̵߳ȴ�
				this.wait();
			}
			int data = cells[outPos];    // ��������ȡ������
			System.out.println("��cells[" + outPos + "]��ȡ������" + data);
			cells[outPos] = 0;            // ȡ���󣬵�ǰλ�õ�������0
			outPos++;                       // ȡ��Ԫ����λ�ü�1
			if (outPos == cells.length) // ����cells[9]ȡ�����ݺ��ٴ�cells[0]��ʼ
				outPos = 0;
			count--;                        // ÿȡ��һ��Ԫ��count��1
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
*/