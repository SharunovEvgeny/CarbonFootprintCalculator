package com.carbonfootprintcalculator.services;

import com.carbonfootprintcalculator.entities.CalculatorCarEmissions;
import com.carbonfootprintcalculator.repositories.CalculatorCarEmissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorCarEmissionsService {
  @Autowired CalculatorCarEmissionsRepository calculatorCarEmissionsRepository;

  public int calculateAllEmissions(int literPer100km, int numberKm) {
    CalculatorCarEmissions calculatorCarEmissions =
        new CalculatorCarEmissions(literPer100km, numberKm);
    calculatorCarEmissions.calculateEmissions();
    calculatorCarEmissionsRepository.save(calculatorCarEmissions);
    return calculatorCarEmissions.getCo2();
  }
}
