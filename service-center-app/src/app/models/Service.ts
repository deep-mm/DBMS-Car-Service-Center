export class Service {

    id: number;
    service_NAME: string;

    constructor(json?: any) {
        if (json) {
            this.id = json.id;
            this.service_NAME = json.service_NAME;
        }
        else{
            this.id = 0;
            this.service_NAME = "";
        }
    }
}