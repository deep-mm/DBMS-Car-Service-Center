import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Login } from '../models/Login';
import { CustomerService } from '../services/customer/customer.service';
import { EmployeeService } from '../services/employee/employee.service';
import { LoginService } from '../services/login-service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login: Login = new Login({
    "username": "",
    "password": "",
    "role": ""
  });
  loading: boolean = false;

  constructor(public router: Router, public _apiService: LoginService, private _snackBar: MatSnackBar, public employeeApiService: EmployeeService) { }

  ngOnInit(): void {
  }

  submitForm() {
    this.loading = true;
    this._apiService.login(this.login).subscribe(
      (data) => {
        console.log(data);
        this.loading = false;
        this.router.navigate(['home']);
        if (data.role == "Admin") {
          this.router.navigate(['adminHomePage']);
        }
        else if (data.role == "Customer") {
          CustomerService.customerUsername = data.username;
          this.router.navigate(['customerHomePage']);
        }
        else if (data.role == "Employee_1") {
          EmployeeService.managerUsername = data.username;
          this.router.navigate(['managerHomePage']);
        }
        else if (data.role == "Employee_2") {
          EmployeeService.managerUsername = data.username;
          this.router.navigate(['receptionistHomePage']);
        }
        else if (data.role == "Employee_3") {
          EmployeeService.managerUsername = data.username;
          this.router.navigate(['mechanicHomePage']);
        }
        else {
          this._snackBar.open("Login Failed", "OK");
        }
      },
      (err) => {
        console.log(err);
        this.loading = false;
      }
    );
  }

}
