export class HourlyPaidEmployee {

    employee_ID: number;
    service_CENTER_ID: number;
    hourly_RATE: number;

    constructor(json?: any) {
        if (json) {
            this.employee_ID = json.employee_ID;
            this.service_CENTER_ID = json.service_CENTER_ID;
            this.hourly_RATE = json.hourly_RATE;
        }
        else{
            this.employee_ID = 0;
            this.service_CENTER_ID = 0;
            this.hourly_RATE = 0;
        }
    }

}