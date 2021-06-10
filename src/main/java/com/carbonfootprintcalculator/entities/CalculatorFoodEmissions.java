package com.carbonfootprintcalculator.entities;

import com.carbonfootprintcalculator.interfaces.Calculable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "calculators_food_emissions")
public class CalculatorFoodEmissions implements Calculable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "CO2", nullable = false)
  private int co2;

  @Column(name = "food_type", nullable = false)
  @Enumerated(EnumType.STRING)
  private FoodType foodType;

  public CalculatorFoodEmissions(FoodType foodType) {
    this.foodType = foodType;
  }

  public CalculatorFoodEmissions() {
  }

  @Override
  public int calculateEmissions() {
    setFoodType(foodType);
    setCo2(foodType.getValue());
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

  public FoodType getFoodType() {
    return foodType;
  }

  public void setFoodType(FoodType foodType) {
    this.foodType = foodType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CalculatorFoodEmissions that = (CalculatorFoodEmissions) o;
    return co2 == that.co2 && id.equals(that.id) && foodType == that.foodType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, co2, foodType);
  }

  @Override
  public String toString() {
    return "CalculatorFoodEmissions{"
        + "id="
        + id
        + ", co2="
        + co2
        + ", foodType="
        + foodType
        + '}';
  }
}
