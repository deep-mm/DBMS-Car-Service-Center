package com.dbms.team15.models;

public class MaintenanceService {

  private int ID;
  private int SCHEDULE_BUNDLE_ID;

  public MaintenanceService() {}

  public MaintenanceService(int ID, int SCHEDULE_BUNDLE_ID) {
    this.ID = ID;
    this.SCHEDULE_BUNDLE_ID = SCHEDULE_BUNDLE_ID;
  }

  public int getID() {
    return ID;
  }

  public int getSCHEDULE_BUNDLE_ID() {
    return SCHEDULE_BUNDLE_ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setSCHEDULE_BUNDLE_ID(int SCHEDULE_BUNDLE_ID) {
    this.SCHEDULE_BUNDLE_ID = SCHEDULE_BUNDLE_ID;
  }

  @Override
  public String toString() {
    return (
      "MaintenanceService{" +
      "ID=" +
      ID +
      ", SCHEDULE_BUNDLE_ID=" +
      SCHEDULE_BUNDLE_ID +
      '}'
    );
  }
}
