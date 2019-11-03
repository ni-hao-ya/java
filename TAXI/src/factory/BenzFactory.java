package factory;
import car.Benz;
import car.car;

public class BenzFactory implements factory{
	public car proudctCar() {		
		return new Benz();
	}
}
 