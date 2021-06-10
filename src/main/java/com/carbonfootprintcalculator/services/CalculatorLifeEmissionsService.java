package com.carbonfootprintcalculator.services;

import com.carbonfootprintcalculator.entities.CalculatorLifeEmissions;
import com.carbonfootprintcalculator.entities.LifeType;
import com.carbonfootprintcalculator.repositories.CalculatorLifeEmissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorLifeEmissionsService {
  @Autowired CalculatorLifeEmissionsRepository calculatorLifeEmissionsRepository;

  public int calculateAllEmissions(LifeType lifeType) {
    CalculatorLifeEmissions calculatorLifeEmissions = new CalculatorLifeEmissions(lifeType);
    calculatorLifeEmissions.calculateEmissions();
    calculatorLifeEmissionsRepository.save(calculatorLifeEmissions);
    return calculatorLifeEmissions.getCo2();
  }
}
