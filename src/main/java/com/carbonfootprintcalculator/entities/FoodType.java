package com.carbonfootprintcalculator.entities;

public enum FoodType {
  often(3000),
  usally(2100),
  seldom(1500),
  never(800);
  private final int value;

  private FoodType(final int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
