package com.carbonfootprintcalculator.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.carbonfootprintcalculator.services.CalculatorElectricityEmissionsService;
import com.carbonfootprintcalculator.services.SessionService;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/view/calculatorElectricityEmissions.fxml")
public class CalculatorElectricityEmissionsController {

  @Autowired CalculatorElectricityEmissionsService calculatorElectricityEmissionsService;
  @Autowired SessionService sessionService;
  @Autowired FxWeaver fxWeaver;

  @FXML private ResourceBundle resources;

  @FXML private URL location;

  @FXML private Button nextButton;

  @FXML private TextField postCO2;

  @FXML private TextField getKWH;

  @FXML private Button backButton;

  @FXML private Button calculateButton;

  @FXML
  void initialize() {
    backButtonAction();
    calculateButtonAction();
    nextButtonAction();
  }

  private void backButtonAction() {
    backButton.setOnAction(
        event -> {
          backButton.getScene().getWindow().hide();
          Parent root = fxWeaver.loadView(MainController.class);
          Stage stage = new Stage();
          stage.setScene(new Scene(root));
          stage.show();
        });
  }

  private void calculateButtonAction() {
    calculateButton.setOnAction(
        event -> {
          int value = 0;
          try {
            value = Integer.parseInt(getKWH.getText());

          } catch (NumberFormatException e) {
            postCO2.setText("Введите целое число больше -1");
            return;
          }
          if (value < 0) {
            postCO2.setText("Введите целое число больше -1");
            return;
          }
          postCO2.setText(
              String.valueOf(calculatorElectricityEmissionsService.calculateAllEmissions(value)));
        });
  }

  private void nextButtonAction() {
    nextButton.setOnAction(
        event -> {
          int value = 0;
          try {
            value = Integer.parseInt(postCO2.getText());
          } catch (Exception ignored) {
          }
          sessionService.addSessionElectricityEmissionsCo2(value);
          nextButton.getScene().getWindow().hide();
          Parent root = fxWeaver.loadView(CalculatorGasEmissionsController.class);
          Stage stage = new Stage();
          stage.setScene(new Scene(root));
          stage.show();
        });
  }
}
