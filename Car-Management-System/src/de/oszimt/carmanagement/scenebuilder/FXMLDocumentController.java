	package de.oszimt.carmanagement.scenebuilder;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
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
	private TableColumn<TableOfCars, Integer> colId;
	@FXML
	private TableColumn<TableOfCars, String> colLocation;
	@FXML
	private TableColumn<TableOfCars, String> colBrand;
	@FXML
	private TableColumn<TableOfCars,String> colType;
	@FXML
	private TableColumn<TableOfCars,String> colStatus;
	@FXML
	private TableColumn<TableOfCars, Double> colPrice;
	@FXML
	private TableColumn<TableOfCars, Integer> colKm;
	
	// all input fields
	@FXML
	TextField idInput;
	@FXML
	TextField locationInput;
	@FXML
	TextField brandInput;
	@FXML
	TextField typeInput;
	@FXML
	TextField statusInput;
	@FXML
	TextField priceInput;
	@FXML
	TextField kmInput;
	
	
	
	
	private ObservableList<TableOfCars> data;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		location.getItems().addAll("Berlin", "Köln", "Hamburg");
		type.getItems().addAll("SUV", "Coupe", "Hatchback");
		brand.getItems().addAll("Mercedes", "BMW", "Audi");
		status.getItems().addAll("In repair", "Available", "Rented");
		
		textFieldValidator(rentalPricePerDay);
		textFieldValidator(numberOfKmDriven);
		
		colId.setCellValueFactory(new PropertyValueFactory<TableOfCars, Integer>("colId"));
		colLocation.setCellValueFactory(new PropertyValueFactory<TableOfCars, String>("colLocation"));
		colBrand.setCellValueFactory(new PropertyValueFactory<TableOfCars, String>("colBrand"));
		colType.setCellValueFactory(new PropertyValueFactory<TableOfCars, String>("colType"));
		colStatus.setCellValueFactory(new PropertyValueFactory<TableOfCars, String>("colStatus"));
		colPrice.setCellValueFactory(new PropertyValueFactory<TableOfCars, Double>("colPrice"));
		colKm.setCellValueFactory(new PropertyValueFactory<TableOfCars, Integer>("colKm"));
		
		carManagementTable.setItems(data);
		
		data = getInitialTableData();
		carManagementTable.setItems(data);
//		carManagementTable.setEditable(true);
		
		// editable
//		colId.setCellValueFactory(new PropertyValueFactory<TableOfCars, Integer>("colId"));
//		colId.setOnEditCommit(new EventHandler<CellEditEvent<TableOfCars, Integer>>() {
//			@Override
//			public void handle(CellEditEvent<TableOfCars, Integer> t) {
//
//				((TableOfCars) t.getTableView().getItems().get(
//					t.getTablePosition().getRow())
//				).setColId(t.getNewValue());
//			}
//		});
//		
//
//		carManagementTable.getSelectionModel().selectedIndexProperty().addListener(
//			new RowSelectChangeListener());
		
		add.setOnAction(new AddButtonListener());
		delete.setOnAction(new DeleteButtonListener());
		
	}
	
	
	// anderes Beispiel mit textfeldern youtube
	public void onAddItem(ActionEvent event) {
		TableOfCars entry = new TableOfCars(Integer.parseInt(idInput.getText()), locationInput.getText(), brandInput.getText(), typeInput.getText(), statusInput.getText(), Double.parseDouble(priceInput.getText()), Integer.parseInt(kmInput.getText()));
		
		data.add(entry);
		
		clearForm();
	}
	
	private void clearForm() {
		idInput.clear();
		locationInput.clear();
		brandInput.clear();
		typeInput.clear();
		statusInput.clear();
		priceInput.clear();
		kmInput.clear();
	}
	
	
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
	
//	private class RowSelectChangeListener implements ChangeListener<Number> {
//
//		@Override
//		public void changed(ObservableValue<? extends Number> ov, 
//				Number oldVal, Number newVal) {
//
//			int ix = newVal.intValue();
//
//			if ((ix < 0) || (ix >= data.size())) {
//	
//				return; // invalid data
//			}
//
//			TableOfCars car = data.get(ix);	
//		}
//	}
	
	// befuellen der Tabelle
	private ObservableList<TableOfCars> getInitialTableData() {
			
			List<TableOfCars> list = new ArrayList<>();
			
			list.add(new TableOfCars(1, "Name 1", "Name 2", "Name 3", "Name 4", 20.4, 91));
			list.add(new TableOfCars(2, "Name 5", "Name 6", "Name 3", "Name 4", 40.4, 191));
			
	
			ObservableList<TableOfCars> data = FXCollections.observableList(list);
	
			return data;
		}
	
	private class AddButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			// Create a new row after last row
			TableOfCars car = new TableOfCars(0, "...", "...", "...", "...", 0.00, 0);
			data.add(car);
			int row = data.size() - 1;

//			 Select the new row
			carManagementTable.requestFocus();
			carManagementTable.getSelectionModel().select(row);
			carManagementTable.getFocusModel().focus(row);
		
		}
	}
	
	// delete row (abfangen, wenn Tabelle leer ist)
	private class DeleteButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			// Get selected row and delete
			int ix = carManagementTable.getSelectionModel().getSelectedIndex();
			TableOfCars car = (TableOfCars) carManagementTable.getSelectionModel().getSelectedItem();
			data.remove(ix);

			// Select a row

			if (carManagementTable.getItems().size() == 0) {
				
				return;
			}

			if (ix != 0) {

				ix = ix -1;
			}

			carManagementTable.requestFocus();
			carManagementTable.getSelectionModel().select(ix);
			carManagementTable.getFocusModel().focus(ix);
		}
	}
	
}
