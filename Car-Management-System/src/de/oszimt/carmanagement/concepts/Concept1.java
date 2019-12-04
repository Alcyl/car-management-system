package de.oszimt.carmanagement.concepts;

import java.util.List;

import de.oszimt.carmanagement.interfaces.Datalayer;
import de.oszimt.carmanagement.xml.Car;

public class Concept1 extends Concept{
	

	public Concept1(Datalayer db) {
		super(db);
		setSortInstance(new Descending());
	}
	
	public void someMethod() {
	   List<Car> cars = db.getAllCars();
	   for (Car car: cars) {
		   System.out.println(car.getBrand());
	   }
	}

}
