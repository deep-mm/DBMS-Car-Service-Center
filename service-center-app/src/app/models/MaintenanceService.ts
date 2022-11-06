export class MaintenanceService {
    
    id: number;
    schedule_BUNDLE_ID: number;

    constructor(json?: any) {
        if (json) {
            this.id = json.id;
            this.schedule_BUNDLE_ID = json.schedule_BUNDLE_ID;
        }
        else{
            this.id = 0;
            this.schedule_BUNDLE_ID = 0;
        }
    }
}