package com.carbonfootprintcalculator;


import com.carbonfootprintcalculator.controllers.ConfigurationControllers;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class CarbonFootprintCalculatorApplication extends AbstractJavaFxApplicationSupport {

	@Value("${ui.title:JavaFX приложение}")//
	private String windowTitle;

	@Autowired
	private ConfigurationControllers.ViewHolder view;

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle(windowTitle);
		stage.setScene(new Scene(view.getView()));
		stage.setResizable(true);
		stage.centerOnScreen();
		stage.show();
	}

	public static void main(String[] args) {
		launchApp(CarbonFootprintCalculatorApplication.class, args);
	}

}