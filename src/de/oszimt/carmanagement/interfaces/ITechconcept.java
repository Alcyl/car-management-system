package de.oszimt.carmanagement.interfaces;

import java.util.List;

import de.oszimt.carmanagement.xml.Car;
import de.oszimt.carmanagement.xml.Status;

public interface ITechconcept {
	
	List<Car> getCars();
	void addCars(int id, String location, String brand, String type, String status, double price, double km, int brand_id);
	int newID(String table);
	void deleteCar(int id);
}
