abstract class Animal { 
	abstract void shout(); 
}
class Dog extends Animal {
	void shout() {
		System.out.println("ÍôÍô¡­¡­");
	}
}
public class Example10 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.shout();
	}
}
