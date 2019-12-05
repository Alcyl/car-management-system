package de.oszimt.carmanagement.scenebuilder;


import de.oszimt.carmanagement.concepts.Concept1;
import de.oszimt.carmanagement.interfaces.DataStorage;
import de.oszimt.carmanagement.interfaces.ITechconcept;
import de.oszimt.carmanagement.xml.XmlDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
	
	
	private ITechconcept concept;
	
	public GUI(ITechconcept concept) {
		this.concept = concept;
	}
	
	public GUI() {}
	

	public static void main(String[] args) {
		GUI gui1 = new GUI(new Concept1(new XmlDatabase()));		
		gui1.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(GUI.class.getResource("CarManagementSystem.fxml"));

		Scene scene = new Scene(root, 600, 550);
		stage.setScene(scene);
		stage.show();

	}
}
