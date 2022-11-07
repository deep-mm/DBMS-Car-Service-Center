import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Car } from '../models/Car';
import { CustomerCar } from '../models/CustomerCar';
import { CustomerCarService } from '../services/customer-car/customer-car.service';
import { CustomerService } from '../services/customer/customer.service';

@Component({
  selector: 'app-add-customer-car',
  templateUrl: './add-customer-car.component.html',
  styleUrls: ['./add-customer-car.component.scss']
})
export class AddCustomerCarComponent implements OnInit {

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
    console.log(this.customerCar);
    this.customerCar.customer_ID = CustomerCarService.customerId;
    this.customerCar.service_CENTER_ID = CustomerCarService.serviceCenterId;
    this.customerCarApiService.addCustomerCar(this.customerCar).subscribe(
      (data) => {
        console.log(data);
        this.loading = false;
        this._snackBar.open('Car added successfully', 'Close', {
          duration: 2000,
        });
        this.router.navigate(['customerHomePage']);
      }, (err) => {
        console.log(err);
        this.loading = false;
      });
  }

}
