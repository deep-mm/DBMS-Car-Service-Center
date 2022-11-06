import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Customer } from '../models/Customer';
import { CustomerService } from '../services/customer/customer.service';
import { ServiceCenterService } from '../services/service-center/service-center.service';

@Component({
  selector: 'app-receptionist-main',
  templateUrl: './receptionist-main.component.html',
  styleUrls: ['./receptionist-main.component.scss']
})
export class ReceptionistMainComponent implements OnInit {

  customers: Customer[] = [];
  loading: boolean = false;
  filter: boolean = false;

  constructor(public router: Router, public _apiService: CustomerService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loading = true;
    this.filterCustomers();
  }

  addCustomer() {
    CustomerService.selectedCustomer = null;
    this.router.navigate(['customer/new']);
  }

  deleteCustomer(customerId: number) {
    this.loading = true;
    this._apiService.deleteCustomer(customerId).subscribe((result: boolean) => {
      if (result) {
        this.customers = this.customers.filter(customer => customer.customer_id !== customerId);
        this._snackBar.open('Customer deleted successfully', 'Close', {
          duration: 2000,
        });
      }
      this.loading = false;
    },
      error => {
        this.loading = false;
        console.error('Error occurred while deleting customer from the database. Error: ' + error);
      });
  }

  filterCustomers(){
    this.loading = true;
    if (this.filter){
      this._apiService.getCustomersWithUnpaidInvoices().subscribe((customers: Customer[]) => {
        this.customers = customers;
        this.loading = false;
      },
        error => {
          this.loading = false;
          console.error('Error occurred while retrieving list of service centers from the database. Error: ' + error);
        });
    }
    else{
      this._apiService.getCustomersByServiceCenterId().subscribe((customers: Customer[]) => {
        this.customers = customers;
        this.loading = false;
      },
        error => {
          this.loading = false;
          console.error('Error occurred while retrieving list of service centers from the database. Error: ' + error);
        });

    }
  }

}
