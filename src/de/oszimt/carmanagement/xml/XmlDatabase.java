package de.oszimt.carmanagement.xml;

import java.util.ArrayList;
import java.util.List;

import de.oszimt.carmanagement.interfaces.IDatalayer;

public class XmlDatabase implements IDatalayer {
	
	// TODO: Konstruktur und Anbindung an Backend realisieren. Aufgabe vom 12.11.19
	
	private XMLRetriever retriever;
	private XMLWriter writer;
	private List<Car> readxml;
	private static String XMLFILEPATH = "res\\database\\carDB.xml";

	public XmlDatabase() {
		String os = System.getProperty("os.name");
		if (os.trim().equals("Mac OS X")) {
			XMLFILEPATH = "res//database//carDB.xml";
		}		
		retriever = new XMLRetriever(XMLFILEPATH);
		writer = new XMLWriter(XMLFILEPATH);
	}

	
	@Override
	public String getLocation(int id) {
		readxml = retriever.readXML();

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
		readxml = retriever.readXML();

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
		readxml = retriever.readXML();

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
		readxml = retriever.readXML();

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
		readxml = retriever.readXML();

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
		readxml = retriever.readXML();

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
		readxml = retriever.readXML();

		for (Car car : readxml) {
			if (car.getId() == id) {
				return car.getKm();
			}
		}
		System.out.println("The given ID does not exist in the XML-File.");
		return -1;
	}
	
	@Override
	public int highestID(String table) {
		
		int id = -1;
		
		readxml = retriever.readXML();
		
		for (Car car : readxml) {
			if(car.getId() > id) {
				id = car.getId();
			}
		}
		return id;
	}

	@Override
	public void addNewCar(int id, String location, String brand, String type, Status status, double price, double km, int brand_id){
		
		try {
			writer.addNewNode(id, location, brand, type, status, price, km);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCar(int id) {
		try {
			writer.deleteItem(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAllCars() {
		try {
			writer.deleteAllItems();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editCar(int id, String location, String brand, String type, Status status, double price, double km, int brand_id) {
		
		try {
			writer.deleteItem(id);
			writer.addNewNode(id, location, brand, type, status, price, km);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private Car getCar(int id) {
	
		readxml = retriever.readXML();

		for (Car car : readxml) {
			
			if (car.getId() == id) {
				return car;
			}
		}
		return null;
	}

	@Override
	public List<Car> getAllCars() {
		
		List<Car> cars = new ArrayList<>();
		readxml = retriever.readXML();

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
