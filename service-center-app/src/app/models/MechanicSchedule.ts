export class MechanicSchedule {

    manufacturer: string;
    vin: number;
    service_NAME: string;
    start_TIME: string;
    end_TIME: string;
    invoice_ID: number;
    mechanic_ID: number;

    constructor(json?: any) {
        if (json) {
            this.manufacturer = json.manufacturer;
            this.vin = json.vin;
            this.service_NAME = json.service_NAME;
            this.start_TIME = json.start_TIME;
            this.end_TIME = json.end_TIME;
            this.invoice_ID = json.invoice_ID;
            this.mechanic_ID = json.mechanic_ID;
        }
        else{
            this.manufacturer = '';
            this.vin = 0;
            this.service_NAME = '';
            this.start_TIME = '';
            this.end_TIME = '';
            this.invoice_ID = 0;
            this.mechanic_ID = 0;
        }
    }

}