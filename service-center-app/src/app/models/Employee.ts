export class Employee {
    
    employee_id: number;
    service_center_id: number;
    name: string;
    address: string;
    start_date: string;
    role: number;
    email: string;
    phone: string;
    username: string;
    password: string;
    
    constructor(json?: any) {
        if (json) {
            this.employee_id = json.employee_id;
            this.service_center_id = json.service_center_id;
            this.name = json.name;
            this.address = json.address;
            this.start_date = json.start_date;
            this.role = json.role;
            this.email = json.email;
            this.phone = json.phone;
            this.username = json.username;
            this.password = json.password;
        }
        else {
            this.employee_id = 0;
            this.service_center_id = 0;
            this.name = "";
            this.address = "";
            this.start_date = "";
            this.role = 0;
            this.email = "";
            this.phone = "";
            this.username = "";
            this.password = "";
        }
    }

}