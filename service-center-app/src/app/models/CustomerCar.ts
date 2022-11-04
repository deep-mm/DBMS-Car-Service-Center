export class CustomerCar {

    vin: number;
    mileage: number;
    last_scheduled_maintenance: number;
    customer_id: number;
    service_center_id: number;
    car_id: number;

    constructor(json?: any) {
        if (json) {
            this.vin = json.vin;
            this.mileage = json.mileage;
            this.last_scheduled_maintenance = json.last_scheduled_maintenance;
            this.customer_id = json.customer_id;
            this.service_center_id = json.service_center_id;
            this.car_id = json.car_id;
        }
        else {
            this.vin = 0;
            this.mileage = 0;
            this.last_scheduled_maintenance = 0;
            this.customer_id = 0;
            this.service_center_id = 0;
            this.car_id = 0;
        }
    }
}