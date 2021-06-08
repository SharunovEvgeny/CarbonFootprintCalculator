package com.carbonfootprintcalculator.entities;

import com.carbonfootprintcalculator.interfaces.Calculable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "calculators_car_emissions")
public class CalculatorCarEmissions implements Calculable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "emissions_coefficient", nullable = false)
  private final double emissionsCoefficient = 2.32;

  @Column(name = "indirect_emissions_coefficient", nullable = false)
  private final double indirectEmissionsCoefficient = 0.41;

  @Column(name = "liter_per_100km", nullable = false)
  private int literPer100km;

  public CalculatorCarEmissions() {}

  public CalculatorCarEmissions(int literPer100km) {

    this.literPer100km = literPer100km;
  }

  @Override
  public int calculateEmissions() {
    return (int)
        Math.round(
            (getLiterPer100km() * getEmissionsCoefficient()) * 10
                + getIndirectEmissionsCoefficient() * getLiterPer100km() * 10);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CalculatorCarEmissions that = (CalculatorCarEmissions) o;
    return literPer100km == that.literPer100km && id.equals(that.id);
  }

  @Override
  public String toString() {
    return "CalculatorCarEmissions{"
        + "id="
        + id
        + ", emissionsCoefficient="
        + emissionsCoefficient
        + ", indirectEmissionsCoefficient="
        + indirectEmissionsCoefficient
        + ", literPer100km="
        + literPer100km
        + '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, emissionsCoefficient, indirectEmissionsCoefficient, literPer100km);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getLiterPer100km() {
    return literPer100km;
  }

  public void setLiterPer100km(int literPer100km) {
    this.literPer100km = literPer100km;
  }

  public double getEmissionsCoefficient() {
    return emissionsCoefficient;
  }

  public double getIndirectEmissionsCoefficient() {
    return indirectEmissionsCoefficient;
  }
}
