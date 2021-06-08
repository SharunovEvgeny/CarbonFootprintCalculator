package com.carbonfootprintcalculator.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ConfigurationControllers {

	@Bean(name = "mainView")
	public ViewHolder getMainView() throws IOException {
		return loadView("fxml/main.fxml");
	}

//	@Bean(name = "calculatorElectricityEmissionsController")
//	public ViewHolder getCalculatorElectricityEmissionsControllerView() throws IOException {
//		return loadView("fxml/calculatorElectricityEmissions.fxml");
//	}

	@Bean
	public MainController getMainController() throws IOException {
		return (MainController) getMainView().getController();
	}

//	@Bean
//	public CalculatorElectricityEmissionsController getCalculatorElectricityEmissionsController() throws IOException {
//		return (CalculatorElectricityEmissionsController) getCalculatorElectricityEmissionsControllerView().getController();
//	}

	/**
	 * Самый обыкновенный способ использовать FXML загрузчик.
	 * Как раз-таки на этом этапе будет создан объект-контроллер,
	 * произведены все FXML инъекции и вызван метод инициализации контроллера.
	 */
	protected ViewHolder loadView(String url) throws IOException {
		InputStream fxmlStream = null;
		try {
			fxmlStream = getClass().getClassLoader().getResourceAsStream(url);
			FXMLLoader loader = new FXMLLoader();
			loader.load(fxmlStream);
			return new ViewHolder(loader.getRoot(), loader.getController());
		} finally {
			if (fxmlStream != null) {
				fxmlStream.close();
			}
		}
	}

	/**
	 * Класс - оболочка: контроллер мы обязаны указать в качестве бина,
	 * а view - представление, нам предстоит использовать в точке входа {@link Application}.
	 */
	public class ViewHolder {
		private Parent view;
		private Object controller;

		public ViewHolder(Parent view, Object controller) {
			this.view = view;
			this.controller = controller;
		}

		public Parent getView() {
			return view;
		}

		public void setView(Parent view) {
			this.view = view;
		}

		public Object getController() {
			return controller;
		}

		public void setController(Object controller) {
			this.controller = controller;
		}
	}

}