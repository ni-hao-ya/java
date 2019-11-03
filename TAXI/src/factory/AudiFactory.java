package factory;
import car.Audi;
import car.car;

public class AudiFactory implements factory{

		public car proudctCar() {
		
		return new Audi();
	}  
}
 