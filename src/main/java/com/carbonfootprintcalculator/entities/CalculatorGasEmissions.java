package com.carbonfootprintcalculator.entities;

import com.carbonfootprintcalculator.interfaces.Calculable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "calculators_gas_emissions")
public class CalculatorGasEmissions implements Calculable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "emissions_coefficient", nullable = false)
  private final double emissionsCoefficient = 0.203;

  @Column(name = "kWh", nullable = false)
  private int kWh;

  @Column(name = "CO2", nullable = false)
  private int co2;

  @Override
  public int calculateEmissions() {
    co2 = (int) Math.round((emissionsCoefficient * kWh));
    return co2;
  }

  public CalculatorGasEmissions(int kWh) {
    this.kWh = kWh;
  }

  public CalculatorGasEmissions() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getEmissionsCoefficient() {
    return emissionsCoefficient;
  }

  public int getkWh() {
    return kWh;
  }

  public void setkWh(int kWh) {
    this.kWh = kWh;
  }

  public int getCo2() {
    return co2;
  }

  public void setCo2(int co2) {
    this.co2 = co2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CalculatorGasEmissions that = (CalculatorGasEmissions) o;
    return Double.compare(that.emissionsCoefficient, emissionsCoefficient) == 0
        && kWh == that.kWh
        && co2 == that.co2
        && id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, emissionsCoefficient, kWh, co2);
  }

  @Override
  public String toString() {
    return "CalculatorGasEmissions{"
        + "id="
        + id
        + ", emissionsCoefficient="
        + emissionsCoefficient
        + ", kWh="
        + kWh
        + ", co2="
        + co2
        + '}';
  }
}
