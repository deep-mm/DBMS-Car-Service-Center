package com.dbms.team15.models;

public class Employee {

    private int EMPLOYEE_ID;
    private int SERVICE_CENTER_ID;
    private String NAME;
    private String ADDRESS;
    private String START_DATE;
    private int ROLE;
    private String EMAIL;
    private String PHONE;
    private String USERNAME;
    private String PASSWORD;

    public Employee() {}

    // Create constructor
    public Employee(
        int EMPLOYEE_ID,
        int SERVICE_CENTER_ID,
        String NAME,
        String ADDRESS,
        String START_DATE,
        int ROLE,
        String EMAIL,
        String PHONE,
        String USERNAME,
        String PASSWORD
    ) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
        this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
        this.NAME = NAME;
        this.ADDRESS = ADDRESS;
        this.START_DATE = START_DATE;
        this.ROLE = ROLE;
        this.EMAIL = EMAIL;
        this.PHONE = PHONE;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    // Create getters
    public int getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public int getSERVICE_CENTER_ID() {
        return SERVICE_CENTER_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getSTART_DATE() {
        return START_DATE;
    }

    public int getROLE() {
        return ROLE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPHONE() {
        return PHONE;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    // Create setters
    public void setEMPLOYEE_ID(int EMPLOYEE_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
    }

    public void setSERVICE_CENTER_ID(int SERVICE_CENTER_ID) {
        this.SERVICE_CENTER_ID = SERVICE_CENTER_ID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public void setSTART_DATE(String START_DATE) {
        this.START_DATE = START_DATE;
    }

    public void setROLE(int ROLE) {
        this.ROLE = ROLE;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    // Create toString
    @Override
    public String toString() {
        return "Employee [EMPLOYEE_ID=" + EMPLOYEE_ID + ", SERVICE_CENTER_ID=" + SERVICE_CENTER_ID + ", NAME=" + NAME
                + ", ADDRESS=" + ADDRESS + ", START_DATE=" + START_DATE + ", ROLE=" + ROLE + ", EMAIL=" + EMAIL
                + ", PHONE=" + PHONE + ", USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + "]";
    }
    
}
