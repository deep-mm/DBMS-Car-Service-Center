export class ServiceCategory {

    category_ID: number;
    category_NAME: string;

    constructor(json?: any) {
        if (json) {
            this.category_ID = json.category_ID;
            this.category_NAME = json.category_NAME;
        }
        else{
            this.category_ID = 0;
            this.category_NAME = "";
        }
    }
}