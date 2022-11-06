export class ServiceEvent {

    service_ID: number;
    id: number;
    mechanic_ID: number;
    service_CENTER_ID: number;
    vin: number;
    invoice_ID: number;
    start_TIME: string;
    end_TIME: string;

    constructor(json?: any) {
        if (json) {
            this.service_ID = json.service_ID;
            this.id = json.id;
            this.mechanic_ID = json.mechanic_ID;
            this.service_CENTER_ID = json.service_CENTER_ID;
            this.vin = json.vin;
            this.invoice_ID = json.invoice_ID;
            this.start_TIME = json.start_TIME;
            this.end_TIME = json.end_TIME;
        }
        else{
            this.service_ID = 0;
            this.id = 0;
            this.mechanic_ID = 0;
            this.service_CENTER_ID = 0;
            this.vin = 0;
            this.invoice_ID = 0;
            this.start_TIME = "";
            this.end_TIME = "";
        }
    }
}