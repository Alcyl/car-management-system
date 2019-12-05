package de.oszimt.carmanagement.scenebuilder;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLDocumentController implements Initializable {

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

		carManagementTable.setItems(data);

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

		list.add(new TableOfCars(1, "Berlin", "Tesla", "Name 3", "Name 4", 20.4, 91));
		list.add(new TableOfCars(2, "Koeln", "Name 6", "available", "rented", 40.4, 191));
		list.add(new TableOfCars(3, "Hamburg", "Name 6", "Name 3", "Name 4", 40.4, 191));
		list.add(new TableOfCars(4, "Name 5", "BMW", "in repair", "Name 4", 40.4, 20));

		ObservableList<TableOfCars> data = FXCollections.observableArrayList(list);

		return data;
	}

	private class AddButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			// Create a new row after last row
			TableOfCars car = new TableOfCars(0, locationInput.getText(), brandInput.getText(), typeInput.getText(),
					statusInput.getText(), Double.parseDouble(priceInput.getText()),
					Integer.parseInt(kmInput.getText()));
			data.add(car);
			int row = data.size() - 1;

//			 Select the new row
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

				ix = ix - 1;
			}

			carManagementTable.requestFocus();
			carManagementTable.getSelectionModel().select(ix);
			carManagementTable.getFocusModel().focus(ix);
		}
	}

}
