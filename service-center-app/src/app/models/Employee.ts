export class Employee {
    
    employee_ID: number;
    service_CENTER_ID: number;
    name: string;
    address: string;
    start_DATE: string;
    role: number;
    email: string;
    phone: string;
    username: string;
    password: string;
    
    constructor(json?: any) {
        if (json) {
            this.employee_ID = json.employee_ID;
            this.service_CENTER_ID = json.service_CENTER_ID;
            this.name = json.name;
            this.address = json.address;
            this.start_DATE = json.start_DATE;
            this.role = json.role;
            this.email = json.email;
            this.phone = json.phone;
            this.username = json.username;
            this.password = json.password;
        }
        else{
            this.employee_ID = 0;
            this.service_CENTER_ID = 0;
            this.name = "";
            this.address = "";
            this.start_DATE = "";
            this.role = 0;
            this.email = "";
            this.phone = "";
            this.username = "";
            this.password = "";
        }
    }

}