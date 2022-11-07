import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Employee } from '../models/Employee';
import { EmployeeService } from '../services/employee/employee.service';
import {DatePipe, Location} from '@angular/common';
import { ServiceCenter } from '../models/ServiceCenter';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.scss']
})
export class AddEmployeeComponent implements OnInit {

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

  compensation: number = 0;
  serviceCenter: ServiceCenter = EmployeeService.serviceCenter;

  roles = ["Manager", "Receptionist", "Mechanic"];

  loading: boolean = false;

  constructor(public router: Router, public _apiService: EmployeeService, private _snackBar: MatSnackBar, private _location: Location) { }

  ngOnInit(): void {
    this.roles = EmployeeService.roles;
  }

  submitForm() {
    this.loading = true;
    this.employee.service_CENTER_ID = EmployeeService.serviceCenterId;
    let datePipe = new DatePipe('en-US');
    this.employee.start_DATE = datePipe.transform(this.employee.start_DATE, 'dd-MMM-yyyy')!.toString();
    console.log(this.employee);
    this._apiService.addEmployee(this.employee).subscribe(
      (data) => {
        console.log(data);
        this.loading = false;
        this._snackBar.open('Employee added successfully', 'Close', {
          duration: 2000,
        });
        this._location.back();
      },
      (err) => {
        console.log(err);
        this.loading = false;
      }
    );
  }

}
