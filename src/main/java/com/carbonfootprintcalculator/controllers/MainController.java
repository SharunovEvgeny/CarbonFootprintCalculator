package com.carbonfootprintcalculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController {
	@Autowired
	private ConfigurationControllers.ViewHolder view;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button startButton;

	@FXML
	void initialize() {
		startButton.setOnAction(event -> {
			startButton.getScene().getWindow().hide();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("resources/fxml/calculatorElectricityEmissions"));
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
						Parent parent = loader.getRoot();
			view.setView(parent);

//			Stage stage = new Stage();
//			stage.setScene(new Scene(parent));
//			stage.showAndWait();
		});
	}
}

