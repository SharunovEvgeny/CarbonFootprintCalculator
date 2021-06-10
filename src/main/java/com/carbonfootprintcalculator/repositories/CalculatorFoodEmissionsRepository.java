package com.carbonfootprintcalculator.repositories;

import com.carbonfootprintcalculator.entities.CalculatorFoodEmissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorFoodEmissionsRepository
    extends JpaRepository<CalculatorFoodEmissions, Long> {}
