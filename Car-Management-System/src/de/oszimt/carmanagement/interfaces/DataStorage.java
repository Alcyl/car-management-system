package de.oszimt.carmanagement.interfaces;

import java.util.List;

public interface DataStorage {
	
	int getAmountOfCars(int id);
	void saveNewCar(String location, String brand , String type, String status, int price, int km);
	List<Object> getAllCars();
	void deleteCar();
	void deleteAllCars();
}
