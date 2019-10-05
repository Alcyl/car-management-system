package de.oszimt.carmanagement.interfaces;

import java.util.List;

public interface Concept {

	String getLocation();
	List<Object> getAllLocations();
	String getType();
	String getBrand();
	String getStatus();
	int getPrice();
	int getKm();
	void addNewCar(String location, String brand , String type, String status, int price, int km);
	void deleteCar(int id);
	void deleteAllCars();
	void editCar();
	List<Object> getAllCars();
	
}
