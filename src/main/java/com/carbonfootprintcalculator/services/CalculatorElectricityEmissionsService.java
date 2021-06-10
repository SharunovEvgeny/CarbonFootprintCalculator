package com.carbonfootprintcalculator.services;

import com.carbonfootprintcalculator.entities.CalculatorElectricityEmissions;
import com.carbonfootprintcalculator.repositories.CalculatorElectricityEmissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorElectricityEmissionsService {

  @Autowired CalculatorElectricityEmissionsRepository calculatorElectricityEmissionsRepository;

  public int calculateAllEmissions(int kWh) {
    CalculatorElectricityEmissions calculatorElectricityEmissions =
        new CalculatorElectricityEmissions(kWh);
    calculatorElectricityEmissions.calculateEmissions();
    calculatorElectricityEmissionsRepository.save(calculatorElectricityEmissions);
    return calculatorElectricityEmissions.getCo2();
  }
}
