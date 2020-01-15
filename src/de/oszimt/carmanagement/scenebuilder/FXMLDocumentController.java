package de.oszimt.carmanagement.scenebuilder;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import de.oszimt.carmanagement.xml.Car;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLDocumentController extends GUI implements Initializable {

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
	private TableColumn<TableOfCars, String> colType;
	@FXML
	private TableColumn<TableOfCars, String> colStatus;
	@FXML
	private TableColumn<TableOfCars, Double> colPrice;
	@FXML
	private TableColumn<TableOfCars, Integer> colKm;
	@FXML
	private TextField searchField;
	

	

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
		colId.setCellValueFactory(new PropertyValueFactory<TableOfCars, Integer>("colId"));
		colLocation.setCellValueFactory(new PropertyValueFactory<TableOfCars, String>("colLocation"));
		colBrand.setCellValueFactory(new PropertyValueFactory<TableOfCars, String>("colBrand"));
		colType.setCellValueFactory(new PropertyValueFactory<TableOfCars, String>("colType"));
		colStatus.setCellValueFactory(new PropertyValueFactory<TableOfCars, String>("colStatus"));
		colPrice.setCellValueFactory(new PropertyValueFactory<TableOfCars, Double>("colPrice"));
		colKm.setCellValueFactory(new PropertyValueFactory<TableOfCars, Integer>("colKm"));

		data = getInitialTableData();
		carManagementTable.setItems(data);

		add.setOnAction(new AddButtonListener());
		delete.setOnAction(new DeleteButtonListener());

		// Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<TableOfCars> filteredData = new FilteredList<>(data, b -> true);

		// 2. Set the filter Predicate whenever the filter changes.
		searchField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(car -> {
				// If filter text is empty, display all persons.

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (String.valueOf(car.getColId()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches ID.
				} else if (String.valueOf(car.getColStatus()).indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (car.getColLocation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches location name.
				} else if (car.getColBrand().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (car.getColType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (car.getColStatus().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (String.valueOf(car.getColPrice()).indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (String.valueOf(car.getColKm()).indexOf(lowerCaseFilter) != -1) {
					return true;
				} else
					return false; // Does not match.
			});
		});

		// 3. Wrap the FilteredList in a SortedList.
		SortedList<TableOfCars> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		// Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(carManagementTable.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		carManagementTable.setItems(sortedData);

	}

	public void onAddItem(ActionEvent event) {
		TableOfCars entry = new TableOfCars(Integer.parseInt(idInput.getText()), locationInput.getText(),
				brandInput.getText(), typeInput.getText(), statusInput.getText(),
				Double.parseDouble(priceInput.getText()), Integer.parseInt(kmInput.getText()));

		data.add(entry);
	}

	// validates Textfield
	public void textFieldValidator(TextField textfield) {
		try {
			textfield.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					if (!newValue.matches("[0-9]+\\.?([0-9]+)?")) {
						textfield.setText(newValue.replaceAll("[^\\d]", ""));
					}
				}
			});
		} catch (Exception e) {
			System.out.println("two or more commas were set");
		}
	}

	// befuellen der Tabelle
	private ObservableList<TableOfCars> getInitialTableData() {

		List<TableOfCars> list = new ArrayList<>();
		
		for (Car car : concept.getCars()) {
			list.add(new TableOfCars(car.getId(), car.getLocation(), car.getBrand(), car.getType(), car.getStatus(), car.getPrice(), car.getKm()));
		}

		ObservableList<TableOfCars> data = FXCollections.observableArrayList(list);

		return data;
	}

	private class AddButtonListener implements EventHandler<ActionEvent> {
		
		private String location, brand, type, status;
		private double price, km;

		@Override
		public void handle(ActionEvent e) {
			
			boolean valid =checkDataForValidty(locationInput.getText(), brandInput.getText(), typeInput.getText(),
					statusInput.getText(), priceInput.getText(), kmInput.getText());
			
			if(!valid) {
				return;
			}
			
			// Create a new row after last row
			TableOfCars car = new TableOfCars(concept.newID("car"), location, brand, type,
					status, price, km);

			concept.addCars(car.getColId(), car.getColLocation(), car.getColBrand(), car.getColType(), car.getColStatus(), 
					car.getColPrice(), car.getColKm(), concept.newID("brand"));
			data.add(car);
			int row = data.size() - 1;

			// Select the new row
			carManagementTable.requestFocus();
			carManagementTable.getSelectionModel().select(row);
			carManagementTable.getFocusModel().focus(row);

			locationInput.clear();
			brandInput.clear();
			typeInput.clear();
			statusInput.clear();
			priceInput.clear();
			kmInput.clear();

		}

		private boolean checkDataForValidty(String location, String brand, String type, String status, String price, String km) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Faulty Input");
		
			if (!generalStringCheck(location)) {
				alert.setHeaderText("Invalid data in field location");
				alert.setContentText("Please do only use letters from A-Z lower and upper case!");
				alert.show();
				return false;
			}
			if (!generalStringCheck(brand)) {
				alert.setHeaderText("Invalid data in field brand");
				alert.setContentText("Please do only use letters from A-Z lower and upper case!");
				alert.show();
				return false;
			}
			if (!generalStringCheck(type)) {
				alert.setHeaderText("Invalid data in field type");
				alert.setContentText("Please do only use letters from A-Z lower and upper case!");
				alert.show();
				return false;
			}
			if (!status.matches("broken||damaged||factory-new")) {
				alert.setHeaderText("Invalid data in field status");
				alert.setContentText("Please do only use following status: broken, damaged, factory-new");
				alert.show();
				return false;
			} 
			if (!Pattern.matches("^[\\\\+\\\\-]{0,1}[0-9]+[\\\\.]{1}[0-9]+$", (CharSequence)price)) {
				alert.setHeaderText("Invalid data in field price");
				alert.setContentText("Please enter a number of format xx.x");
				alert.show();
				return false;
			}else if(Double.parseDouble(price)<0){
				alert.setHeaderText("Invalid data in field price");
				alert.setContentText("Please enter a price greater or equal to 0");
				alert.show();
				return false;
			}
			if (!Pattern.matches("^[\\\\+\\\\-]{0,1}[0-9]+[\\\\.]{1}[0-9]+$", (CharSequence)km)) {
				alert.setHeaderText("Invalid data in field km");
				alert.setContentText("Please enter a number of format xx.x");
				alert.show();
				return false;
			}else if(Double.parseDouble(km)<0){
				alert.setHeaderText("Invalid data in field km");
				alert.setContentText("Please enter a km value greater or equal to 0");
				alert.show();
				return false;
			}

			this.location = location;
			this.brand = brand;
			this.type = type;
			this.status = status;
			this.price = Double.parseDouble(price);
			this.km = Double.parseDouble(km);
			
			return true;
			
		}
		
		private boolean generalStringCheck(String input) {
			
			if (!input.trim().matches("[A-Za-z]+")) {
				return false;
			}else {
				return true;
			}
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
			if(car.getColId()!=null) {
				concept.deleteCar(car.getColId());
			}
			if (carManagementTable.getItems().size() == 0) {

				return;
			}

			if (ix != 0) {

				ix = ix - 1;
			}

			carManagementTable.requestFocus();
			carManagementTable.getSelectionModel().select(ix);
			carManagementTable.getFocusModel().focus(ix);
		}
	}

}
