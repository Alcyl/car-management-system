package de.oszimt.carmanagement.interfaces;

import java.util.List;

import de.oszimt.carmanagement.xml.Car;

public interface Concept {

	String getLocation(int id);
	List<String> getAllLocations();
	String getType(int id);
	String getBrand(int id);
	String getStatus(int id);
	double getPrice(int id);
	double getKm(int id);
	void addNewCar(int id, String location, String brand , String type, String status, double price, double km);
	void deleteCar(int id);
	void deleteAllCars();
	void editCar(int id);
	List<Car> getAllCars();
	
}
