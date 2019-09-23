interface Animal {
	int ID = 1;    
	void breathe();  
	void run();      
}
class Dog implements Animal {
	public void breathe() {
		System.out.println("¹·ÔÚºôÎü");
	}
	public void run() {
		System.out.println("¹·ÔÚÅÜ");
	} 
}
public class Example11 {
	public static void main(String args[]) {
		Dog dog = new Dog();
		dog.breathe();       
		dog.run();         
	}
}
