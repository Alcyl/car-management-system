package de.oszimt.carmanagement.scenebuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLAddPageController implements Initializable {
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("CarManagementSystem.fxml"));
		Scene rootScene = new Scene(root, 600, 550);
		Stage rootStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		rootStage.hide();
		rootStage.setScene(rootScene);
		rootStage.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}
