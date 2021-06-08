package com.carbonfootprintcalculator.services;

import com.carbonfootprintcalculator.entities.CalculatorCarEmissions;
import org.springframework.stereotype.Service;

@Service
public class CalculatorCarEmissionsService {

	public int calculateAllEmissions(int literPer100km){
		CalculatorCarEmissions calculatorCarEmissions = new CalculatorCarEmissions(literPer100km);
		return calculatorCarEmissions.calculateEmissions();
	}
}
