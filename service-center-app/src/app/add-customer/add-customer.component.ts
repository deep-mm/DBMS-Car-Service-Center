import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Car } from '../models/Car';
import { Customer } from '../models/Customer';
import { CustomerCar } from '../models/CustomerCar';
import { CustomerCarService } from '../services/customer-car/customer-car.service';
import { CustomerService } from '../services/customer/customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.scss']
})
export class AddCustomerComponent implements OnInit {

  customer: Customer = new Customer({
    customer_id: 0,
    service_center_id: 0,
    first_name: "",
    last_name: "",
    email: "",
    address: "",
    username: "",
    password: "",
    status: 0
  });

  customerCar: CustomerCar = new CustomerCar({
    vin: 0,
    mileage: 0,
    last_scheduled_maintenance: 0,
    customer_id: 0,
    service_center_id: 0,
    year: 0,
    car_id: 0
  });

  cars: Car[] = [];
  loading: boolean = false;

  constructor(public router: Router, public _apiService: CustomerService, private _snackBar: MatSnackBar, public customerCarApiService: CustomerCarService) { }

  ngOnInit(): void {
    this.loading = true;
    this._apiService.getCars().subscribe((cars: Car[]) => {
      this.cars = cars;
      this.loading = false;
    },
      error => {
        this.loading = false;
        console.error('Error occurred while retrieving list of cars from the database. Error: ' + error);
      });
  }

  submitForm() {
    this.loading = true;
    this.customer.service_CENTER_ID = CustomerService.serviceCenterId;
    console.log(this.customer);
    this._apiService.addCustomer(this.customer).subscribe(
      (data) => {
        console.log(data);
        this.customerCar.customer_ID = this.customer.customer_ID;
        this.customerCar.service_CENTER_ID = this.customer.service_CENTER_ID;
        this.customerCarApiService.addCustomerCar(this.customerCar).subscribe(
          (data) => {
            console.log(data);
            this.loading = false;
            this._snackBar.open('Customer added successfully', 'Close', {
              duration: 2000,
            });
            this.router.navigate(['receptionistHomePage']);
          });
      },
      (err) => {
        console.log(err);
        this.loading = false;
      }
    );
  }

}
