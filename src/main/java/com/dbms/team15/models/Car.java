package com.dbms.team15.models;

public class Car {

  private int CAR_ID;
  private String MANUFACTURER;
  private int YEAR;

  public Car() {}

  // Create constructor
  public Car(int CAR_ID, String MANUFACTURER, int YEAR) {
    this.CAR_ID = CAR_ID;
    this.MANUFACTURER = MANUFACTURER;
    this.YEAR = YEAR;
  }

  // Create getters
  public int getCAR_ID() {
    return CAR_ID;
  }

  public String getMANUFACTURER() {
    return MANUFACTURER;
  }

  public int getYEAR() {
    return YEAR;
  }

  // Create setters
  public void setCAR_ID(int CAR_ID) {
    this.CAR_ID = CAR_ID;
  }

  public void setMANUFACTURER(String MANUFACTURER) {
    this.MANUFACTURER = MANUFACTURER;
  }

  public void setYEAR(int YEAR) {
    this.YEAR = YEAR;
  }

  //To String
  @Override
  public String toString() {
    return (
      "Car{" +
      "CAR_ID=" +
      CAR_ID +
      ", MANUFACTURER='" +
      MANUFACTURER +
      '\'' +
      ", YEAR=" +
      YEAR +
      '}'
    );
  }
}
