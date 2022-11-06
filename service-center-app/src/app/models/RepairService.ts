export class RepairService {

    id: number;
    category_ID: number;

    constructor(json?: any) {
        if (json) {
            this.id = json.id;
            this.category_ID = json.category_ID;
        }
        else{
            this.id = 0;
            this.category_ID = 0;
        }
    }
}