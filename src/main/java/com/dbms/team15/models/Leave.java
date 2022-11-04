package com.dbms.team15.models;

public class Leave {

  private int LEAVE_ID;
  private String START_DATE;
  private String END_DATE;
  private int STATUS;
  private int EMPLOYEE_ID;
  private int SERVICE_CENTER_ID;

  public Leave() {}

  public Leave(
    int LEAVE_ID,
    String START_DATE,
    String END_DATE,
    int STATUS,
    int EMPLOYEE_ID,
    int SERVICE_CENTER_ID
  ) {
    this.LEAVE_ID = LEAVE_ID;
    this.START_DATE = START_DATE;
    this.END_DATE = END_DATE;
    this.STATUS = STATUS;
    this.EMPLOYEE_ID = EMPLOYEE_ID;
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
  }

  public int getLEAVE_ID() {
    return LEAVE_ID;
  }

  public String getSTART_DATE() {
    return START_DATE;
  }

  public String getEND_DATE() {
    return END_DATE;
  }

  public int getSTATUS() {
    return STATUS;
  }

  public int getEMPLOYEE_ID() {
    return EMPLOYEE_ID;
  }

  public int getSERVICE_CENTER_ID() {
    return SERVICE_CENTER_ID;
  }

  public void setLEAVE_ID(int LEAVE_ID) {
    this.LEAVE_ID = LEAVE_ID;
  }

  public void setSTART_DATE(String START_DATE) {
    this.START_DATE = START_DATE;
  }

  public void setEND_DATE(String END_DATE) {
    this.END_DATE = END_DATE;
  }

  public void setSTATUS(int STATUS) {
    this.STATUS = STATUS;
  }

  public void setEMPLOYEE_ID(int EMPLOYEE_ID) {
    this.EMPLOYEE_ID = EMPLOYEE_ID;
  }

  public void setSERVICE_CENTER_ID(int SERVICE_CENTER_ID) {
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
  }

  @Override
  public String toString() {
    return (
      "Leave{" +
      "LEAVE_ID=" +
      LEAVE_ID +
      ", START_DATE='" +
      START_DATE +
      '\'' +
      ", END_DATE='" +
      END_DATE +
      '\'' +
      ", STATUS=" +
      STATUS +
      ", EMPLOYEE_ID=" +
      EMPLOYEE_ID +
      ", SERVICE_CENTER_ID=" +
      SERVICE_CENTER_ID +
      '}'
    );
  }
}
