package com.dbms.team15.models;

public class ServiceCenter {

    private long service_center_id;
	private String address;
    private String telephone_number;
    private int operational_status;
    private int weekend_working;

    // Create constructor and getters
    public ServiceCenter(long service_center_id, String address, String telephone_number, int operational_status, int weekend_working) {
        this.service_center_id = service_center_id;
        this.address = address;
        this.telephone_number = telephone_number;
        this.operational_status = operational_status;
        this.weekend_working = weekend_working;
    }

    public long getService_center_id() {
        return service_center_id;
    }

    public void setService_center_id(long service_center_id) {
        this.service_center_id = service_center_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone_number() {
        return telephone_number;
    }   

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public int getOperational_status() {
        return operational_status;
    }

    public void setOperational_status(int operational_status) {
        this.operational_status = operational_status;
    }

    public int getWeekend_working() {
        return weekend_working;
    }

    public void setWeekend_working(int weekend_working) {
        this.weekend_working = weekend_working;
    }

}
