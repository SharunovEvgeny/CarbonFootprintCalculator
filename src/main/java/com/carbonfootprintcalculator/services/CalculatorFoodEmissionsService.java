package com.carbonfootprintcalculator.services;

import com.carbonfootprintcalculator.entities.CalculatorFoodEmissions;
import com.carbonfootprintcalculator.entities.FoodType;
import com.carbonfootprintcalculator.repositories.CalculatorFoodEmissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorFoodEmissionsService {
  @Autowired CalculatorFoodEmissionsRepository calculatorFoodEmissionsRepository;

  public int calculateAllEmissions(FoodType foodType) {
    CalculatorFoodEmissions calculatorFoodEmissions = new CalculatorFoodEmissions(foodType);
    calculatorFoodEmissions.calculateEmissions();
    calculatorFoodEmissionsRepository.save(calculatorFoodEmissions);
    return calculatorFoodEmissions.getCo2();
  }
}
