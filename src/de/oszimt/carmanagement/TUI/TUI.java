package de.oszimt.carmanagement.TUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import de.oszimt.carmanagement.interfaces.ITechconcept;
import de.oszimt.carmanagement.scenebuilder.TableOfCars;
import de.oszimt.carmanagement.xml.Car;

public class TUI {
	private static ITechconcept concept;


	public TUI(ITechconcept concept) {
		TUI.concept = concept;
		tuiMenu();
	}

	public void showCarTable() {

		List<Car> list = new ArrayList<>();
		list = concept.getCars();
		// Tabellenkopf
		System.out.println("Id\t\tlocation\tbrand\t\ttype\t\tstatus\t\tprice\t\tkm");
		for (Car car : concept.getCars()) {
			System.out.print(car.getId() + "\t\t");
			System.out.print(car.getLocation() + "\t\t");
			System.out.print(car.getBrand() + "\t\t");
			System.out.print(car.getType() + "\t\t");
			System.out.print(car.getStatus() + "\t\t");
			System.out.print(car.getPrice() + "\t\t");
			System.out.print(car.getKm() + "\t\n");
			
		}
	}

	private static boolean generalStringCheck(String input) {

		if (!input.trim().matches("[A-Za-z]+")) {
			return false;
		} else {
			return true;
		}
	}

	static void addCar() {

		String location, brand, type, status, price, km;		
//		Car car = new Car();

		System.out.println("Add car");

		System.out.println("if the input is invalid, then you will be asked again.");
		// exit Funktion
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Location: ");
			location = input.nextLine();
		} while (!generalStringCheck(location));
		
		do {
			System.out.print("Brand: ");
			brand = input.nextLine();
		} while (!generalStringCheck(brand));
		
		do {
			System.out.print("Type: ");
			type = input.nextLine();
		} while (!generalStringCheck(type));
		
		do {
			System.out.print("Status: ");
			status = input.nextLine();
		} while (!generalStatusCheck(status));
		System.out.println("Please use a price and a km of format x.xx");
		do {
			System.out.print("Price: ");
			price = input.nextLine();
		} while (!Pattern.matches("^[\\\\+\\\\-]{0,1}[0-9]+[\\\\.]{1}[0-9]+$", (CharSequence) price));
		
		do {
			System.out.print("Km: ");
			km = input.nextLine();
		} while (!Pattern.matches("^[\\\\+\\\\-]{0,1}[0-9]+[\\\\.]{1}[0-9]+$", (CharSequence) km));
                
        concept.addCars(concept.newID("car"), location, brand, type, status, Double.parseDouble(price), Double.parseDouble(km), concept.newID("brand"));
	}

	private static boolean generalStatusCheck(String input) {
		if (!input.trim().matches("damaged||broken||factory-new")) {
			return false;
		} else {
			return true;
		}		
	}

	public void tuiMenu() {
		String[] options = new String[] { "Show car Table", "Add new car to the system",
				"Delete a car from the system" };

		String intro = "---Car Management System---\n\n" + "Choose what to do by entering a number\n\n";
		System.out.println(intro);
		for (int i = 0; i < options.length; i++) {
			intro += String.format(options[i] + " (%d)\n", i + 1);
			System.out.println(options[i]);
		}
		System.out.println("Case 99 Exit the programm");
		intro += "EXIT (99)\n";

		String input;

		String choice = "1";
		System.out.println(intro);
		while (!choice.equals("99")) {
			do {
				System.out.print("Choose your number: ");
				choice = new Scanner(System.in).nextLine();
			} while (!choice.matches("[0-9]+"));
			switch (Integer.parseInt(choice)) {
			case 99:
				return;
			case 1:
				showCarTable();
				break;
			case 2:
				addCar();
				System.out.println("Car successfully added to Database");
				break;
			case 3:                    
				showCarTable();
				String carId;
				do {
					System.out.print("Choose ID of car: ");
					carId = new Scanner(System.in).nextLine();
				} while (!carId.matches("[0-9]+"));
				concept.deleteCar(Integer.parseInt(carId));
				System.out.println("Car with ID "+carId+" was deleted successfully!");
			}
		}
		System.out.println("Program was successfully closed.");
	}
}