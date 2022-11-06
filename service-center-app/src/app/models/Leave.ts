export class Leave {

    leave_ID: number;
    start_DATE: string;
    end_DATE: string;
    status: number;
    employee_ID: number;
    service_CENTER_ID: number;

    constructor(json?: any) {
        if (json) {
            this.leave_ID = json.leave_ID;
            this.start_DATE = json.start_DATE;
            this.end_DATE = json.end_DATE;
            this.status = json.status;
            this.employee_ID = json.employee_ID;
            this.service_CENTER_ID = json.service_CENTER_ID;
        }
        else{
            this.leave_ID = 0;
            this.start_DATE = "";
            this.end_DATE = "";
            this.status = 0;
            this.employee_ID = 0;
            this.service_CENTER_ID = 0;
        }
    }
}