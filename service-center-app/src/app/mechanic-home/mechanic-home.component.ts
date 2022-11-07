import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Employee } from '../models/Employee';
import { MechanicSchedule } from '../models/MechanicSchedule';
import { CustomerService } from '../services/customer/customer.service';
import { EmployeeService } from '../services/employee/employee.service';

@Component({
  selector: 'app-mechanic-home',
  templateUrl: './mechanic-home.component.html',
  styleUrls: ['./mechanic-home.component.scss']
})
export class MechanicHomeComponent implements OnInit {

  loading: boolean = false;
  filter: boolean = false;
  mechanic: Employee = new Employee();
  mechanicSchedule: MechanicSchedule[] = [];

  constructor(public router: Router, private _snackBar: MatSnackBar, public employeeApiService: EmployeeService) { }

  ngOnInit(): void {
    this.loading = true;
    this.employeeApiService.getManager().subscribe((mechanic: Employee) => {
      this.mechanic = mechanic;
      CustomerService.serviceCenterId = mechanic.service_CENTER_ID;
      this.employeeApiService.getMechanicSchedule(this.mechanic.service_CENTER_ID,this.mechanic.employee_ID).subscribe((mechanicSchedule: MechanicSchedule[]) => {
        this.mechanicSchedule = mechanicSchedule;
        this.loading = false;
      },
        error => {
          this.loading = false;
          console.error('Error occurred while retrieving list of mechanic schedules from the database. Error: ' + error);
        }
      );
    },
      error => {
        this.loading = false;
        console.error('Error occurred while retrieving mechanics details from the database. Error: ' + error);
      });
  }

}
