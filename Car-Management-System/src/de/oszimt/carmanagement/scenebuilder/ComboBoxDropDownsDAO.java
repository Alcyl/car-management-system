package de.oszimt.carmanagement.scenebuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ComboBoxDropDownsDAO {

	public static ObservableList<Location>getLocationList() {
		Location berlin = new Location("BER", "Berlin"); // aus DB holen
		Location hamburg = new Location("HAM", "Hamburg"); // aus DB holen
		Location koeln = new Location("COL", "Köln"); // aus DB holen
		
		ObservableList<Location> list =FXCollections.observableArrayList(berlin, hamburg, koeln);
		
		return list;
	}
	
	public static ObservableList<Type>getTypeList() {
		Type suv = new Type("SUV"); // aus DB holen
		Type coupe = new Type("Coupe"); // aus DB holen
		Type hatchback = new Type("Hatchback"); // aus DB holen
		Type cabrio = new Type ("Cabrio"); // aus DB holen
		
		ObservableList<Type> list =FXCollections.observableArrayList(suv, coupe, hatchback, cabrio);
		
		return list;
	}
	
	public static ObservableList<Brand>getBrandList() {
		Brand mercedes = new Brand("Mercedes"); // aus DB holen
		Brand bmw = new Brand("BMW"); // aus DB holen
		Brand audi = new Brand("Audi"); // aus DB holen
		
		
		ObservableList<Brand> list =FXCollections.observableArrayList(mercedes, bmw, audi);
		
		return list;
	}
	
	public static ObservableList<Status>getStatusList() {
		Status inRepair = new Status("in Repair"); // aus DB holen
		Status available = new Status("Available"); // aus DB holen
		Status rented = new Status("Rented"); // aus DB holen
		
		
		ObservableList<Status> list =FXCollections.observableArrayList(inRepair, available, rented);
		
		return list;
	}
}
