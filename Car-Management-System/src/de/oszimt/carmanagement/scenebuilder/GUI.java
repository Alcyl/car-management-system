package de.oszimt.carmanagement.scenebuilder;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GUI extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("CarManagementSystem.fxml"));
		
		Scene scene = new Scene(root, 550, 500);
		stage.setScene(scene);
		stage.show();
		
	}
	
	/**
	* @param args the command line arguments
	*/
	public static void main(String[]args) {
		launch(args);
	}

}
