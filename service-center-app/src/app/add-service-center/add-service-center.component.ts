import { DatePipe, Location } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Employee } from '../models/Employee';
import { SalariedEmployee } from '../models/SalariedEmployee';
import { ServiceCenter } from '../models/ServiceCenter';
import { EmployeeService } from '../services/employee/employee.service';
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
    min_WAGE: 0,
    max_WAGE: 0,
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
  compensation: number = 0;

  constructor(public router: Router, public _apiService: ServiceCenterService, private _snackBar: MatSnackBar, public employeeApiService: EmployeeService, private _location: Location) { }

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
    this._apiService.addServiceCenter(this.serviceCenter).subscribe(
      (data) => {
        console.log(data);
        this.addEmployee(this.serviceCenter.service_CENTER_ID);
      },
      (err) => {
        console.log(err);
        this.loading = false;
      }
    );
  }

  addEmployee(serviceCenterId: number) {
    this.employee.service_CENTER_ID = serviceCenterId;
    let datePipe = new DatePipe('en-US');
    this.employee.start_DATE = datePipe.transform(this.employee.start_DATE, 'dd-MMM-yyyy')!.toString();
    this.employee.role = 1;
    console.log(this.employee);
    this.employeeApiService.addEmployee(this.employee).subscribe(
      (data) => {
        console.log(data);
        let salariedEmployee = new SalariedEmployee({
          employee_ID: this.employee.employee_ID,
          service_CENTER_ID: this.employee.service_CENTER_ID,
          salary: this.compensation
        });
        this.employeeApiService.addSalariedEmployee(salariedEmployee).subscribe(
          (data) => {
            console.log(data);
            this.loading = false;
            this._snackBar.open('Service center added successfully', 'Close', {
              duration: 2000,
            });
            this.router.navigate(['serviceCenter']);
          }
        );
      },
      (err) => {
        console.log(err);
        this.loading = false;
      }
    );
  }
}
