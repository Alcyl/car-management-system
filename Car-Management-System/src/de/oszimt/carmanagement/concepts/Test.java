package de.oszimt.carmanagement.concepts;

import de.oszimt.carmanagement.xml.XmlDatabase;

public class Test {

	public static void main(String[] args) {
		
		Concept1 concept1 = new Concept1(new XmlDatabase());
		concept1.someMethod();

	}

}
