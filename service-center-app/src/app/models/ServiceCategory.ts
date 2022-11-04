export class ServiceCategory {

    category_id: number;
    category_name: string;

    constructor(json?: any) {
        if (json) {
            this.category_id = json.category_id;
            this.category_name = json.category_name;
        }
        else {
            this.category_id = 0;
            this.category_name = "";
        }
    }
}