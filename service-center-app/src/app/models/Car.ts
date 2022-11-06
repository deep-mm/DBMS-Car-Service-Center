export class Car {
    
    car_ID: number;
    manufacturer: string;

    constructor(json?: any) {
        if (json) {
            this.car_ID = json.car_id;
            this.manufacturer = json.manufacturer;
        }
        else{
            this.car_ID = 0;
            this.manufacturer = "";
        }
    }
}