package com.carbonfootprintcalculator.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/view/main.fxml")
public class MainController {
	@Autowired
	FxWeaver fxWeaver;
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
			Parent root = fxWeaver.loadView(CalculatorElectricityEmissionsController.class);
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.showAndWait();
		});
	}
}

