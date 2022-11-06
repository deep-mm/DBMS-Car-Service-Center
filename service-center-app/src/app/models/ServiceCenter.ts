export class ServiceCenter {

    service_CENTER_ID: number;
    address: string;
    telephone_NO: string;
    operational_STATUS: number;
    weekend_WORKING: number;
    max_WAGE: number;
    min_WAGE: number;

    constructor(json?: any) {
        if (json) {
            this.service_CENTER_ID = json.service_CENTER_ID;
            this.address = json.address;
            this.telephone_NO = json.telephone_NO;
            this.operational_STATUS = json.operational_STATUS;
            this.weekend_WORKING = json.weekend_WORKING;
            this.max_WAGE = json.max_WAGE;
            this.min_WAGE = json.min_WAGE;
        }
        else{
            this.service_CENTER_ID = 0;
            this.address = "";
            this.telephone_NO = "";
            this.operational_STATUS = 0;
            this.weekend_WORKING = 0;
            this.max_WAGE = 0;
            this.min_WAGE = 0;
        }
    }
}