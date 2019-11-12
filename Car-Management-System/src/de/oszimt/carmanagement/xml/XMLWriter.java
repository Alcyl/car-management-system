package de.oszimt.carmanagement.xml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLWriter {

	private String configFile;
	private List<Car> readxml = new ArrayList<>();
	private XMLRetriever retriever = new XMLRetriever();
	// relative path to be added
	private static final String XMLFILEPATH = "D:\\Dateien\\Eclipse-WorkingSpace\\car-management-system\\Car-Management-System\\res\\database\\carDB.xml"; // relative
	// private int id;
	// private String location;
	// private String brand;
	// private String type;
	// private String status;
	// private double price;
	// private double km;

	public void setFile(String configFile) {
		this.configFile = configFile;
	}

	public void addNewNode(int id, String location, String brand, String type, String status, double price, double km)
			throws Exception {
		List<Car> cars = getAllCars();
		// create an XMLOutputFactory
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(configFile));
		// create an EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);
		eventWriter.add(end);

		// create cars open tag
		StartElement configStartElement = eventFactory.createStartElement("", "", "cars");
		eventWriter.add(configStartElement);
		eventWriter.add(end);
		eventWriter.add(tab);

		for (Car car : cars) {
			configStartElement = eventFactory.createStartElement("", "", "car");
			eventWriter.add(configStartElement);
			eventWriter.add(end);

			// Write the different nodes
			eventWriter.add(tab);
			createNode(eventWriter, "id", Integer.toString(car.getId()));
			eventWriter.add(tab);
			createNode(eventWriter, "location", car.getLocation());
			eventWriter.add(tab);
			createNode(eventWriter, "brand", car.getBrand());
			eventWriter.add(tab);
			createNode(eventWriter, "type", car.getType());
			eventWriter.add(tab);
			createNode(eventWriter, "status", car.getStatus());
			eventWriter.add(tab);
			createNode(eventWriter, "price", Double.toString(car.getPrice()));
			eventWriter.add(tab);
			createNode(eventWriter, "km", Double.toString(car.getKm()));

			eventWriter.add(tab);
			eventWriter.add(eventFactory.createEndElement("", "", "car"));
			eventWriter.add(end);
		}

		// add specific opening tag (car)
		configStartElement = eventFactory.createStartElement("", "", "car");
		eventWriter.add(configStartElement);
		eventWriter.add(end);

		// Write the different nodes of new car
		eventWriter.add(tab);
		createNode(eventWriter, "id", Integer.toString(id));
		eventWriter.add(tab);
		createNode(eventWriter, "location", location);
		eventWriter.add(tab);
		createNode(eventWriter, "brand", brand);
		eventWriter.add(tab);
		createNode(eventWriter, "type", type);
		eventWriter.add(tab);
		createNode(eventWriter, "status", status);
		eventWriter.add(tab);
		createNode(eventWriter, "price", Double.toString(price));
		eventWriter.add(tab);
		createNode(eventWriter, "km", Double.toString(km));

		// add specific ending tag (car)
		eventWriter.add(tab);
		eventWriter.add(eventFactory.createEndElement("", "", "car"));
		eventWriter.add(end);

		eventWriter.add(eventFactory.createEndElement("", "", "cars"));
		eventWriter.add(end);
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
	}

	public void deleteItem(int id) throws Exception {
		List<Car> cars = getAllCars();
		// create an XMLOutputFactory
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(configFile));
		// create an EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);
		eventWriter.add(end);

		// create cars open tag
		StartElement configStartElement = eventFactory.createStartElement("", "", "cars");
		eventWriter.add(configStartElement);
		eventWriter.add(end);
		eventWriter.add(tab);

		for (Car car : cars) {

			if (car.getId() != id) {
				configStartElement = eventFactory.createStartElement("", "", "car");
				eventWriter.add(configStartElement);
				eventWriter.add(end);

				// Write the different nodes
				eventWriter.add(tab);
				createNode(eventWriter, "id", Integer.toString(car.getId()));
				eventWriter.add(tab);
				createNode(eventWriter, "location", car.getLocation());
				eventWriter.add(tab);
				createNode(eventWriter, "brand", car.getBrand());
				eventWriter.add(tab);
				createNode(eventWriter, "type", car.getType());
				eventWriter.add(tab);
				createNode(eventWriter, "status", car.getStatus());
				eventWriter.add(tab);
				createNode(eventWriter, "price", Double.toString(car.getPrice()));
				eventWriter.add(tab);
				createNode(eventWriter, "km", Double.toString(car.getKm()));

				eventWriter.add(tab);
				eventWriter.add(eventFactory.createEndElement("", "", "car"));
				eventWriter.add(end);
			}
		}
		eventWriter.add(eventFactory.createEndElement("", "", "cars"));
		eventWriter.add(end);
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
	}

	private void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {

		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		// create End node
		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);

	}
	
	public void deleteAllItems() throws Exception {
		// create an XMLOutputFactory
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(configFile));
		// create an EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		// create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);
		eventWriter.add(end);

		// create cars open tag
		StartElement configStartElement = eventFactory.createStartElement("", "", "cars");
		eventWriter.add(configStartElement);
		eventWriter.add(end);

		eventWriter.add(eventFactory.createEndElement("", "", "cars"));
		eventWriter.add(end);
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
	}

	public List<Car> getAllCars() {
		List<Car> cars = new ArrayList<>();

		readxml = retriever.readXML(XMLFILEPATH);

		for (Car car : readxml) {
			cars.add(car);
		}

		if (cars.size() != 0) {
			return cars;
		} else {
			return null;
		}
	}

}
