package com.dbms.team15.models;

public class ServicesCar {

  private int ID;
  private int CAR_ID;
  private double TIME_ESTIMATED;

  public ServicesCar() {}

  public ServicesCar(int ID, int CAR_ID, double TIME_ESTIMATED) {
    this.ID = ID;
    this.CAR_ID = CAR_ID;
    this.TIME_ESTIMATED = TIME_ESTIMATED;
  }

  public int getID() {
    return ID;
  }

  public int getCAR_ID() {
    return CAR_ID;
  }

  public double getTIME_ESTIMATED() {
    return TIME_ESTIMATED;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setCAR_ID(int CAR_ID) {
    this.CAR_ID = CAR_ID;
  }

  public void setTIME_ESTIMATED(double TIME_ESTIMATED) {
    this.TIME_ESTIMATED = TIME_ESTIMATED;
  }

  @Override
  public String toString() {
    return (
      "ServicesCar{" +
      "ID=" +
      ID +
      ", CAR_ID=" +
      CAR_ID +
      ", TIME_ESTIMATED=" +
      TIME_ESTIMATED +
      '}'
    );
  }
}
