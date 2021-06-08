package com.carbonfootprintcalculator.services;

import com.carbonfootprintcalculator.entities.CalculatorElectricityEmissions;
import org.springframework.stereotype.Service;

@Service
public class CalculatorElectricityEmissionsService {
  public int calculateAllEmissions(int kWh) {
    CalculatorElectricityEmissions calculatorElectricityEmissions =
        new CalculatorElectricityEmissions(kWh);
    return calculatorElectricityEmissions.calculateEmissions();
  }
}
