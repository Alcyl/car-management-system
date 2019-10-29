package de.oszimt.carmanagement.scenebuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LocationDAO {

	public static ObservableList<Location>getLocationList() {
		Location berlin = new Location("BER", "Berlin"); // aus DB holen
		Location hamburg = new Location("HAM", "Hamburg"); // aus DB holen
		Location koeln = new Location("COL", "Köln"); // aus DB holen
		
		ObservableList<Location> list =FXCollections.observableArrayList(berlin, hamburg, koeln);
		
		return list;
	}
}
