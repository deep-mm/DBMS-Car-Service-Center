package com.dbms.team15.models;

public class ServiceCenterProvidesService {

  private int SERVICE_CENTER_ID;
  private int ID;
  private int CAR_ID;
  private double PRICE;

  public ServiceCenterProvidesService() {}

  public ServiceCenterProvidesService(
    int SERVICE_CENTER_ID,
    int ID,
    int CAR_ID,
    double PRICE
  ) {
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
    this.ID = ID;
    this.CAR_ID = CAR_ID;
    this.PRICE = PRICE;
  }

  public int getSERVICE_CENTER_ID() {
    return SERVICE_CENTER_ID;
  }

  public int getID() {
    return ID;
  }

  public int getCAR_ID() {
    return CAR_ID;
  }

  public double getPRICE() {
    return PRICE;
  }

  public void setSERVICE_CENTER_ID(int SERVICE_CENTER_ID) {
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setCAR_ID(int CAR_ID) {
    this.CAR_ID = CAR_ID;
  }

  public void setPRICE(double PRICE) {
    this.PRICE = PRICE;
  }

  @Override
  public String toString() {
    return (
      "ServiceCenterProvidesService{" +
      "SERVICE_CENTER_ID=" +
      SERVICE_CENTER_ID +
      ", ID=" +
      ID +
      ", CAR_ID=" +
      CAR_ID +
      ", PRICE=" +
      PRICE +
      '}'
    );
  }
}
