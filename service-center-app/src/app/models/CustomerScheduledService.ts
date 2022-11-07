export class CustomerScheduledService {

    service_NAME: string;
    VIN: number;
    START_TIME: string;
    END_TIME: string;

    constructor(json?: any) {
        if (json) {
            this.service_NAME = json.service_NAME;
            this.VIN = json.VIN;
            this.START_TIME = json.START_TIME;
            this.END_TIME = json.END_TIME;
        }
        else{
            this.service_NAME = "";
            this.VIN = 0;
            this.START_TIME = "";
            this.END_TIME = "";
        }
    }
}