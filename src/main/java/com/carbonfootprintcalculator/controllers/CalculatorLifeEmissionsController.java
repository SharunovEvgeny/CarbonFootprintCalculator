package com.carbonfootprintcalculator.controllers;

import com.carbonfootprintcalculator.entities.LifeType;
import com.carbonfootprintcalculator.services.CalculatorLifeEmissionsService;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/view/calculatorLifeEmissions.fxml")
public class CalculatorLifeEmissionsController {
  @Autowired FxWeaver fxWeaver;
  @Autowired CalculatorLifeEmissionsService calculatorLifeEmissionsService;
  @FXML private ResourceBundle resources;

  @FXML private URL location;

  @FXML private Button nextButton;

  @FXML private Button backButton;

  @FXML private Button calculateButton;

  @FXML private RadioButton getMuchBelowAverage;

  @FXML private RadioButton getAboveAverage;

  @FXML private RadioButton getAverage;

  @FXML private RadioButton getBelowAverage;

  @FXML private TextField postCO2;

  private ToggleGroup toggleGroup;

  @FXML
  void initialize() {
    backButtonAction();
    nextButtonAction();
    toggleGroup = new ToggleGroup();
    getAboveAverage.setToggleGroup(toggleGroup);
    getAverage.setToggleGroup(toggleGroup);
    getBelowAverage.setToggleGroup(toggleGroup);
    getMuchBelowAverage.setToggleGroup(toggleGroup);
    calculateButtonAction();
  }

  private void backButtonAction() {
    backButton.setOnAction(
        event -> {
          backButton.getScene().getWindow().hide();
          Parent root = fxWeaver.loadView(CalculatorFoodEmissionsController.class);
          Stage stage = new Stage();
          stage.setScene(new Scene(root));
          stage.show();
        });
  }

  private void calculateButtonAction() {
    calculateButton.setOnAction(
        event -> {
          if (toggleGroup.getSelectedToggle() == null) {
            postCO2.setText("Выберите один из вариантов");
            return;
          }
          if (toggleGroup.getSelectedToggle().equals(getAboveAverage)) {
            postCO2.setText(
                String.valueOf(
                    calculatorLifeEmissionsService.calculateAllEmissions(LifeType.AboveAverage)));
          }
          if (toggleGroup.getSelectedToggle().equals(getAverage)) {
            postCO2.setText(
                String.valueOf(
                    calculatorLifeEmissionsService.calculateAllEmissions(LifeType.Average)));
          }
          if (toggleGroup.getSelectedToggle().equals(getBelowAverage)) {
            postCO2.setText(
                String.valueOf(
                    calculatorLifeEmissionsService.calculateAllEmissions(LifeType.BelowAverage)));
          }
          if (toggleGroup.getSelectedToggle().equals(getMuchBelowAverage)) {
            postCO2.setText(
                String.valueOf(
                    calculatorLifeEmissionsService.calculateAllEmissions(
                        LifeType.MuchBelowAverage)));
          }
        });
  }

  private void nextButtonAction() {
    nextButton.setOnAction(
        event -> {
          nextButton.getScene().getWindow().hide();
          Parent root = fxWeaver.loadView(CalculatorFoodEmissionsController.class);
          Stage stage = new Stage();
          stage.setScene(new Scene(root));
          stage.show();
        });
  }
}
