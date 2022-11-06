package com.dbms.team15.models;

public class SwapSlot {

    private int requestor_employee_id;
    private int requestor_service_center_id;
    private int requested_employee_id;
    private int requested_service_center_id;
    private int invoice_give;
    private int invoice_take;
    private int status;

    public SwapSlot() {
    }

    public SwapSlot(int requestor_employee_id, int requestor_service_center_id, int requested_employee_id,
            int requested_service_center_id, int invoice_give, int invoice_take, int status) {
        this.requestor_employee_id = requestor_employee_id;
        this.requestor_service_center_id = requestor_service_center_id;
        this.requested_employee_id = requested_employee_id;
        this.requested_service_center_id = requested_service_center_id;
        this.invoice_give = invoice_give;
        this.invoice_take = invoice_take;
        this.status = status;
    }

    public int getRequestor_employee_id() {
        return requestor_employee_id;
    }

    public void setRequestor_employee_id(int requestor_employee_id) {
        this.requestor_employee_id = requestor_employee_id;
    }

    public int getRequestor_service_center_id() {
        return requestor_service_center_id;
    }

    public void setRequestor_service_center_id(int requestor_service_center_id) {
        this.requestor_service_center_id = requestor_service_center_id;
    }

    public int getRequested_employee_id() {
        return requested_employee_id;
    }

    public void setRequested_employee_id(int requested_employee_id) {
        this.requested_employee_id = requested_employee_id;
    }

    public int getRequested_service_center_id() {
        return requested_service_center_id;
    }

    public void setRequested_service_center_id(int requested_service_center_id) {
        this.requested_service_center_id = requested_service_center_id;
    }

    public int getInvoice_give() {
        return invoice_give;
    }

    public void setInvoice_give(int invoice_give) {
        this.invoice_give = invoice_give;
    }

    public int getInvoice_take() {
        return invoice_take;
    }

    public void setInvoice_take(int invoice_take) {
        this.invoice_take = invoice_take;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SwapSlot [invoice_give=" + invoice_give + ", invoice_take=" + invoice_take + ", requestor_employee_id="
                + requestor_employee_id + ", requestor_service_center_id=" + requestor_service_center_id
                + ", requested_employee_id=" + requested_employee_id + ", requested_service_center_id="
                + requested_service_center_id + ", status=" + status + "]";
    }

}
