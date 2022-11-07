package com.dbms.team15.models;

public class CustomerScheduledService {

    public String SERVICE_NAME;
    public int VIN;
    public String START_TIME;
    public String END_TIME;

    public CustomerScheduledService() {
    }

    public CustomerScheduledService(String SERVICE_NAME, int VIN, String START_TIME, String END_TIME) {
        this.SERVICE_NAME = SERVICE_NAME;
        this.VIN = VIN;
        this.START_TIME = START_TIME;
        this.END_TIME = END_TIME;
    }

    public String getSERVICE_NAME() {
        return SERVICE_NAME;
    }

    public void setSERVICE_NAME(String SERVICE_NAME) {
        this.SERVICE_NAME = SERVICE_NAME;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public String getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(String START_TIME) {
        this.START_TIME = START_TIME;
    }

    public String getEND_TIME() {
        return END_TIME;
    }

    public void setEND_TIME(String END_TIME) {
        this.END_TIME = END_TIME;
    }

    @Override
    public String toString() {
        return "CustomerScheduledService{" +
                "SERVICE_NAME='" + SERVICE_NAME + '\'' +
                ", VIN=" + VIN +
                ", START_TIME='" + START_TIME + '\'' +
                ", END_TIME='" + END_TIME + '\'' +
                '}';
    }
    
}
