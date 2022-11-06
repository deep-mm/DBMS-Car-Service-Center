export class Customer {

    customer_ID: number;
    service_CENTER_ID: number;
    first_NAME: string;
    last_NAME: string;
    email: string;
    address: string;
    username: string;
    password: string;
    status: number;

    constructor(json?: any) {
        if (json) {
            this.customer_ID = json.customer_ID;
            this.service_CENTER_ID = json.service_CENTER_ID;
            this.first_NAME = json.first_NAME;
            this.last_NAME = json.last_NAME;
            this.email = json.email;
            this.address = json.address;
            this.username = json.username;
            this.password = json.password;
            this.status = json.status;
        }
        else{
            this.customer_ID = 0;
            this.service_CENTER_ID = 0;
            this.first_NAME = "";
            this.last_NAME = "";
            this.email = "";
            this.address = "";
            this.username = "";
            this.password = "";
            this.status = 0;
        }
    }
}