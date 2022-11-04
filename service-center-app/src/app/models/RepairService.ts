export class RepairService {

    id: number;
    category_id: number;

    constructor(json?: any) {
        if (json) {
            this.id = json.id;
            this.category_id = json.category_id;
        }
        else {
            this.id = 0;
            this.category_id = 0;
        }
    }
}