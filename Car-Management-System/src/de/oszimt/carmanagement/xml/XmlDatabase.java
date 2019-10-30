package de.oszimt.carmanagement.xml;

import java.util.ArrayList;
import java.util.List;

import de.oszimt.carmanagement.interfaces.Concept;

public class XmlDatabase implements Concept {

	private static XmlDatabase instance;
	private XMLRetriever retriever;
	// relative path to be added
	private static final String XMLFILEPATH = "C:\\Users\\user\\Desktop\\car-management-system\\Car-Management-System\\res\\database\\carDB.xml"; // relative
	private List<Car> readxml;

	private XmlDatabase() {
		retriever = new XMLRetriever();
	}

	public static XmlDatabase getInstance() {
		if (XmlDatabase.instance == null) {
			XmlDatabase.instance = new XmlDatabase();
		}
		return XmlDatabase.instance;
	}

	@Override
	public String getLocation(int id) {
		readxml = retriever.readXML(XMLFILEPATH);

		for (Car car : readxml) {
			if (car.getId() == id) {
				return car.getLocation();
			}
		}
		System.out.println("The given ID does not exist in the XML-File.");
		return null;
	}

	@Override
	public List<String> getAllLocations() {
		List<String> locations = new ArrayList<>();
		readxml = retriever.readXML(XMLFILEPATH);

		for (Car car : readxml) {
			locations.add(car.getLocation());
		}

		if (locations.size() != 0) {
			return locations;
		} else {
			System.out.println("There are no locations in the XML-File.");
			return null;
		}
	}

	@Override
	public String getType(int id) {
		readxml = retriever.readXML(XMLFILEPATH);

		for (Car car : readxml) {
			if (car.getId() == id) {
				return car.getType();
			}
		}
		System.out.println("The given ID does not exist in the XML-File.");
		return null;
	}

	@Override
	public String getBrand(int id) {
		readxml = retriever.readXML(XMLFILEPATH);

		for (Car car : readxml) {
			if (car.getId() == id) {
				return car.getBrand();
			}
		}
		System.out.println("The given ID does not exist in the XML-File.");
		return null;
	}

	@Override
	public String getStatus(int id) {
		readxml = retriever.readXML(XMLFILEPATH);

		for (Car car : readxml) {
			if (car.getId() == id) {
				return car.getStatus();
			}
		}
		System.out.println("The given ID does not exist in the XML-File.");
		return null;
	}

	@Override
	public double getPrice(int id) {
		readxml = retriever.readXML(XMLFILEPATH);

		for (Car car : readxml) {
			if (car.getId() == id) {
				return car.getPrice();
			}
		}
		System.out.println("The given ID does not exist in the XML-File.");
		return -1;

	}

	@Override
	public double getKm(int id) {
		readxml = retriever.readXML(XMLFILEPATH);

		for (Car car : readxml) {
			if (car.getId() == id) {
				return car.getKm();
			}
		}
		System.out.println("The given ID does not exist in the XML-File.");
		return -1;
	}

	@Override
	public void addNewCar(String location, String brand, String type, String status, double price, double km) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllCars() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editCar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Car> getAllCars() {
		List<Car> cars = new ArrayList<>();

		readxml = retriever.readXML(XMLFILEPATH);

		for (Car car : readxml) {
			cars.add(car);
		}
		
		if (cars.size()!=0) {
			return cars;
		} else {
			return null;
		}
	}

}
