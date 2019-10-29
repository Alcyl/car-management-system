package de.oszimt.carmanagement.scenebuilder;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ComboBoxDropDown extends Application {

	@Override
	public void start(Stage stage) {
		
		ComboBox<Location> location = new ComboBox<Location>();
		ComboBox<Type> type = new ComboBox<Type>();
		ComboBox<Brand> brand = new ComboBox<Brand>();
		ComboBox<Status> status = new ComboBox<Status>();
		ObservableList<Location> locationList = ComboBoxDropDownsDAO.getLocationList();
		ObservableList<Type> typeList = ComboBoxDropDownsDAO.getTypeList();		
		ObservableList<Brand> brandList = ComboBoxDropDownsDAO.getBrandList();
		ObservableList<Status> statusList = ComboBoxDropDownsDAO.getStatusList();
	
		location.setItems(locationList);
		type.setItems(typeList);
		brand.setItems(brandList);
		status.setItems(statusList);
		location.getSelectionModel().select(0);	
		type.getSelectionModel().select(0);
		brand.getSelectionModel().select(0);
		status.getSelectionModel().select(0);
		
		FlowPane root = new FlowPane();
		root.setPadding(new Insets(5));
		root.setHgap(5);
		
//		root.getChildren().add(new Label("Select Location"));
		root.getChildren().add(location);
		root.getChildren().add(type);
		root.getChildren().add(brand);
		root.getChildren().add(status);
		
		stage.setTitle("Car Management System");
		Scene scene = new Scene(root, 350, 300);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[]args) {
		Application.launch(args);
	}

}
