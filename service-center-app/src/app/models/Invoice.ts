export class Invoice {

    invoice_id: number;
    invoice_status: number;
    total_cost: number;

    constructor(json?: any) {
        if (json) {
            this.invoice_id = json.invoice_id;
            this.invoice_status = json.invoice_status;
            this.total_cost = json.total_cost;
        }
        else {
            this.invoice_id = 0;
            this.invoice_status = 0;
            this.total_cost = 0;
        }
    }
}