package com.dbms.team15.models;

public class Service {

  private int ID;
  private String SERVICE_NAME;

  public Service() {}

  public Service(int ID, String SERVICE_NAME) {
    this.ID = ID;
    this.SERVICE_NAME = SERVICE_NAME;
  }

  public int getID() {
    return ID;
  }

  public String getSERVICE_NAME() {
    return SERVICE_NAME;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setSERVICE_NAME(String SERVICE_NAME) {
    this.SERVICE_NAME = SERVICE_NAME;
  }

  @Override
  public String toString() {
    return (
      "Service{" + "ID=" + ID + ", SERVICE_NAME='" + SERVICE_NAME + '\'' + '}'
    );
  }
}
