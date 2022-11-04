package com.dbms.team15.models;

public class Customer {

  private int CUSTOMER_ID;
  private int SERVICE_CENTER_ID;
  private String FIRST_NAME;
  private String LAST_NAME;
  private String EMAIL;
  private String ADDRESS;
  private String USERNAME;
  private String PASSWORD;
  private int STATUS;

  public Customer() {}

  public Customer(
    int CUSTOMER_ID,
    int SERVICE_CENTER_ID,
    String FIRST_NAME,
    String LAST_NAME,
    String EMAIL,
    String ADDRESS,
    String USERNAME,
    String PASSWORD,
    int STATUS
  ) {
    this.CUSTOMER_ID = CUSTOMER_ID;
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
    this.FIRST_NAME = FIRST_NAME;
    this.LAST_NAME = LAST_NAME;
    this.EMAIL = EMAIL;
    this.ADDRESS = ADDRESS;
    this.USERNAME = USERNAME;
    this.PASSWORD = PASSWORD;
    this.STATUS = STATUS;
  }

  public int getCUSTOMER_ID() {
    return CUSTOMER_ID;
  }

  public int getSERVICE_CENTER_ID() {
    return SERVICE_CENTER_ID;
  }

  public String getFIRST_NAME() {
    return FIRST_NAME;
  }

  public String getLAST_NAME() {
    return LAST_NAME;
  }

  public String getEMAIL() {
    return EMAIL;
  }

  public String getADDRESS() {
    return ADDRESS;
  }

  public String getUSERNAME() {
    return USERNAME;
  }

  public String getPASSWORD() {
    return PASSWORD;
  }

  public int getSTATUS() {
    return STATUS;
  }

  public void setCUSTOMER_ID(int CUSTOMER_ID) {
    this.CUSTOMER_ID = CUSTOMER_ID;
  }

  public void setSERVICE_CENTER_ID(int SERVICE_CENTER_ID) {
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
  }

  public void setFIRST_NAME(String FIRST_NAME) {
    this.FIRST_NAME = FIRST_NAME;
  }

  public void setLAST_NAME(String LAST_NAME) {
    this.LAST_NAME = LAST_NAME;
  }

  public void setEMAIL(String EMAIL) {
    this.EMAIL = EMAIL;
  }

  public void setADDRESS(String ADDRESS) {
    this.ADDRESS = ADDRESS;
  }

  public void setUSERNAME(String USERNAME) {
    this.USERNAME = USERNAME;
  }

  public void setPASSWORD(String PASSWORD) {
    this.PASSWORD = PASSWORD;
  }

  public void setSTATUS(int STATUS) {
    this.STATUS = STATUS;
  }

  @Override
  public String toString() {
    return (
      "Customer{" +
      "CUSTOMER_ID=" +
      CUSTOMER_ID +
      ", SERVICE_CENTER_ID=" +
      SERVICE_CENTER_ID +
      ", FIRST_NAME='" +
      FIRST_NAME +
      '\'' +
      ", LAST_NAME='" +
      LAST_NAME +
      '\'' +
      ", EMAIL='" +
      EMAIL +
      '\'' +
      ", ADDRESS='" +
      ADDRESS +
      '\'' +
      ", USERNAME='" +
      USERNAME +
      '\'' +
      ", PASSWORD='" +
      PASSWORD +
      '\'' +
      ", STATUS=" +
      STATUS +
      '}'
    );
  }
}
