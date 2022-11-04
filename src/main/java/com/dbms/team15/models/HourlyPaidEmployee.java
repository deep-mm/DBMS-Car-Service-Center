package com.dbms.team15.models;

public class HourlyPaidEmployee {

  private int EMPLOYEE_ID;
  private int SERVICE_CENTER_ID;
  private double HOURLY_RATE;

  public HourlyPaidEmployee() {}

  public HourlyPaidEmployee(
    int EMPLOYEE_ID,
    int SERVICE_CENTER_ID,
    double HOURLY_RATE
  ) {
    this.EMPLOYEE_ID = EMPLOYEE_ID;
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
    this.HOURLY_RATE = HOURLY_RATE;
  }

  public int getEMPLOYEE_ID() {
    return EMPLOYEE_ID;
  }

  public int getSERVICE_CENTER_ID() {
    return SERVICE_CENTER_ID;
  }

  public double getHOURLY_RATE() {
    return HOURLY_RATE;
  }

  public void setEMPLOYEE_ID(int EMPLOYEE_ID) {
    this.EMPLOYEE_ID = EMPLOYEE_ID;
  }

  public void setSERVICE_CENTER_ID(int SERVICE_CENTER_ID) {
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
  }

  public void setHOURLY_RATE(double HOURLY_RATE) {
    this.HOURLY_RATE = HOURLY_RATE;
  }

  @Override
  public String toString() {
    return (
      "HourlyPaidEmployee{" +
      "EMPLOYEE_ID=" +
      EMPLOYEE_ID +
      ", SERVICE_CENTER_ID=" +
      SERVICE_CENTER_ID +
      ", HOURLY_RATE=" +
      HOURLY_RATE +
      '}'
    );
  }
}
