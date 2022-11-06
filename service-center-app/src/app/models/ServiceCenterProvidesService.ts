export class ServiceCenterProvidesService {

    service_CENTER_ID: number;
    id: number;
    car_ID: number;
    price: number;

    constructor(json?: any) {
        if (json) {
            this.service_CENTER_ID = json.service_CENTER_ID;
            this.id = json.id;
            this.car_ID = json.car_ID;
            this.price = json.price;
        }
        else{
            this.service_CENTER_ID = 0;
            this.id = 0;
            this.car_ID = 0;
            this.price = 0;
        }
    }
}