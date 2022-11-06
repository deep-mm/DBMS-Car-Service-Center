import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Customer } from '../models/Customer';
import { Employee } from '../models/Employee';
import { CustomerService } from '../services/customer/customer.service';
import { EmployeeService } from '../services/employee/employee.service';
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
  receptionist: Employee = new Employee();

  constructor(public router: Router, public _apiService: CustomerService, private _snackBar: MatSnackBar, public employeeApiService: EmployeeService) { }

  ngOnInit(): void {
    this.loading = true;
    this.employeeApiService.getManager().subscribe((receptionist: Employee) => {
      this.receptionist = receptionist;
      CustomerService.serviceCenterId = receptionist.service_CENTER_ID;
      this.loading = false;
      this.filterCustomers();
    },
      error => {
        this.loading = false;
        console.error('Error occurred while retrieving list of service centers from the database. Error: ' + error);
      });
  }

  addCustomer() {
    CustomerService.selectedCustomer = null;
    this.router.navigate(['customer/new']);
  }

  deleteCustomer(serviceCenterId: number, customerId: number) {
    this.loading = true;
    this._apiService.deleteCustomer(serviceCenterId,customerId).subscribe((result: boolean) => {
      if (result) {
        this.customers = this.customers.filter(customer => customer.customer_ID !== customerId);
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
