package com.dbms.team15.models;

public class ServiceCategory {

  private int CATEGORY_ID;
  private String CATEGORY_NAME;

  public ServiceCategory() {}

  public ServiceCategory(int CATEGORY_ID, String CATEGORY_NAME) {
    this.CATEGORY_ID = CATEGORY_ID;
    this.CATEGORY_NAME = CATEGORY_NAME;
  }

  public int getCATEGORY_ID() {
    return CATEGORY_ID;
  }

  public String getCATEGORY_NAME() {
    return CATEGORY_NAME;
  }

  public void setCATEGORY_ID(int CATEGORY_ID) {
    this.CATEGORY_ID = CATEGORY_ID;
  }

  public void setCATEGORY_NAME(String CATEGORY_NAME) {
    this.CATEGORY_NAME = CATEGORY_NAME;
  }

  @Override
  public String toString() {
    return (
      "ServiceCategory{" +
      "CATEGORY_ID=" +
      CATEGORY_ID +
      ", CATEGORY_NAME='" +
      CATEGORY_NAME +
      '\'' +
      '}'
    );
  }
}
