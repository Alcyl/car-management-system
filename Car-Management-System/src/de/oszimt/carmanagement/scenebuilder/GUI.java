package de.oszimt.carmanagement.scenebuilder;

import java.util.ArrayList;
import java.util.List;

import de.oszimt.carmanagement.interfaces.Concept;
import de.oszimt.carmanagement.interfaces.DataStorage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
	private Concept concept;
	private DataStorage datastorage;

	
	public GUI(Concept concept) {	
		this.concept = concept;
		this.datastorage = datastorage;
	}

	/**
	 * @param args the command line arguments
	 */

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(GUI.class.getResource("CarManagementSystem.fxml"));

		Scene scene = new Scene(root, 600, 550);
		stage.setScene(scene);
		stage.show();

	}
	
	public void test() {
		System.out.println("Das ist ein Test");
	}

}
