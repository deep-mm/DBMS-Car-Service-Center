package com.dbms.team15.models;

public class ServiceEvent {

  private int SERVICE_ID;
  private int ID;
  private int MECHANIC_ID;
  private int SERVICE_CENTER_ID;
  private int VIN;
  private int INVOICE_ID;
  private String START_TIME;
  private String END_TIME;

  public ServiceEvent() {}

  public ServiceEvent(
    int SERVICE_ID,
    int ID,
    int MECHANIC_ID,
    int SERVICE_CENTER_ID,
    int VIN,
    int INVOICE_ID,
    String START_TIME,
    String END_TIME
  ) {
    this.SERVICE_ID = SERVICE_ID;
    this.ID = ID;
    this.MECHANIC_ID = MECHANIC_ID;
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
    this.VIN = VIN;
    this.INVOICE_ID = INVOICE_ID;
    this.START_TIME = START_TIME;
    this.END_TIME = END_TIME;
  }

  public int getSERVICE_ID() {
    return SERVICE_ID;
  }

  public int getID() {
    return ID;
  }

  public int getMECHANIC_ID() {
    return MECHANIC_ID;
  }

  public int getSERVICE_CENTER_ID() {
    return SERVICE_CENTER_ID;
  }

  public int getVIN() {
    return VIN;
  }

  public int getINVOICE_ID() {
    return INVOICE_ID;
  }

  public String getSTART_TIME() {
    return START_TIME;
  }

  public String getEND_TIME() {
    return END_TIME;
  }

  public void setSERVICE_ID(int SERVICE_ID) {
    this.SERVICE_ID = SERVICE_ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setMECHANIC_ID(int MECHANIC_ID) {
    this.MECHANIC_ID = MECHANIC_ID;
  }

  public void setSERVICE_CENTER_ID(int SERVICE_CENTER_ID) {
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
  }

  public void setVIN(int VIN) {
    this.VIN = VIN;
  }

  public void setINVOICE_ID(int INVOICE_ID) {
    this.INVOICE_ID = INVOICE_ID;
  }

  public void setSTART_TIME(String START_TIME) {
    this.START_TIME = START_TIME;
  }

  public void setEND_TIME(String END_TIME) {
    this.END_TIME = END_TIME;
  }

  @Override
  public String toString() {
    return (
      "ServiceEvent{" +
      "SERVICE_ID=" +
      SERVICE_ID +
      ", ID=" +
      ID +
      ", MECHANIC_ID=" +
      MECHANIC_ID +
      ", SERVICE_CENTER_ID=" +
      SERVICE_CENTER_ID +
      ", VIN=" +
      VIN +
      ", INVOICE_ID=" +
      INVOICE_ID +
      ", START_TIME='" +
      START_TIME +
      '\'' +
      ", END_TIME='" +
      END_TIME +
      '\'' +
      '}'
    );
  }
}
