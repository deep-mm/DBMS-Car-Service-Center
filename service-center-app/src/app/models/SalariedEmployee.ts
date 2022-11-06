export class SalariedEmployee {

    employee_ID: number;
    service_CENTER_ID: number;
    salary: number;

    constructor(json?: any) {
        if (json) {
            this.employee_ID = json.employee_ID;
            this.service_CENTER_ID = json.service_CENTER_ID;
            this.salary = json.salary;
        }
        else{
            this.employee_ID = 0;
            this.service_CENTER_ID = 0;
            this.salary = 0;
        }
    }
}