package Main;

import car.car;
import factory.factory;
import xml.ReadXMLUitilcar;

class Input implements Runnable { // �����߳���
	private Storage st;
	private int num;  //����һ������num

	Input(Storage st) { // ͨ�����췽������һ��Storage����
		this.st = st;
	}

	public void run() {
		while (num<5) {
			st.put();// ��num�������飬ÿ�δ����num����
			num++;
		}
	}
}

class Output implements Runnable { // ����߳���
	private Storage st;
int num;
	Output(Storage st) {
		this.st = st;
	}

	public void run() {
		while (num<5) {
			st.get();
			num++;
			
		}
	}

}

class Storage {
	private car[] cells = new car[10];

	public void chu() {
		factory carFactroy = (factory) ReadXMLUitilcar.getBrandName();
		// ���ݴ洢����
		 int i;
		for (i = 0; i < 10; i++) {
			if(carFactroy!=null)
			cells[i] = carFactroy.proudctCar();
			else System.out.println("12");
		}

	}

	private int inPos, outPos, count; // inPos����ʱ�����±꣬outPosȡ��ʱ�����±�,�������ȡ�����ݵ�����

	public synchronized void put() {// ���
		try {
			// ����������ݵ���cells�ĳ��ȣ����̵߳ȴ�
			/*while (count == cells.length) {
				this.wait();
			}*/
			// cells[inPos] = (car)ReadXMLUitilcar.getBrandName(); // �������з�������
			System.out.println("����" + inPos + "��" + cells[inPos].toString() + "���");
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
		//car s = null;
		try {
			while (outPos == inPos) { // ��� countΪ0�����̵߳ȴ�
				this.wait();
			}
			System.out.println("����" + outPos + "," + cells[outPos].toString() + " ���⡣������� " + cells[outPos].fei());
			outPos += 1; // ȡ��Ԫ����λ�ü�1
			if (outPos == cells.length) // ����cells[9]ȡ�����ݺ��ٴ�cells[0]��ʼ
				outPos = 0;
			count--; // ÿȡ��һ��Ԫ��count��1
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}