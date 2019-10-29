package de.oszimt.carmanagement.interfaces;

import java.util.List;

public interface Concept {

	String getLocation();
	List<Object> getAllLocations();
	String getType(int id);
	String getBrand(int id);
	String getStatus(int id);
	int getPrice(int id);
	int getKm(int id);
	void addNewCar(String location, String brand , String type, String status, int price, int km);
	void deleteCar(int id);
	void deleteAllCars();
	void editCar();
	List<Object> getAllCars();
	
}
