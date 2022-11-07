export class MechanicSchedule {

    manufacturer: string;
    vin: number;
    service_NAME: string;
    start_TIME: string;
    end_TIME: string;

    constructor(json?: any) {
        if (json) {
            this.manufacturer = json.manufacturer;
            this.vin = json.vin;
            this.service_NAME = json.service_NAME;
            this.start_TIME = json.start_TIME;
            this.end_TIME = json.end_TIME;
        }
        else{
            this.manufacturer = '';
            this.vin = 0;
            this.service_NAME = '';
            this.start_TIME = '';
            this.end_TIME = '';
        }
    }

}