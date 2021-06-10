package com.carbonfootprintcalculator.controllers;

import com.carbonfootprintcalculator.services.CalculatorCarEmissionsService;
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

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/view/calculatorCarEmissions.fxml")
public class CalculatorCarEmissionsController {
  @Autowired CalculatorCarEmissionsService calculatorCarEmissionsService;
  @Autowired SessionService sessionService;
  @Autowired FxWeaver fxWeaver;

  @FXML private ResourceBundle resources;

  @FXML private URL location;

  @FXML private Button nextButton;

  @FXML private TextField getLitrPer100Km;

  @FXML private TextField postCO2;

  @FXML private Button backButton;

  @FXML private TextField getNumberKM;

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
          Parent root = fxWeaver.loadView(CalculatorGasEmissionsController.class);
          Stage stage = new Stage();
          stage.setScene(new Scene(root));
          stage.show();
        });
  }

  private void calculateButtonAction() {
    calculateButton.setOnAction(
        event -> {
          int litrPer100Km = 0;
          int numberKm = 0;
          try {
            litrPer100Km = Integer.parseInt(getLitrPer100Km.getText());
            numberKm = Integer.parseInt(getNumberKM.getText());
          } catch (NumberFormatException e) {
            postCO2.setText("Введите целые числа больше -1");
            return;
          }
          if (litrPer100Km < 0 || numberKm < 0) {
            postCO2.setText("Введите целые числа больше -1");
            return;
          }
          postCO2.setText(
              String.valueOf(
                  calculatorCarEmissionsService.calculateAllEmissions(litrPer100Km, numberKm)));
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
          sessionService.addSessionCarEmissionsCo2(value);
          nextButton.getScene().getWindow().hide();
          Parent root = fxWeaver.loadView(CalculatorFoodEmissionsController.class);
          Stage stage = new Stage();
          stage.setScene(new Scene(root));
          stage.show();
        });
  }
}
