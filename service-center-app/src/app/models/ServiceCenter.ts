export class ServiceCenter {

    service_center_id: number;
    address: string;
    telephone_no: string;
    operational_status: number;
    weekend_working: number;

    constructor(json?: any) {
        if (json) {
            this.service_center_id = json.service_center_id;
            this.address = json.address;
            this.telephone_no = json.telephone_no;
            this.operational_status = json.operational_status;
            this.weekend_working = json.weekend_working;
        }
        else {
            this.service_center_id = 0;
            this.address = "";
            this.telephone_no = "";
            this.operational_status = 0;
            this.weekend_working = 0;
        }
    }
}