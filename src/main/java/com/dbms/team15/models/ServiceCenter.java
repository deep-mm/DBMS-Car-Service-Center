package com.dbms.team15.models;

public class ServiceCenter {

  private int SERVICE_CENTER_ID;
  private String ADDRESS;
  private String TELEPHONE_NO;
  private int OPERATIONAL_STATUS;
  private int WEEKEND_WORKING;

  public ServiceCenter() {}

  // Create constructor and getters
  public ServiceCenter(
    int SERVICE_CENTER_ID,
    String ADDRESS,
    String TELEPHONE_NO,
    int OPERATIONAL_STATUS,
    int WEEKEND_WORKING
  ) {
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
    this.ADDRESS = ADDRESS;
    this.TELEPHONE_NO = TELEPHONE_NO;
    this.OPERATIONAL_STATUS = OPERATIONAL_STATUS;
    this.WEEKEND_WORKING = WEEKEND_WORKING;
  }

  public int getSERVICE_CENTER_ID() {
    return SERVICE_CENTER_ID;
  }

  public String getADDRESS() {
    return ADDRESS;
  }

  public String getTELEPHONE_NO() {
    return TELEPHONE_NO;
  }

  public int getOPERATIONAL_STATUS() {
    return OPERATIONAL_STATUS;
  }

  public int getWEEKEND_WORKING() {
    return WEEKEND_WORKING;
  }

  public void setSERVICE_CENTER_ID(int SERVICE_CENTER_ID) {
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
  }

  public void setADDRESS(String ADDRESS) {
    this.ADDRESS = ADDRESS;
  }

  public void setTELEPHONE_NO(String TELEPHONE_NO) {
    this.TELEPHONE_NO = TELEPHONE_NO;
  }

  public void setOPERATIONAL_STATUS(int OPERATIONAL_STATUS) {
    this.OPERATIONAL_STATUS = OPERATIONAL_STATUS;
  }

  public void setWEEKEND_WORKING(int WEEKEND_WORKING) {
    this.WEEKEND_WORKING = WEEKEND_WORKING;
  }

  @Override
  public String toString() {
    return (
      "ServiceCenter{" +
      "SERVICE_CENTER_ID=" +
      SERVICE_CENTER_ID +
      ", ADDRESS='" +
      ADDRESS +
      '\'' +
      ", TELEPHONE_NO='" +
      TELEPHONE_NO +
      '\'' +
      ", OPERATIONAL_STATUS=" +
      OPERATIONAL_STATUS +
      ", WEEKEND_WORKING=" +
      WEEKEND_WORKING +
      '}'
    );
  }
}
