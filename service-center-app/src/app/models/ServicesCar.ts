export class ServicesCar {

    id: number;
    car_ID: number;
    time_ESTIMATED: number;

    constructor(json?: any) {
        if (json) {
            this.id = json.id;
            this.car_ID = json.car_ID;
            this.time_ESTIMATED = json.time_ESTIMATED;
        }
        else{
            this.id = 0;
            this.car_ID = 0;
            this.time_ESTIMATED = 0;
        }
    }
}