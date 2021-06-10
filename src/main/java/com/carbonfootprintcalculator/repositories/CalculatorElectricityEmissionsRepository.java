package com.carbonfootprintcalculator.repositories;

import com.carbonfootprintcalculator.entities.CalculatorElectricityEmissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorElectricityEmissionsRepository
    extends JpaRepository<CalculatorElectricityEmissions, Long> {}
