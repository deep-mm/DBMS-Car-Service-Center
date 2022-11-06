import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Employee } from '../models/Employee';
import { EmployeeService } from '../services/employee/employee.service';
import {Location} from '@angular/common';

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

  roles = ["Manager", "Receptionist", "Mechanic"];

  loading: boolean = false;

  constructor(public router: Router, public _apiService: EmployeeService, private _snackBar: MatSnackBar, private _location: Location) { }

  ngOnInit(): void {
  }

  submitForm() {
    this.loading = true;
    this.employee.service_center_id = this._apiService.serviceCenterId;
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
