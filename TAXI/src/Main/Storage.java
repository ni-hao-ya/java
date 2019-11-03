package Main;

import car.car;
import factory.factory;
import xml.ReadXMLUitilcar;

class Input implements Runnable { // 输入线程类
	private Storage st;
	private int num;  //定义一个变量num

	Input(Storage st) { // 通过构造方法接收一个Storage对象
		this.st = st;
	}

	public void run() {
		while (num<5) {
			st.put();// 将num存入数组，每次存入后num自增
			num++;
		}
	}
}

class Output implements Runnable { // 输出线程类
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
		// 数据存储数组
		 int i;
		for (i = 0; i < 10; i++) {
			if(carFactroy!=null)
			cells[i] = carFactroy.proudctCar();
			else System.out.println("12");
		}

	}

	private int inPos, outPos, count; // inPos存入时数组下标，outPos取出时数组下标,存入或者取出数据的数量

	public synchronized void put() {// 入库
		try {
			// 如果放入数据等于cells的长度，此线程等待
			/*while (count == cells.length) {
				this.wait();
			}*/
			// cells[inPos] = (car)ReadXMLUitilcar.getBrandName(); // 向数组中放入数据
			System.out.println("车辆" + inPos + "，" + cells[inPos].toString() + "入库");
			inPos++;// 存完元素让位置加1
			if (inPos == cells.length) // 当在cells[9]放完数据后再从cells[0]开始
				inPos = 0;
			count++; // 每放一个数据count加1
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void get() {
		//car s = null;
		try {
			while (outPos == inPos) { // 如果 count为0，此线程等待
				this.wait();
			}
			System.out.println("车辆" + outPos + "," + cells[outPos].toString() + " 出库。计算费率 " + cells[outPos].fei());
			outPos += 1; // 取完元素让位置加1
			if (outPos == cells.length) // 当从cells[9]取完数据后再从cells[0]开始
				outPos = 0;
			count--; // 每取出一个元素count减1
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}