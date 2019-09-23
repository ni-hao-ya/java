interface Animal {   
	void shout();  
}
public class Example18 {                    
	public static void main(String[] args) {
		class Cat implements Animal {   
			public void shout() {
				System.out.println("ß÷ß÷¡­");
			}
		}
		animalShout(new Cat());    
	}
     public static void animalShout(Animal an) {
		an.shout();                        
    }
}
