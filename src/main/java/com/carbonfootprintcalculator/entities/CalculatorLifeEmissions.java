package com.carbonfootprintcalculator.entities;

import com.carbonfootprintcalculator.interfaces.Calculable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "calculators_life_emissions")
public class CalculatorLifeEmissions implements Calculable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "co2", nullable = false)
  private int co2;

  @Column(name = "life_type", nullable = false)
  @Enumerated(EnumType.STRING)
  private LifeType lifeType;

  public CalculatorLifeEmissions(LifeType lifeType) {
    this.lifeType = lifeType;
  }

  public CalculatorLifeEmissions() {
  }

  @Override
  public int calculateEmissions() {
    setlifeType(lifeType);
    setCo2(lifeType.getValue());
    return getCo2();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getCo2() {
    return co2;
  }

  public void setCo2(int co2) {
    this.co2 = co2;
  }

  public LifeType getlifeType() {
    return lifeType;
  }

  public void setlifeType(LifeType lifeType) {
    this.lifeType = lifeType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CalculatorLifeEmissions that = (CalculatorLifeEmissions) o;
    return co2 == that.co2 && id.equals(that.id) && lifeType == that.lifeType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, co2, lifeType);
  }

  @Override
  public String toString() {
    return "CalculatorFoodEmissions{"
        + "id="
        + id
        + ", co2="
        + co2
        + ", lifeType="
        + lifeType
        + '}';
  }
}
