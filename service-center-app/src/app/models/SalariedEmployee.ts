export class SalariedEmployee {

    eomployee_id: number;
    service_center_id: number;
    salary: number;

    constructor(json?: any) {
        if (json) {
            this.eomployee_id = json.eomployee_id;
            this.service_center_id = json.service_center_id;
            this.salary = json.salary;
        }
        else {
            this.eomployee_id = 0;
            this.service_center_id = 0;
            this.salary = 0;
        }
    }
}