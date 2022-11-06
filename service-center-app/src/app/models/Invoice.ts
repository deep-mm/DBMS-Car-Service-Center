export class Invoice {

    invoice_ID: number;
    invoice_STATUS: number;
    total_COST: number;

    constructor(json?: any) {
        if (json) {
            this.invoice_ID = json.invoice_ID;
            this.invoice_STATUS = json.invoice_STATUS;
            this.total_COST = json.total_COST;
        }
        else{
            this.invoice_ID = 0;
            this.invoice_STATUS = 0;
            this.total_COST = 0;
        }
    }
}