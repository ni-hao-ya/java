class Input implements Runnable{		    // �����߳���
	private Storage st ;
     private int num;                           // ����һ������num 
	Input(Storage st){                         // ͨ�����췽������һ��Storage����
		this.st = st;
	}
	public void run(){        
		while(true){
			st.put(num++);                   // ��num�������飬ÿ�δ����num����
		}
	}
}
