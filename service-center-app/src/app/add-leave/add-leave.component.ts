import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Leave } from '../models/Leave';
import { CustomerService } from '../services/customer/customer.service';
import { EmployeeService } from '../services/employee/employee.service';

@Component({
  selector: 'app-add-leave',
  templateUrl: './add-leave.component.html',
  styleUrls: ['./add-leave.component.scss']
})
export class AddLeaveComponent implements OnInit {

  leave: Leave = new Leave({
    leave_ID: 0,
    start_DATE: "",
    end_DATE: "",
    status: 0,
    employee_ID: 0,
    service_CENTER_ID: 0
  });

  loading: boolean = false;

  constructor(public router: Router, public _apiService: EmployeeService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  submitForm() {
    this.loading = true;
    console.log(this.leave);
    this.leave.employee_ID = EmployeeService.employeeId;
    this.leave.service_CENTER_ID = EmployeeService.serviceCenterId;
    this.leave.status = 0;
    let datePipe = new DatePipe('en-US');
    this.leave.start_DATE = datePipe.transform(this.leave.start_DATE, 'dd-MMM-yyyy')!.toString();
    this.leave.end_DATE = datePipe.transform(this.leave.end_DATE, 'dd-MMM-yyyy')!.toString();
    this._apiService.addLeave(this.leave).subscribe(
      (data) => {
        console.log(data);
        this.loading = false;
        this._snackBar.open('Leave requested successfully', 'Close', {
          duration: 2000,
        });
        this.router.navigate(['mechanicHomePage']);
      }, (err) => {
        console.log(err);
        this.loading = false;
      });
  }

}
