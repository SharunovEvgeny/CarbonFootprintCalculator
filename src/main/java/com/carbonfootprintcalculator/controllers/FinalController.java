package com.carbonfootprintcalculator.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.carbonfootprintcalculator.services.SessionService;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/view/final.fxml")
public class FinalController {
  @Autowired SessionService sessionService;
  @Autowired FxWeaver fxWeaver;

  @FXML private ResourceBundle resources;

  @FXML private URL location;

  @FXML private Button restartButton;

  @FXML private Label finalText;

  @FXML
  void initialize() {
    setFinalText();
    nextButtonAction();
  }

  private void setFinalText() {
    finalText.setText(String.valueOf(sessionService.getAllCo2()));
  }

  private void nextButtonAction() {
    restartButton.setOnAction(
        event -> {
          restartButton.getScene().getWindow().hide();
          Parent root = fxWeaver.loadView(MainController.class);
          Stage stage = new Stage();
          stage.setScene(new Scene(root));
          stage.show();
        });
  }
}
