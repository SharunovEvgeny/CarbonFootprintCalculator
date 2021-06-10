package com.carbonfootprintcalculator;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarbonFootprintCalculatorApplication {
  public static void main(String[] args) {
    Application.launch(JavaFxApplication.class, args);
  }
}
