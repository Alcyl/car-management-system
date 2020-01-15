package de.oszimt.carmanagement.scenebuilder;


import de.oszimt.carmanagement.TUI.TUI;
import de.oszimt.carmanagement.concepts.Concept1;
import de.oszimt.carmanagement.concepts.Concept2;
import de.oszimt.carmanagement.interfaces.ITechconcept;
import de.oszimt.carmanagement.sql.SQLDatabase;
import de.oszimt.carmanagement.xml.XmlDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

	protected static ITechconcept concept;

	public GUI() {}
	

	public static void main(String[] args) {
		
		// TUI
		TUI tui = new TUI(new Concept1(new SQLDatabase()));
		// GUI
//		concept = new Concept1(new SQLDatabase());
//		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root = FXMLLoader.load(GUI.class.getResource("CarManagementSystem.fxml"));
		Scene scene = new Scene(root, 600, 700);
		stage.setScene(scene);
		stage.show();

	}
}
