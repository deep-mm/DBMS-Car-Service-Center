export class ScheduleBundle {

    schedule_bundle_id: number;
    name: string;

    constructor(json?: any) {
        if (json) {
            this.schedule_bundle_id = json.schedule_bundle_id;
            this.name = json.name;
        }
        else {
            this.schedule_bundle_id = 0;
            this.name = "";
        }
    }
}