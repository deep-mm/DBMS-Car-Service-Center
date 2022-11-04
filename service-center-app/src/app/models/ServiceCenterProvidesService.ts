export class ServiceCenterProvidesService {

    service_center_id: number;
    id: number;
    car_id: number;
    price: number;

    constructor(json?: any) {
        if (json) {
            this.service_center_id = json.service_center_id;
            this.id = json.id;
            this.car_id = json.car_id;
            this.price = json.price;
        }
        else {
            this.service_center_id = 0;
            this.id = 0;
            this.car_id = 0;
            this.price = 0;
        }
    }
}