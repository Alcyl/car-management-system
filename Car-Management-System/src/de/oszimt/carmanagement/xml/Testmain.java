package de.oszimt.carmanagement.xml;

import java.util.List;

public class Testmain {

	public static void main(String[] args) {

		XMLRetriever read = new XMLRetriever();
        List<Car> readConfig = read.readXML("D:\\Dateien\\Eclipse-WorkingSpace\\car-management-system\\Car-Management-System\\res\\database\\carDB.xml");
        for (Car item : readConfig) {
            System.out.println(item.getBrand());
            System.out.println(item.getKm()+"\n");
        }

	}

}
