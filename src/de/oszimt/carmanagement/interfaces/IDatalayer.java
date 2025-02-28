package de.oszimt.carmanagement.interfaces;

import java.util.List;

import de.oszimt.carmanagement.xml.Car;
import de.oszimt.carmanagement.xml.Status;

public interface IDatalayer {

	String getLocation(int id);
	List<String> getAllLocations();
	String getType(int id);
	String getBrand(int id);
	String getStatus(int id);
	double getPrice(int id);
	double getKm(int id);
	void addNewCar(int id, String location, String brand , String type, Status status, double price, double km, int brand_id);
	void deleteCar(int id);
	void deleteAllCars();
	void editCar(int id, String location, String brand, String type, Status status, double price, double km, int brand_id);
	List<Car> getAllCars();
	int highestID(String table);
}
