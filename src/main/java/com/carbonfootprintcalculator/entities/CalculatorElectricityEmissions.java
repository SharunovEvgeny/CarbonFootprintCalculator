package com.carbonfootprintcalculator.entities;

import com.carbonfootprintcalculator.interfaces.Calculable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "calculators_electricity_emissions")
public class CalculatorElectricityEmissions implements Calculable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "emissions_coefficient", nullable = false)
  private final double emissionsCoefficient = 0.309;

  @Column(name = "kWh", nullable = false)
  private int kWh;

  @Column(name = "CO2", nullable = false)
  private int co2;

  public CalculatorElectricityEmissions(int kWh) {
    this.kWh = kWh;
  }

  public CalculatorElectricityEmissions() {}

  @Override
  public int calculateEmissions() {
    co2 = (int) Math.round((emissionsCoefficient * kWh));
    return co2;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getkWh() {
    return kWh;
  }

  public void setkWh(int kWh) {
    this.kWh = kWh;
  }

  public double getEmissionsCoefficient() {
    return emissionsCoefficient;
  }

  public int getCo2() {
    return co2;
  }

  public void setCo2(int co2) {
    this.co2 = co2;
  }

  @Override
  public String toString() {
    return "CalculatorElectricityEmissions{"
        + "id="
        + id
        + ", emissionsCoefficient="
        + emissionsCoefficient
        + ", kWh="
        + kWh
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CalculatorElectricityEmissions that = (CalculatorElectricityEmissions) o;
    return kWh == that.kWh && id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, emissionsCoefficient, kWh);
  }
}
