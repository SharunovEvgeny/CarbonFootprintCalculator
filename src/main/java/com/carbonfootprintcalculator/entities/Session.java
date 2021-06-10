package com.carbonfootprintcalculator.entities;

import com.carbonfootprintcalculator.interfaces.Calculable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sessions")
public class Session implements Calculable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "life_emissions_co2", nullable = false)
  private int lifeEmissionsCo2;

  @Column(name = "car_emissions_co2", nullable = false)
  private int carEmissionsCo2;

  @Column(name = "electricity_emissions_co2", nullable = false)
  private int electricityEmissionsCo2;

  @Column(name = "food_emissions_co2", nullable = false)
  private int foodEmissionsCo2;

  @Column(name = "gas_emissions_co2", nullable = false)
  private int gasEmissionsCo2;

  @Column(name = "all_emissions_co2", nullable = false)
  private int allCo2Emissions;

  public Session(
      int lifeEmissionsCo2,
      int carEmissionsCo2,
      int electricityEmissionsCo2,
      int foodEmissionsCo2,
      int gasEmissionsCo2) {
    this.lifeEmissionsCo2 = lifeEmissionsCo2;
    this.carEmissionsCo2 = carEmissionsCo2;
    this.electricityEmissionsCo2 = electricityEmissionsCo2;
    this.foodEmissionsCo2 = foodEmissionsCo2;
    this.gasEmissionsCo2 = gasEmissionsCo2;
  }

  public Session() {}

  @Override
  public int calculateEmissions() {
    allCo2Emissions =
        gasEmissionsCo2
            + electricityEmissionsCo2
            + foodEmissionsCo2
            + carEmissionsCo2
            + lifeEmissionsCo2;
    return allCo2Emissions;
  }

  @Override
  public String toString() {
    return "Session{"
        + "id="
        + id
        + ", lifeEmissionsCo2="
        + lifeEmissionsCo2
        + ", carEmissionsCo2="
        + carEmissionsCo2
        + ", electricityEmissionsCo2="
        + electricityEmissionsCo2
        + ", foodEmissionsCo2="
        + foodEmissionsCo2
        + ", gasEmissionsCo2="
        + gasEmissionsCo2
        + ", allCo2Emissions="
        + allCo2Emissions
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Session session = (Session) o;
    return lifeEmissionsCo2 == session.lifeEmissionsCo2
        && carEmissionsCo2 == session.carEmissionsCo2
        && electricityEmissionsCo2 == session.electricityEmissionsCo2
        && foodEmissionsCo2 == session.foodEmissionsCo2
        && gasEmissionsCo2 == session.gasEmissionsCo2
        && allCo2Emissions == session.allCo2Emissions
        && id.equals(session.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        lifeEmissionsCo2,
        carEmissionsCo2,
        electricityEmissionsCo2,
        foodEmissionsCo2,
        gasEmissionsCo2,
        allCo2Emissions);
  }

  public int getAllCo2Emissions() {
    return allCo2Emissions;
  }

  public void setAllCo2Emissions(int allCo2Emissions) {
    this.allCo2Emissions = allCo2Emissions;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getLifeEmissionsCo2() {
    return lifeEmissionsCo2;
  }

  public void setLifeEmissionsCo2(int lifeEmissionsCo2) {
    this.lifeEmissionsCo2 = lifeEmissionsCo2;
  }

  public int getCarEmissionsCo2() {
    return carEmissionsCo2;
  }

  public void setCarEmissionsCo2(int carEmissionsCo2) {
    this.carEmissionsCo2 = carEmissionsCo2;
  }

  public int getElectricityEmissionsCo2() {
    return electricityEmissionsCo2;
  }

  public void setElectricityEmissionsCo2(int electricityEmissionsCo2) {
    this.electricityEmissionsCo2 = electricityEmissionsCo2;
  }

  public int getFoodEmissionsCo2() {
    return foodEmissionsCo2;
  }

  public void setFoodEmissionsCo2(int foodEmissionsCo2) {
    this.foodEmissionsCo2 = foodEmissionsCo2;
  }

  public int getGasEmissionsCo2() {
    return gasEmissionsCo2;
  }

  public void setGasEmissionsCo2(int gasEmissionsCo2) {
    this.gasEmissionsCo2 = gasEmissionsCo2;
  }
}
