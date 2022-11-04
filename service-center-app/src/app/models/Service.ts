export class Service {

    id: number;
    service_name: string;

    constructor(json?: any) {
        if (json) {
            this.id = json.id;
            this.service_name = json.service_name;
        }
        else {
            this.id = 0;
            this.service_name = "";
        }
    }
}