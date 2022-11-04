export class ServiceEvent {

    service_id: number;
    id: number;
    mechanic_id: number;
    service_center_id: number;
    vin: number;
    invoice_id: number;
    start_time: string;
    end_time: string;

    constructor(json?: any) {
        if (json) {
            this.service_id = json.service_id;
            this.id = json.id;
            this.mechanic_id = json.mechanic_id;
            this.service_center_id = json.service_center_id;
            this.vin = json.vin;
            this.invoice_id = json.invoice_id;
            this.start_time = json.start_time;
            this.end_time = json.end_time;
        }
        else {
            this.service_id = 0;
            this.id = 0;
            this.mechanic_id = 0;
            this.service_center_id = 0;
            this.vin = 0;
            this.invoice_id = 0;
            this.start_time = "";
            this.end_time = "";
        }
    }
}