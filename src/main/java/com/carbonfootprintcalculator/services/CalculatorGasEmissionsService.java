package com.carbonfootprintcalculator.services;

import com.carbonfootprintcalculator.entities.CalculatorGasEmissions;
import com.carbonfootprintcalculator.repositories.CalculatorGasEmissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorGasEmissionsService {
  @Autowired CalculatorGasEmissionsRepository calculatorGasEmissionsRepository;

  public int calculateAllEmissions(int kWh) {
    CalculatorGasEmissions calculatorGasEmissions = new CalculatorGasEmissions(kWh);
    calculatorGasEmissions.calculateEmissions();
    calculatorGasEmissionsRepository.save(calculatorGasEmissions);
    return calculatorGasEmissions.getCo2();
  }
}
