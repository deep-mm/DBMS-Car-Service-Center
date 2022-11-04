export class HourlyPaidEmployee {

    employee_id: number;
    service_center_id: number;
    hourly_rate: number;

    constructor(json?: any) {
        if (json) {
            this.employee_id = json.employee_id;
            this.service_center_id = json.service_center_id;
            this.hourly_rate = json.hourly_rate;
        }
        else {
            this.employee_id = 0;
            this.service_center_id = 0;
            this.hourly_rate = 0;
        }
    }

}