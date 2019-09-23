interface Animal {
	int ID = 1;   
	void breathe(); 
	void run(); 
}
interface LandAnimal extends Animal { 
	void liveOnland();                   
}
class Dog implements LandAnimal {
	public void breathe() {
		System.out.println("狗在呼吸");
	}
	public void run() {
		System.out.println("狗在跑");
	}
	public void liveOnland() {
		System.out.println("狗生活在陆地上");
	} 
}
public class Example12 {
	public static void main(String args[]) {
		Dog dog = new Dog(); 
		dog.breathe(); 
		dog.run();   
		dog.liveOnland();   
	}
}
