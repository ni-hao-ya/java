interface Animal { 
	void shout(); 
}
public class Example19 {
	public static void main(String[] args) {
		animalShout(new Animal() {
			public void shout() {
				System.out.println("ίχίχ...");
			}
		});
	}

	public static void animalShout(Animal an) {
		an.shout(); 
	}
}
