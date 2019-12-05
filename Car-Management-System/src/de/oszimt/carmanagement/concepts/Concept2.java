package de.oszimt.carmanagement.concepts;

import java.util.List;

import de.oszimt.carmanagement.interfaces.Datalayer;
import de.oszimt.carmanagement.xml.Car;

public class Concept2 extends Concept{
	
	public Concept2(Datalayer db) {
		super(db);
		setSortInstance(new Ascending());
	}
	
	public void someMethod() {
	   List<Car> cars = db.getAllCars();
	   for (Car car: cars) {
		   System.out.println(car.getBrand());
	   }
	}

	@Override
	public void testing() {
		// TODO Auto-generated method stub
		
	}

}
