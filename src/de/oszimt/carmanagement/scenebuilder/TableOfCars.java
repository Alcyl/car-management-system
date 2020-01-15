package de.oszimt.carmanagement.scenebuilder;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
	private SimpleDoubleProperty colKm;

	public TableOfCars() {
	}

	public TableOfCars(int id, String location, String brand, String type, String status, double price, double km) {
		this.colId = new SimpleIntegerProperty(id);
		this.colLocation = new SimpleStringProperty(location);
		this.colBrand = new SimpleStringProperty(brand);
		this.colType = new SimpleStringProperty(type);
		this.colStatus = new SimpleStringProperty(status);
		this.colPrice = new SimpleDoubleProperty(price);
		this.colKm = new SimpleDoubleProperty(km);

	}

	public Integer getColId() {
		return colId.get();
	}

	public void setColId(Integer value) {
		colId.set(value);
	}

	public String getColLocation() {
		return colLocation.get();
	}

	public final StringProperty locationProperty() {
		return this.colLocation;
	}

	public void setColLocation(String value) {
		colLocation.set(value);
	}

	public String getColBrand() {
		return colBrand.get();
	}

	public final StringProperty brandProperty() {
		return this.colBrand;
	}

	public void setColBrand(String value) {
		colBrand.set(value);
	}

	public String getColType() {
		return colType.get();
	}

	public void setColType(String value) {
		colType.set(value);
	}

	public String getColStatus() {
		return colStatus.get();
	}

	public void setColStatus(String value) {
		colStatus.set(value);
		;
	}

	public Double getColPrice() {
		return colPrice.get();
	}

	public void setColPrice(Double value) {
		colPrice.set(value);
	}

	public Double getColKm() {
		return colKm.get();
	}

	public void setColKm(Double value) {
		colKm.set(value);
	}

	@Override
	public String toString() {
		return "TableOfCars [colId=" + colId + ", colLocation=" + colLocation + ", colBrand=" + colBrand + ", colType="
				+ colType + ", colStatus=" + colStatus + ", colPrice=" + colPrice + ", colKm=" + colKm + "]";
	}

}
