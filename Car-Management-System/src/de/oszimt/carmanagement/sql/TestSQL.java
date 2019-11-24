package de.oszimt.carmanagement.sql;


import de.oszimt.carmanagement.xml.Car;
import de.oszimt.carmanagement.xml.Status;

public class TestSQL {

	public static void main(String[] args) {
		
		SQLDatabase db = new SQLDatabase();
		db.dropTables();
		db.createTables();
		db.addNewCar(1, "Berlin", "Mercedes", "PKW", Status.BROKEN, 3000.0, 200.546, 1);
		
		db.editCar(1, "Hamburg", "BMW", "LKW", Status.BROKEN, 3000.1, 300.1, 1);

//		System.out.println(db.getAllLocations());

		for (Car car : db.getAllCars()) {
			System.out.println(car.getKm());
		}

	}

}
