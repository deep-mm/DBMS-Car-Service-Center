export class Leave {

    leave_id: number;
    start_date: string;
    end_date: string;
    status: number;
    employee_id: number;
    service_center_id: number;

    constructor(json?: any) {
        if (json) {
            this.leave_id = json.leave_id;
            this.start_date = json.start_date;
            this.end_date = json.end_date;
            this.status = json.status;
            this.employee_id = json.employee_id;
            this.service_center_id = json.service_center_id;
        }
        else {
            this.leave_id = 0;
            this.start_date = "";
            this.end_date = "";
            this.status = 0;
            this.employee_id = 0;
            this.service_center_id = 0;
        }
    }
}