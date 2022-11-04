export class Car {
    
    car_id: number;
    manufacturer: string;
    year: number;

    constructor(json?: any) {
        if (json) {
            this.car_id = json.car_id;
            this.manufacturer = json.manufacturer;
            this.year = json.year;
        }
        else{
            this.car_id = 0;
            this.manufacturer = "";
            this.year = 0;
        }
    }
}