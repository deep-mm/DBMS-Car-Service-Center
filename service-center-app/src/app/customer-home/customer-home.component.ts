import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Customer } from '../models/Customer';
import { CustomerCar } from '../models/CustomerCar';
import { CustomerScheduledService } from '../models/CustomerScheduledService';
import { Invoice } from '../models/Invoice';
import { CustomerCarService } from '../services/customer-car/customer-car.service';
import { CustomerService } from '../services/customer/customer.service';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.scss']
})
export class CustomerHomeComponent implements OnInit {

  loading: boolean = false;
  customer: Customer = new Customer();
  customerSchedules: CustomerScheduledService[] = [];
  invoices: Invoice[] = [];
  customerCars: CustomerCar[] = [];

  constructor(public router: Router, public _apiService: CustomerService, private _snackBar: MatSnackBar, public customerCarService: CustomerCarService) { }

  ngOnInit(): void {
    this.loading = true;
    this._apiService.getCustomerByUsername().subscribe(
      (res: any) => {
        this.customer = res;
        this._apiService.getCustomerSchedules(this.customer.service_CENTER_ID, this.customer.customer_ID).subscribe((customerSchedules: CustomerScheduledService[]) => {
          this.customerSchedules = customerSchedules;
          this._apiService.getInvoicesForCustomer(this.customer.service_CENTER_ID, this.customer.customer_ID).subscribe((invoices: Invoice[]) => {
            this.invoices = invoices;
            this.customerCarService.getCustomerCarsByCustomerId(this.customer.service_CENTER_ID, this.customer.customer_ID).subscribe((customerCars: CustomerCar[]) => {
              this.customerCars = customerCars;
              this.loading = false;
            }, error => {
              this.loading = false;
              console.error('Error occurred while getting customer cars. Error: ' + error);
            }
            );
          });
        }, error => {
          this.loading = false;
          console.error('Error occurred while retrieving list of customer schedules from the database. Error: ' + error);
        });
      },
      error => {
        this.loading = false;
        console.error('Error occurred while retrieving customer from the database. Error: ' + error);
      }
    );

  }

  viewProfile() {
    CustomerService.selectedCustomer = this.customer;
    this.router.navigate(['customer/new']);
  }

  updateInvoice(invoice: Invoice) {
    this.loading = true;
    invoice.invoice_STATUS = 1;
    this._apiService.updateInvoice(invoice).subscribe((res: any) => {
      this.loading = false;
      this._snackBar.open('Invoice paid successfully!', 'Close', {
        duration: 3000,
      });
    }, error => {
      this.loading = false;
      console.error('Error occurred while updating invoice. Error: ' + error);
    });
  }

  deleteCustomerCar(customerCar: CustomerCar) {
    this.loading = true;
    this.customerCarService.deleteCustomerCar(customerCar.vin).subscribe((res: any) => {
      this.loading = false;
      this.customerCars = this.customerCars.filter((car: CustomerCar) => car.vin !== customerCar.vin);
      this._snackBar.open('Customer car deleted successfully!', 'Close', {
        duration: 3000,
      });
    }, error => {
      this.loading = false;
      console.error('Error occurred while deleting customer car. Error: ' + error);
    });
  }

  addCustomerCar() {
    CustomerCarService.customerId = this.customer.customer_ID;
    CustomerCarService.serviceCenterId = this.customer.service_CENTER_ID;
    this.router.navigate(['customer-car/new']);
  }
}
