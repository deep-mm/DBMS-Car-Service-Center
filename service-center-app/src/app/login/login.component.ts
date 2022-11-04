import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../models/Login';
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

  constructor(public router: Router, public _apiService: LoginService) { }

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
        else if (data.role == "customer") {
          this.router.navigate(['customerHomePage']);
        }
        else {
          this.router.navigate(['EmployeeHomePage']);
        }
      },
      (err) => {
        console.log(err);
        this.loading = false;
      }
    );
  }

}
