	package de.oszimt.carmanagement.scenebuilder;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
	@FXML
	private Button showList;
	@FXML
	private Button add;
	@FXML
	private Button edit;
	@FXML
	private Button delete;
	@FXML
	private TableView<TableOfCars> carManagementTable;
	@FXML
	private TableColumn colId;
	@FXML
	private TableColumn colLocation;
	@FXML
	private TableColumn colBrand;
	@FXML
	private TableColumn colType;
	@FXML
	private TableColumn colStatus;
	@FXML
	private TableColumn colPrice;
	@FXML
	private TableColumn colKm;
	
	ObservableList<TableOfCars> data;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		location.getItems().addAll("Berlin", "Köln", "Hamburg");
		type.getItems().addAll("SUV", "Coupe", "Hatchback");
		brand.getItems().addAll("Mercedes", "BMW", "Audi");
		status.getItems().addAll("In repair", "Available", "Rented");
		
		textFieldValidator(rentalPricePerDay);
		textFieldValidator(numberOfKmDriven);
		
		colId.setCellValueFactory(
		    new PropertyValueFactory<TableOfCars,Integer>("colId")
			);
		colLocation.setCellValueFactory(
		    new PropertyValueFactory<TableOfCars,String>("colLocation")
		);
		colBrand.setCellValueFactory(
		    new PropertyValueFactory<TableOfCars,Integer>("colBrand")
		);
		colType.setCellValueFactory(
		    new PropertyValueFactory<TableOfCars,String>("colType")
		);
		colStatus.setCellValueFactory(
			    new PropertyValueFactory<TableOfCars,String>("colStatus")
			);
		colPrice.setCellValueFactory(
			    new PropertyValueFactory<TableOfCars,String>("colPrice")
			);
		colKm.setCellValueFactory(
			    new PropertyValueFactory<TableOfCars,String>("colKm")
			);
			
		data = FXCollections.observableArrayList(); // create the data
		carManagementTable.setItems(data); // assign the data to the table
		
	}	
	/*
	private void generateCarEntry() {
	    // Add to the data any time, and the table will be updated
		TableOfCars entry = new TableOfCars();
	    itemNum++;
	    entry.colId.set(itemNum);
	    entry.colLocation.set("Item " + itemNum);
	    entry.colBrand.set("Item " + itemNum);
	    entry.colType.set("Item " + itemNum);
	    entry.colStatus.set("Item " + itemNum);
	    entry.colPrice.set("" + (1.99 + itemNum) );
	    entry.colKm.set(itemNum + itemNum);
	    data.add(entry);
	}
	
	
	public void onAddItem(ActionEvent event) {
	    // Add to the data any time, and the table will be updated
	    generateCarEntry();
	}
	*/
	// validates Textfield
	public void textFieldValidator(TextField textfield) {
		try {
			textfield.textProperty().addListener(new ChangeListener<String>() {
			    @Override
			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
			        String newValue) {
			        if (!newValue.matches("[0-9]+\\.?([0-9]+)?")) {
			        	textfield.setText(newValue.replaceAll("[^\\d]", ""));
			        }
			    }
			});	
		} catch(Exception e) {
			System.out.println("two or more commas were set");
		}
	}
	
}
