package de.oszimt.carmanagement.xml;

import java.util.ArrayList;
import java.util.List;

public class Testmain {

	public static void main(String[] args) {

//		XMLRetriever read = new XMLRetriever();
//        List<Car> readConfig = read.readXML("C:\\Users\\user\\Desktop\\car-management-system\\Car-Management-System\\res\\database\\carDB.xml");
//        for (Car item : readConfig) {
//            System.out.println(item.getBrand());
//            System.out.println(item.getKm());
//            System.out.println(item.getLocation());
//            System.out.println(item.getId());
//            System.out.println(item.getStatus()+"\n");
//        }
		
		XmlDatabase db1 = XmlDatabase.getInstance();
		List<Car> cars =new ArrayList<>();
		cars = db1.getAllCars();

	}

}
