import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Employee } from '../models/Employee';
import { EmployeeService } from '../services/employee/employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.scss']
})
export class EmployeeDetailsComponent implements OnInit {

  loading: boolean = false;
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

  constructor(public router: Router, public _apiService: EmployeeService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loading = true;
  }

}
