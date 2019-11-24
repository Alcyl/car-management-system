package de.oszimt.carmanagement.scenebuilder;


import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GUI extends Application {
	
	private TableView<TableOfCars> table;
    private ObservableList<TableOfCars> data;
    private Text actionStatus;
    
	/**
	* @param args the command line arguments
	*/
	
	public static void main(String[]args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("CarManagementSystem.fxml"));
		stage.setTitle("Table View Example 1");
		
		// Books label
        Label label = new Label("Cars");
        label.setTextFill(Color.DARKBLUE);
        label.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(label);
		
        // Table view, data, columns and properties
        
        table = new TableView<>();
        data = getInitialTableData();
        table.setItems(data);
        
        TableColumn colId = new TableColumn("ID");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn colLocation = new TableColumn("Location");
        colLocation.setCellValueFactory(new PropertyValueFactory("location"));
 
        table.getColumns().setAll(colId, colLocation);
        table.setPrefWidth(450);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
 
        table.getSelectionModel().selectedIndexProperty().addListener(
                new RowSelectChangeListener());
        
        // Status message text
        actionStatus = new Text();
        actionStatus.setFill(Color.FIREBRICK);
 
        // Vbox
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(25, 25, 25, 25));;
        vbox.getChildren().addAll(hb, table, actionStatus);
        
        // Scene
//        Scene scene = new Scene(vbox, 500, 475); // w x h
//        stage.setScene(scene);
//        stage.show();
        
        // -->hier ändern je nach GUI root oder vbox<--
		Scene scene = new Scene(root, 600, 550);
		stage.setScene(scene);
		stage.show();
		
        
        // Select the first row
        table.getSelectionModel().select(0);
        TableOfCars car = table.getSelectionModel().getSelectedItem();
        actionStatus.setText(car.toString());
	}
	
	private class RowSelectChangeListener implements ChangeListener<Number> {
		               
        	@Override
    		public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) {

    			int ix = newVal.intValue();

    			if ((ix < 0) || (ix >= data.size())) {
    	
    				return; // invalid data
    			}

    			TableOfCars car = data.get(ix);
    			actionStatus.setText(car.toString());	
    		} 
    }
	
	private ObservableList<TableOfCars> getInitialTableData() {
		 
        List<TableOfCars> list = new ArrayList<>();
        list.add(new TableOfCars(1, "Berlin", "BMW", "Coupe", "in repair", 100, 1200));
        list.add(new TableOfCars());
        list.add(new TableOfCars());
      
       
        ObservableList<TableOfCars> data = FXCollections.observableList(list);
 
        return data;
    }

}
