package de.oszimt.carmanagement.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

// import de.vogella.xml.stax.model.Item; to be edited

public class XMLRetriever {

	// source beginning
	// https://www.vogella.com/tutorials/JavaXML/article.html#javastax_read
	// source end

	private static final String CAR = "car";
	private static final String LOCATION = "location";
	private static final String BRAND = "brand";
	private static final String TYPE = "type";
	private static final String STATUS = "status";
	private static final String PRICE = "price";
	private static final String KM = "km";

	@SuppressWarnings("unchecked")
	public List<Car> readXML(String xmlFile) {

		List<Car> cars = new ArrayList<Car>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(xmlFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			Car car = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					// If we have an item element, we create a new item
					if (startElement.getName().getLocalPart().equals(CAR)) {
						car = new Car();
					}

					if (event.isStartElement()) {
						if (event.asStartElement().getName().getLocalPart().equals(BRAND)) {
							event = eventReader.nextEvent();
							car.setBrand(event.asCharacters().getData());
							continue;
						}
					}
					if (event.asStartElement().getName().getLocalPart().equals(TYPE)) {
						event = eventReader.nextEvent();
						car.setType(event.asCharacters().getData());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(PRICE)) {
						event = eventReader.nextEvent();
						car.setPrice(Double.parseDouble(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(KM)) {
						event = eventReader.nextEvent();
						car.setKm(Double.parseDouble(event.asCharacters().getData()));
						continue;
					}
				}
				// If we reach the end of an item element, we add it to the list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals(CAR)) {
						cars.add(car);
					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (NullPointerException e2) {
			e2.printStackTrace();
		}
		return cars;
	}
}
