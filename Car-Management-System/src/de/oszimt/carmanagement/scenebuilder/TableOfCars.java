package de.oszimt.carmanagement.scenebuilder;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class TableOfCars {
	private SimpleIntegerProperty colId;
	private SimpleStringProperty colLocation;
	private SimpleStringProperty colBrand;
	private SimpleStringProperty colType;
	private SimpleStringProperty colStatus;
	private SimpleDoubleProperty colPrice;
	private SimpleIntegerProperty colKm;
	
	public TableOfCars() {		
	}
	
	public TableOfCars (int id, String location, String brand, String type, String status, double price, int km) {
		colId = new SimpleIntegerProperty(id);
		colLocation = new SimpleStringProperty(location);
		colBrand = new SimpleStringProperty(brand);
		colType = new SimpleStringProperty(type);
		colStatus = new SimpleStringProperty(status);
		colPrice = new SimpleDoubleProperty(price);
		colKm = new SimpleIntegerProperty(km);

    }

	public SimpleIntegerProperty getColId() {
		return colId;
	}

	public void setColId(SimpleIntegerProperty colId) {
		this.colId = colId;
	}

	public SimpleStringProperty getColLocation() {
		return colLocation;
	}

	public void setColLocation(SimpleStringProperty colLocation) {
		this.colLocation = colLocation;
	}

	public SimpleStringProperty getColBrand() {
		return colBrand;
	}

	public void setColBrand(SimpleStringProperty colBrand) {
		this.colBrand = colBrand;
	}

	public SimpleStringProperty getColType() {
		return colType;
	}

	public void setColType(SimpleStringProperty colType) {
		this.colType = colType;
	}

	public SimpleStringProperty getColStatus() {
		return colStatus;
	}

	public void setColStatus(SimpleStringProperty colStatus) {
		this.colStatus = colStatus;
	}

	public SimpleDoubleProperty getColPrice() {
		return colPrice;
	}

	public void setColPrice(SimpleDoubleProperty colPrice) {
		this.colPrice = colPrice;
	}

	public SimpleIntegerProperty getColKm() {
		return colKm;
	}

	public void setColKm(SimpleIntegerProperty colKm) {
		this.colKm = colKm;
	}

	@Override
	public String toString() {
		return "TableOfCars [colId=" + colId + ", colLocation=" + colLocation + ", colBrand=" + colBrand + ", colType="
				+ colType + ", colStatus=" + colStatus + ", colPrice=" + colPrice + ", colKm=" + colKm + "]";
	}
	
	
	
	
	
	
 /*
	public SimpleIntegerProperty getColId() {
		return colId;
	}
	public SimpleStringProperty getColLocation() {
		return colLocation;
	}
	public SimpleStringProperty getColBrand() {
		return colBrand;
	}
	public SimpleStringProperty getColType() {
		return colType;
	}
	public SimpleStringProperty getColStatus() {
		return colStatus;
	}
	public SimpleStringProperty getColPrice() {
		return colPrice;
	}
	public SimpleIntegerProperty getColKm() {
		return colKm;
	}
	
	public void showList(ActionEvent event) {
	}
	
	public void add(ActionEvent event) {
	}
	
	public void edit(ActionEvent event) {
	}
	
	public void delete(ActionEvent event) {
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	*/

}
