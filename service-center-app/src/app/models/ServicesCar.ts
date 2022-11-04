export class ServicesCar {

    id: number;
    car_id: number;
    time_estimated: number;

    constructor(json?: any) {
        if (json) {
            this.id = json.id;
            this.car_id = json.car_id;
            this.time_estimated = json.time_estimated;
        }
        else {
            this.id = 0;
            this.car_id = 0;
            this.time_estimated = 0;
        }
    }

}