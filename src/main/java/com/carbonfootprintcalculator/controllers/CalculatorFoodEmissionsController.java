package com.carbonfootprintcalculator.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.carbonfootprintcalculator.entities.FoodType;
import com.carbonfootprintcalculator.services.CalculatorFoodEmissionsService;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/view/calculatorFoodEmissions.fxml")
public class CalculatorFoodEmissionsController {
  @Autowired FxWeaver fxWeaver;
  @Autowired CalculatorFoodEmissionsService calculatorFoodEmissionsService;
  @FXML private ResourceBundle resources;

  @FXML private URL location;

  @FXML private Button nextButton;

  @FXML private Button backButton;

  @FXML private RadioButton getSeldom;

  @FXML private Button calculateButton;

  @FXML private RadioButton getOften;

  @FXML private RadioButton getUsually;

  @FXML private RadioButton getNever;

  @FXML private TextField postCO2;

  private ToggleGroup toggleGroup;

  @FXML
  void initialize() {
    backButtonAction();
    nextButtonAction();
    toggleGroup = new ToggleGroup();
    getOften.setToggleGroup(toggleGroup);
    getUsually.setToggleGroup(toggleGroup);
    getNever.setToggleGroup(toggleGroup);
    getSeldom.setToggleGroup(toggleGroup);
    calculateButtonAction();
  }

  private void backButtonAction() {
    backButton.setOnAction(
        event -> {
          backButton.getScene().getWindow().hide();
          Parent root = fxWeaver.loadView(CalculatorCarEmissionsController.class);
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
          if (toggleGroup.getSelectedToggle().equals(getOften)) {
            postCO2.setText(
                String.valueOf(
                    calculatorFoodEmissionsService.calculateAllEmissions(FoodType.often)));
          }
          if (toggleGroup.getSelectedToggle().equals(getUsually)) {
            postCO2.setText(
                String.valueOf(
                    calculatorFoodEmissionsService.calculateAllEmissions(FoodType.usally)));
          }
          if (toggleGroup.getSelectedToggle().equals(getNever)) {
            postCO2.setText(
                String.valueOf(
                    calculatorFoodEmissionsService.calculateAllEmissions(FoodType.never)));
          }
          if (toggleGroup.getSelectedToggle().equals(getSeldom)) {
            postCO2.setText(
                String.valueOf(
                    calculatorFoodEmissionsService.calculateAllEmissions(FoodType.seldom)));
          }
        });
  }

  private void nextButtonAction() {
    nextButton.setOnAction(
        event -> {
          nextButton.getScene().getWindow().hide();
          Parent root = fxWeaver.loadView(CalculatorLifeEmissionsController.class);
          Stage stage = new Stage();
          stage.setScene(new Scene(root));
          stage.show();
        });
  }
}
