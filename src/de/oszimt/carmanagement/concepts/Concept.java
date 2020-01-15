package de.oszimt.carmanagement.concepts;


import java.util.List;

import de.oszimt.carmanagement.interfaces.IDatalayer;
import de.oszimt.carmanagement.interfaces.ISort;
import de.oszimt.carmanagement.interfaces.ITechconcept;
import de.oszimt.carmanagement.xml.Car;
import de.oszimt.carmanagement.xml.Status;

public abstract class Concept implements ITechconcept{
	
	protected ISort sortInstance;
	protected IDatalayer db;
	
	
	public Concept (IDatalayer db){
		this.db = db;
	}
	
	public void sort(List<Car> cars) {
		sortInstance.sort(cars);
	}

	public void setSortInstance(ISort sortInstance) {
		this.sortInstance = sortInstance;
	}
	

	
	public void addCars(int id, String location, String brand, String type, String status, double price, double km, int brand_id) {
		
		Status statusConv;
		
		switch(status) {
		case "factory-new":
			statusConv = Status.FACTORYNEW;
			break;
		case "broken":
			statusConv = Status.BROKEN;
			break;
		case "damaged":
			statusConv = Status.DAMAGED;
			break;
			default:
				statusConv = null;
		}
		
		db.addNewCar(id, location, brand, type, statusConv, price, km, brand_id);
	}
	
	public int newID(String table) {
		int id = db.highestID(table);
		return ++id;
	}
	
	public void deleteCar(int id) {
		db.deleteCar(id);
	}
	
	

}
