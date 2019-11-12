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

	private String xmlFilepath;
	private List<Car> readxml;
	private XMLRetriever retriever;
	
	public XMLWriter(String xmlFilepath) {
		this.xmlFilepath = xmlFilepath;
		retriever = new XMLRetriever (xmlFilepath);
		readxml = new ArrayList<>();
	}

	public void addNewNode(int id, String location, String brand, String type, Status status, double price, double km)
			throws Exception {
		
		List<Car> cars = getAllCars();
		
		if (checkIfIDAlreadyExists(cars, id)) {
			System.out.println("ID is already taken by other car.");
			return;
		}
		// create an XMLOutputFactory
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(xmlFilepath));
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

		for (Car car : cars) {
			eventWriter.add(tab);
			configStartElement = eventFactory.createStartElement("", "", "car");
			eventWriter.add(configStartElement);
			eventWriter.add(end);

			// Write the different nodes
			createNode(eventWriter, "id", Integer.toString(car.getId()));
			createNode(eventWriter, "location", car.getLocation());
			createNode(eventWriter, "brand", car.getBrand());
			createNode(eventWriter, "type", car.getType());
			createNode(eventWriter, "status", car.getStatus());
			createNode(eventWriter, "price", Double.toString(car.getPrice()));
			createNode(eventWriter, "km", Double.toString(car.getKm()));

			eventWriter.add(tab);
			eventWriter.add(eventFactory.createEndElement("", "", "car"));
			eventWriter.add(end);
		}

		// add specific opening tag (car)
		eventWriter.add(tab);
		configStartElement = eventFactory.createStartElement("", "", "car");
		eventWriter.add(configStartElement);
		eventWriter.add(end);

		// Write the different nodes of new car
		createNode(eventWriter, "id", Integer.toString(id));
		createNode(eventWriter, "location", location);
		createNode(eventWriter, "brand", brand);
		createNode(eventWriter, "type", type);
		createNode(eventWriter, "status", status.toString());
		createNode(eventWriter, "price", Double.toString(price));
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
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(xmlFilepath));
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

		for (Car car : cars) {

			if (car.getId() != id) {
				configStartElement = eventFactory.createStartElement("", "", "car");
				eventWriter.add(configStartElement);
				eventWriter.add(end);

				// Write the different nodes
				createNode(eventWriter, "id", Integer.toString(car.getId()));
				createNode(eventWriter, "location", car.getLocation());
				createNode(eventWriter, "brand", car.getBrand());
				createNode(eventWriter, "type", car.getType());
				createNode(eventWriter, "status", car.getStatus());
				createNode(eventWriter, "price", Double.toString(car.getPrice()));
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
		// carefully is new
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
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(xmlFilepath));
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

	private List<Car> getAllCars() {
		List<Car> cars = new ArrayList<>();

		readxml = retriever.readXML();

		for (Car car : readxml) {
			cars.add(car);
		}

		if (cars.size() != 0) {
			return cars;
		} else {
			return null;
		}
	}
	
	private boolean checkIfIDAlreadyExists(List<Car> cars, int id) {
		
		for (Car car : cars) {
			if (car.getId() == id) {
				return true;
			}
		}
		return false;
	}

}
