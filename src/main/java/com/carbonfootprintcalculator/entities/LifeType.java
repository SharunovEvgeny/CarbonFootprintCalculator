package com.carbonfootprintcalculator.entities;

public enum LifeType {
  AboveAverage(5000),
  Average(3400),
  BelowAverage(2400),
  MuchBelowAverage(1400);
  private final int value;

  private LifeType(final int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
