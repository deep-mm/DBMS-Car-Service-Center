export class SwapSlot {

    invoice_give: number;
    invoice_take: number;
    requested_employee_id: number;
    requested_service_center_id: number;
    requestor_employee_id: number;
    requestor_service_center_id: number;
    status: number;

    constructor(json?: any) {
        if (json) {
            this.invoice_give = json.invoice_give;
            this.invoice_take = json.invoice_take;
            this.requested_employee_id = json.requested_employee_id;
            this.requested_service_center_id = json.requested_service_center_id;
            this.requestor_employee_id = json.requestor_employee_id;
            this.requestor_service_center_id = json.requestor_service_center_id;
            this.status = json.status;
        }
        else{
            this.invoice_give = 0;
            this.invoice_take = 0;
            this.requested_employee_id = 0;
            this.requested_service_center_id = 0;
            this.requestor_employee_id = 0;
            this.requestor_service_center_id = 0;
            this.status = 0;
        }
    }
}