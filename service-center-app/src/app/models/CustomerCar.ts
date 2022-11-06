export class CustomerCar {

    vin: number;
    mileage: number;
    last_SCHEDULED_MAINTENANCE: number;
    customer_ID: number;
    service_CENTER_ID: number;
    car_ID: number;
    year: number;

    constructor(json?: any) {
        if (json) {
            this.vin = json.vin;
            this.mileage = json.mileage;
            this.last_SCHEDULED_MAINTENANCE = json.last_SCHEDULED_MAINTENANCE;
            this.customer_ID = json.customer_ID;
            this.service_CENTER_ID = json.service_CENTER_ID;
            this.car_ID = json.car_ID;
            this.year = json.year;
        }
        else{
            this.vin = 0;
            this.mileage = 0;
            this.last_SCHEDULED_MAINTENANCE = 0;
            this.customer_ID = 0;
            this.service_CENTER_ID = 0;
            this.car_ID = 0;
            this.year = 0;
        }
    }
}