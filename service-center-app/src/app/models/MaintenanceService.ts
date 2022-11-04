export class MaintenanceService {
    
    id: number;
    schdeule_bundle_id: number;

    constructor(json?: any) {
        if (json) {
            this.id = json.id;
            this.schdeule_bundle_id = json.schdeule_bundle_id;
        }
        else {
            this.id = 0;
            this.schdeule_bundle_id = 0;
        }
    }
}