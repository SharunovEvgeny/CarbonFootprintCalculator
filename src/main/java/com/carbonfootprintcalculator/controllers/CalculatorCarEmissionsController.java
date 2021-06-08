package com.carbonfootprintcalculator.controllers;

import com.carbonfootprintcalculator.services.CalculatorCarEmissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculatorCarEmissions")
public class CalculatorCarEmissionsController {

	@Autowired
	CalculatorCarEmissionsService calculatorCarEmissionsService;

	@GetMapping(value = "/{litr_per_100km}")
	public ResponseEntity<Integer> getCarEmissions(@PathVariable int litr_per_100km) {
		if (litr_per_100km < 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(
						calculatorCarEmissionsService.calculateAllEmissions(litr_per_100km), HttpStatus.OK);
	}
}
