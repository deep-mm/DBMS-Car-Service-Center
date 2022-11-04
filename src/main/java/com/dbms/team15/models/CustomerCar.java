package com.dbms.team15.models;

public class CustomerCar {

  private int VIN;
  private double MILEAGE;
  private int LAST_SCHEDULED_MAINTENANCE;
  private int CUSTOMER_ID;
  private int SERVICE_CENTER_ID;
  private int CAR_ID;

  public CustomerCar() {}

  public CustomerCar(
    int VIN,
    double MILEAGE,
    int LAST_SCHEDULED_MAINTENANCE,
    int CUSTOMER_ID,
    int SERVICE_CENTER_ID,
    int CAR_ID
  ) {
    this.VIN = VIN;
    this.MILEAGE = MILEAGE;
    this.LAST_SCHEDULED_MAINTENANCE = LAST_SCHEDULED_MAINTENANCE;
    this.CUSTOMER_ID = CUSTOMER_ID;
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
    this.CAR_ID = CAR_ID;
  }

  public int getVIN() {
    return VIN;
  }

  public double getMILEAGE() {
    return MILEAGE;
  }

  public int getLAST_SCHEDULED_MAINTENANCE() {
    return LAST_SCHEDULED_MAINTENANCE;
  }

  public int getCUSTOMER_ID() {
    return CUSTOMER_ID;
  }

  public int getSERVICE_CENTER_ID() {
    return SERVICE_CENTER_ID;
  }

  public int getCAR_ID() {
    return CAR_ID;
  }

  public void setVIN(int VIN) {
    this.VIN = VIN;
  }

  public void setMILEAGE(double MILEAGE) {
    this.MILEAGE = MILEAGE;
  }

  public void setLAST_SCHEDULED_MAINTENANCE(int LAST_SCHEDULED_MAINTENANCE) {
    this.LAST_SCHEDULED_MAINTENANCE = LAST_SCHEDULED_MAINTENANCE;
  }

  public void setCUSTOMER_ID(int CUSTOMER_ID) {
    this.CUSTOMER_ID = CUSTOMER_ID;
  }

  public void setSERVICE_CENTER_ID(int SERVICE_CENTER_ID) {
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
  }

  public void setCAR_ID(int CAR_ID) {
    this.CAR_ID = CAR_ID;
  }

  //To String
  @Override
  public String toString() {
    return (
      "CustomerCar{" +
      "VIN=" +
      VIN +
      ", MILEAGE=" +
      MILEAGE +
      ", LAST_SCHEDULED_MAINTENANCE=" +
      LAST_SCHEDULED_MAINTENANCE +
      ", CUSTOMER_ID=" +
      CUSTOMER_ID +
      ", SERVICE_CENTER_ID=" +
      SERVICE_CENTER_ID +
      ", CAR_ID=" +
      CAR_ID +
      '}'
    );
  }
}
