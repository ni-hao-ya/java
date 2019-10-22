public class Taxi {
	public static void main(String[] args) {
		taxi tw = new taxi();
		new Thread(tw, "taxi1").start();     
		new Thread(tw, "taxi2").start();      
		new Thread(tw, "taxi3").start();  
		new Thread(tw, "taxi4").start();   
		new Thread(tw, "taxi5").start();    

	}
}
class taxi implements Runnable {
	private int passengers = 100;

	public void run() {
		while (true) {
			if (passengers > 0) {
				Thread th = Thread.currentThread(); 
				String th_name = th.getName(); 
				System.out.println(th_name + "  " + passengers-- + " Passenger");
			}
		}
	}
}
