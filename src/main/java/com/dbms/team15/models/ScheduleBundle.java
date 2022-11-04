package com.dbms.team15.models;

public class ScheduleBundle {

  private int SCHEDULE_BUNDLE_ID;
  private String NAME;

  public ScheduleBundle() {}

  public ScheduleBundle(int SCHEDULE_BUNDLE_ID, String NAME) {
    this.SCHEDULE_BUNDLE_ID = SCHEDULE_BUNDLE_ID;
    this.NAME = NAME;
  }

  public int getSCHEDULE_BUNDLE_ID() {
    return SCHEDULE_BUNDLE_ID;
  }

  public String getNAME() {
    return NAME;
  }

  public void setSCHEDULE_BUNDLE_ID(int SCHEDULE_BUNDLE_ID) {
    this.SCHEDULE_BUNDLE_ID = SCHEDULE_BUNDLE_ID;
  }

  public void setNAME(String NAME) {
    this.NAME = NAME;
  }

  @Override
  public String toString() {
    return (
      "ScheduleBundle{" +
      "SCHEDULE_BUNDLE_ID=" +
      SCHEDULE_BUNDLE_ID +
      ", NAME='" +
      NAME +
      '\'' +
      '}'
    );
  }
}
