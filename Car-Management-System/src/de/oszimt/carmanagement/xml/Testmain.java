package de.oszimt.carmanagement.xml;


public class Testmain {

	public static void main(String[] args) {

		XmlDatabase db1 = new XmlDatabase();
		
		db1.addNewCar(5, "Hamburg", "Opel", "Some type", Status.BROKEN, 100.0, 4000.0);
	}
}
