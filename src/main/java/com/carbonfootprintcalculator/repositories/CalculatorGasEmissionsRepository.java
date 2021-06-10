package com.carbonfootprintcalculator.repositories;

import com.carbonfootprintcalculator.entities.CalculatorGasEmissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorGasEmissionsRepository
    extends JpaRepository<CalculatorGasEmissions, Long> {}
