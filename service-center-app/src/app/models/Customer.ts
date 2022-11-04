export class Customer {

    customer_id: number;
    service_center_id: number;
    first_name: string;
    last_name: string;
    email: string;
    address: string;
    username: string;
    password: string;
    status: number;

    constructor(json?: any) {
        if (json) {
            this.customer_id = json.customer_id;
            this.service_center_id = json.service_center_id;
            this.first_name = json.first_name;
            this.last_name = json.last_name;
            this.email = json.email;
            this.address = json.address;
            this.username = json.username;
            this.password = json.password;
            this.status = json.status;
        }
        else{
            this.customer_id = 0;
            this.service_center_id = 0;
            this.first_name = "";
            this.last_name = "";
            this.email = "";
            this.address = "";
            this.username = "";
            this.password = "";
            this.status = 0;
        }
    }
}