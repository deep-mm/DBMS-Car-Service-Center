package com.dbms.team15.models;

public class Invoice {

  private int INVOICE_ID;
  private int INVOICE_STATUS;
  private double TOTAL_COST;

  public Invoice() {}

  public Invoice(int INVOICE_ID, int INVOICE_STATUS, double TOTAL_COST) {
    this.INVOICE_ID = INVOICE_ID;
    this.INVOICE_STATUS = INVOICE_STATUS;
    this.TOTAL_COST = TOTAL_COST;
  }

  public int getINVOICE_ID() {
    return INVOICE_ID;
  }

  public int getINVOICE_STATUS() {
    return INVOICE_STATUS;
  }

  public double getTOTAL_COST() {
    return TOTAL_COST;
  }

  public void setINVOICE_ID(int INVOICE_ID) {
    this.INVOICE_ID = INVOICE_ID;
  }

  public void setINVOICE_STATUS(int INVOICE_STATUS) {
    this.INVOICE_STATUS = INVOICE_STATUS;
  }

  public void setTOTAL_COST(double TOTAL_COST) {
    this.TOTAL_COST = TOTAL_COST;
  }

  @Override
  public String toString() {
    return (
      "Invoice{" +
      "INVOICE_ID=" +
      INVOICE_ID +
      ", INVOICE_STATUS=" +
      INVOICE_STATUS +
      ", TOTAL_COST=" +
      TOTAL_COST +
      '}'
    );
  }
}
