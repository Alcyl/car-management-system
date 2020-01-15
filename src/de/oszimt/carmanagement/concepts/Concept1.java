package de.oszimt.carmanagement.concepts;

import java.util.List;

import de.oszimt.carmanagement.interfaces.IDatalayer;
import de.oszimt.carmanagement.xml.Car;

public class Concept1 extends Concept{
	
	protected List<Car> cars = db.getAllCars();
	
	public Concept1(IDatalayer db) {
		super(db);
		setSortInstance(new Ascending());
		sort(cars);
	}
	
	public List<Car> getCars() {
		cars = db.getAllCars();
		sort(cars);
		return cars;
	}
	
	

	

}
