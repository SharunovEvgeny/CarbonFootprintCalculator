package com.carbonfootprintcalculator.repositories;

import com.carbonfootprintcalculator.entities.CalculatorLifeEmissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorLifeEmissionsRepository
    extends JpaRepository<CalculatorLifeEmissions, Long> {}
