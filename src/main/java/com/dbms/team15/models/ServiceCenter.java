package com.dbms.team15.models;

public class ServiceCenter {

  private int SERVICE_CENTER_ID;
  private String ADDRESS;
  private String TELEPHONE_NO;
  private int OPERATIONAL_STATUS;
  private int WEEKEND_WORKING;
  private int MIN_WAGE;
  private int MAX_WAGE;

  public ServiceCenter() {
  }

  // Create constructor and getters
  public ServiceCenter(
      int SERVICE_CENTER_ID,
      String ADDRESS,
      String TELEPHONE_NO,
      int OPERATIONAL_STATUS,
      int WEEKEND_WORKING,
      int MIN_WAGE,
      int MAX_WAGE) {
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
    this.ADDRESS = ADDRESS;
    this.TELEPHONE_NO = TELEPHONE_NO;
    this.OPERATIONAL_STATUS = OPERATIONAL_STATUS;
    this.WEEKEND_WORKING = WEEKEND_WORKING;
    this.MIN_WAGE = MIN_WAGE;
    this.MAX_WAGE = MAX_WAGE;
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

  public int getMIN_WAGE() {
    return MIN_WAGE;
  }

  public int getMAX_WAGE() {
    return MAX_WAGE;
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

  public void setMIN_WAGE(int MIN_WAGE) {
    this.MIN_WAGE = MIN_WAGE;
  }

  public void setMAX_WAGE(int MAX_WAGE) {
    this.MAX_WAGE = MAX_WAGE;
  }

  @Override
  public String toString() {
    return "ServiceCenter [ADDRESS=" + ADDRESS + ", MAX_WAGE=" + MAX_WAGE + ", MIN_WAGE=" + MIN_WAGE
        + ", OPERATIONAL_STATUS=" + OPERATIONAL_STATUS + ", SERVICE_CENTER_ID=" + SERVICE_CENTER_ID
        + ", TELEPHONE_NO=" + TELEPHONE_NO + ", WEEKEND_WORKING=" + WEEKEND_WORKING + "]";
  }
}
