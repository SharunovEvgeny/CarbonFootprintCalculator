package com.carbonfootprintcalculator.repositories;

import com.carbonfootprintcalculator.entities.CalculatorCarEmissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorCarEmissionsRepository
    extends JpaRepository<CalculatorCarEmissions, Long> {}
