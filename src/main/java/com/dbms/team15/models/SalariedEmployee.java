package com.dbms.team15.models;

public class SalariedEmployee {
    
  private int EMPLOYEE_ID;
  private int SERVICE_CENTER_ID;
  private double SALARY;

  public SalariedEmployee() {}

  public SalariedEmployee(
    int EMPLOYEE_ID,
    int SERVICE_CENTER_ID,
    double SALARY
  ) {
    this.EMPLOYEE_ID = EMPLOYEE_ID;
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
    this.SALARY = SALARY;
  }

  public int getEMPLOYEE_ID() {
    return EMPLOYEE_ID;
  }

  public int getSERVICE_CENTER_ID() {
    return SERVICE_CENTER_ID;
  }

  public double getSALARY() {
    return SALARY;
  }

  public void setEMPLOYEE_ID(int EMPLOYEE_ID) {
    this.EMPLOYEE_ID = EMPLOYEE_ID;
  }

  public void setSERVICE_CENTER_ID(int SERVICE_CENTER_ID) {
    this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
  }

  public void setSALARY(double SALARY) {
    this.SALARY = SALARY;
  }

  @Override
  public String toString() {
    return (
      "SalariedEmployee{" +
      "EMPLOYEE_ID=" +
      EMPLOYEE_ID +
      ", SERVICE_CENTER_ID=" +
      SERVICE_CENTER_ID +
      ", SALARY=" +
      SALARY +
      '}'
    );
  }
}
