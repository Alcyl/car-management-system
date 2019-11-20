package de.oszimt.carmanagement.scenebuilder;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

	@FXML
	private ComboBox<String> location;
	@FXML
	private ComboBox<String> type;
	@FXML
	private ComboBox<String> brand;
	@FXML
	private ComboBox<String> status;
	@FXML
	private TextField rentalPricePerDay;
	@FXML
	private TextField numberOfKmDriven;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		location.getItems().addAll("Berlin", "Köln", "Hamburg");
		type.getItems().addAll("SUV", "Coupe", "Hatchback");
		brand.getItems().addAll("Mercedes", "BMW", "Audi");
		status.getItems().addAll("In repair", "Available", "Rented");
		
		textFieldValidator(rentalPricePerDay);
		textFieldValidator(numberOfKmDriven);

	}
	
	// validates Textfield
	public void textFieldValidator(TextField textfield) {
		textfield.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("[0-9]+\\.?([0-9]+)?")) {
		        	textfield.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
	}
	
}
