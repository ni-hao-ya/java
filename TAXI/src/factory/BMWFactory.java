package factory;
//import xml.ReadXMLUitilcar;
import car.BMW;
import car.car;

public class BMWFactory implements factory{
	public car proudctCar() {		
		return new BMW();
	}
}
 