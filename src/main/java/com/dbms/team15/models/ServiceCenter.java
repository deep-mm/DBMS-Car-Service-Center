package com.dbms.team15.models;

public class ServiceCenter {

    private final long service_center_id;
	private final String address;
    private final String telephone_number;
    private final int operational_status;
    private final int weekend_working;

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

    public String getAddress() {
        return address;
    }

    public String getTelephone_number() {
        return telephone_number;
    }   

    public int getOperational_status() {
        return operational_status;
    }

    public int getWeekend_working() {
        return weekend_working;
    }

}
