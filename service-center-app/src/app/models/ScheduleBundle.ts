export class ScheduleBundle {

    schedule_BUNDLE_ID: number;
    name: string;

    constructor(json?: any) {
        if (json) {
            this.schedule_BUNDLE_ID = json.schedule_BUNDLE_ID;
            this.name = json.name;
        }
        else{
            this.schedule_BUNDLE_ID = 0;
            this.name = "";
        }
    }
}