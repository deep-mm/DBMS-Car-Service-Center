import { Component, Input, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Employee } from '../models/Employee';
import { ServiceCenter } from '../models/ServiceCenter';
import { ServiceCenterService } from '../services/service-center/service-center.service';

@Component({
  selector: 'app-add-service-center',
  templateUrl: './add-service-center.component.html',
  styleUrls: ['./add-service-center.component.scss']
})
export class AddServiceCenterComponent implements OnInit {

  serviceCenter: ServiceCenter = new ServiceCenter({
    service_CENTER_ID: 0,
    address: "",
    telephone_NO: "",
    operational_STATUS: 0,
    weekend_WORKING: 0
  });

  employee: Employee = new Employee({
    employee_id: 0,
    service_center_id: 0,
    name: "",
    address: "",
    start_date: "",
    role: 0,
    email: "",
    phone: "",
    username: "",
    password: ""
  });

  loading: boolean = false;
  update: boolean = false;

  constructor(public router: Router, public _apiService: ServiceCenterService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    if (ServiceCenterService.selectedServiceCenter != null) {
      this.serviceCenter = ServiceCenterService.selectedServiceCenter;
      this.update = true;
    }
  }

  submitForm() {
    this.loading = true;
    this.serviceCenter.operational_STATUS = 0;
    this.serviceCenter.weekend_WORKING = this.serviceCenter.weekend_WORKING ? 1 : 0;
    console.log(this.serviceCenter);
    if (this.update) {
      this._apiService.updateServiceCenter(this.serviceCenter).subscribe((result: boolean) => {
        if (result) {
          this._snackBar.open('Service center updated successfully', 'Close', {
            duration: 2000,
          });
          this.router.navigate(['serviceCenter']);
        }
        this.loading = false;
      },
        error => {
          this.loading = false;
          console.error('Error occurred while updating service center in the database. Error: ' + error);
        });
    }
    else {
      this._apiService.addServiceCenter(this.serviceCenter).subscribe(
        (data) => {
          console.log(data);
          this.loading = false;
          this._snackBar.open('Service center added successfully', 'Close', {
            duration: 2000,
          });
          this.router.navigate(['serviceCenter']);
        },
        (err) => {
          console.log(err);
          this.loading = false;
        }
      );
    }
  }

}
