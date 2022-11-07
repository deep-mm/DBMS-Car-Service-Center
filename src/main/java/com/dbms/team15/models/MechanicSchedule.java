package com.dbms.team15.models;

public class MechanicSchedule {

    private String SERVICE_NAME;
    private String MANUFACTURER;
    private String VIN;
    private String START_TIME;
    private String END_TIME;

    public MechanicSchedule() {
    }

    public MechanicSchedule(String SERVICE_NAME, String MANUFACTURER, String VIN, String START_TIME, String END_TIME) {
        this.SERVICE_NAME = SERVICE_NAME;
        this.MANUFACTURER = MANUFACTURER;
        this.VIN = VIN;
        this.START_TIME = START_TIME;
        this.END_TIME = END_TIME;
    }

    public String getSERVICE_NAME() {
        return SERVICE_NAME;
    }

    public String getMANUFACTURER() {
        return MANUFACTURER;
    }

    public String getVIN() {
        return VIN;
    }

    public String getSTART_TIME() {
        return START_TIME;
    }

    public String getEND_TIME() {
        return END_TIME;
    }

    public void setSERVICE_NAME(String SERVICE_NAME) {
        this.SERVICE_NAME = SERVICE_NAME;
    }

    public void setMANUFACTURER(String MANUFACTURER) {
        this.MANUFACTURER = MANUFACTURER;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setSTART_TIME(String START_TIME) {
        this.START_TIME = START_TIME;
    }

    public void setEND_TIME(String END_TIME) {
        this.END_TIME = END_TIME;
    }

    @Override
    public String toString() {
        return "MechanicSchedule{" + "SERVICE_NAME=" + SERVICE_NAME + ", MANUFACTURER=" + MANUFACTURER + ", VIN=" + VIN
                + ", START_TIME=" + START_TIME + ", END_TIME=" + END_TIME + '}';
    }

}
