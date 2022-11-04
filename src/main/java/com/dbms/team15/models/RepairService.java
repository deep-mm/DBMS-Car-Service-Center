package com.dbms.team15.models;

public class RepairService {

  private int ID;
  private int CATEGORY_ID;

  public RepairService() {}

  public RepairService(int ID, int CATEGORY_ID) {
    this.ID = ID;
    this.CATEGORY_ID = CATEGORY_ID;
  }

  public int getID() {
    return ID;
  }

  public int getCATEGORY_ID() {
    return CATEGORY_ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setCATEGORY_ID(int CATEGORY_ID) {
    this.CATEGORY_ID = CATEGORY_ID;
  }

  @Override
  public String toString() {
    return "RepairService{" + "ID=" + ID + ", CATEGORY_ID=" + CATEGORY_ID + '}';
  }
}
