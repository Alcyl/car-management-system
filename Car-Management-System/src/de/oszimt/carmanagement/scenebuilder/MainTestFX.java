package de.oszimt.carmanagement.scenebuilder;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainTestFX extends Application {

	@Override
	public void start(Stage primaryStage) {
		Location berlin = new Location("Berlin");
		Location hamburg = new Location("Hamburg");
		Location koeln = new Location("Köln");
		
		Type suv = new Type("SUV");
		Type coupe = new Type("Coupe");
		Type hatchback = new Type("Hatchback");
		
		Brand mercedes = new Brand("mercedes");
		Brand bmw = new Brand("BMW");
		Brand audi = new Brand("Audi");
		
		Status inRepair = new Status("In repair");
		Status available = new Status("Available");
		Status rented = new Status("Rented");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
