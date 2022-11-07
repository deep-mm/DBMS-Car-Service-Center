import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { MechanicSchedule } from '../models/MechanicSchedule';
import { SwapSlot } from '../models/SwapSlot';
import { EmployeeService } from '../services/employee/employee.service';

@Component({
  selector: 'app-add-swap',
  templateUrl: './add-swap.component.html',
  styleUrls: ['./add-swap.component.scss']
})
export class AddSwapComponent implements OnInit {

  swapSlot: SwapSlot = new SwapSlot({
    invoice_give: 0,
    invoice_take: 0,
    requested_employee_id: 0,
    requested_service_center_id: 0,
    requestor_employee_id: 0,
    requestor_service_center_id: 0,
    status: 0
  });

  loading: boolean = false;
  mechanicSchedule: MechanicSchedule[] = [];
  currentEmployeeId: number = EmployeeService.employeeId;
  currentMechanicsSchedules: MechanicSchedule[] = [];
  otherMechanicSchedule: MechanicSchedule[] = [];

  constructor(public router: Router, public _apiService: EmployeeService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loading = true;
    this._apiService.getMechanicsSchedules(EmployeeService.serviceCenterId).subscribe(
      (data) => {
        this.mechanicSchedule = data;
        this.currentMechanicsSchedules = this.mechanicSchedule.filter((schedule) => schedule.mechanic_ID == this.currentEmployeeId);
        this.otherMechanicSchedule = this.mechanicSchedule.filter((schedule) => schedule.mechanic_ID != this.currentEmployeeId);
        this.loading = false;
        console.log(data);
      }, (err) => {
        console.log(err);
        this.loading = false;
      });
  }

  submitForm() {
    this.loading = true;
    console.log(this.swapSlot);
    this.swapSlot.requested_service_center_id = EmployeeService.serviceCenterId;
    this.swapSlot.requestor_service_center_id = EmployeeService.serviceCenterId;
    this.swapSlot.requestor_employee_id = this.currentEmployeeId;
    this.swapSlot.requested_employee_id = this.otherMechanicSchedule.find((schedule) => schedule.invoice_ID == this.swapSlot.invoice_take)?.mechanic_ID!;
    this.swapSlot.status = 0;
    this._apiService.addSwapSlot(this.swapSlot).subscribe(
      (data) => {
        console.log(data);
        this.loading = false;
        this._snackBar.open('Swap requested successfully', 'Close', {
          duration: 2000,
        });
        this.router.navigate(['mechanicHomePage']);
      }, (err) => {
        console.log(err);
        this.loading = false;
      });
  }

}
