import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Employee } from '../models/Employee';
import { Leave } from '../models/Leave';
import { MechanicSchedule } from '../models/MechanicSchedule';
import { SwapSlot } from '../models/SwapSlot';
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
  leaves: Leave[] = []; 
  swapSlots: SwapSlot[] = [];

  constructor(public router: Router, private _snackBar: MatSnackBar, public employeeApiService: EmployeeService) { }

  ngOnInit(): void {
    this.loading = true;
    this.employeeApiService.getManager().subscribe((mechanic: Employee) => {
      this.mechanic = mechanic;
      CustomerService.serviceCenterId = mechanic.service_CENTER_ID;
      EmployeeService.employeeId = mechanic.employee_ID;
      EmployeeService.serviceCenterId = mechanic.service_CENTER_ID;
      this.employeeApiService.getMechanicSchedule(this.mechanic.service_CENTER_ID,this.mechanic.employee_ID).subscribe((mechanicSchedule: MechanicSchedule[]) => {
        this.mechanicSchedule = mechanicSchedule;
        this.employeeApiService.getLeaves(this.mechanic.service_CENTER_ID).subscribe((leaves: Leave[]) => {
          this.leaves = leaves.filter(leave => leave.employee_ID == this.mechanic.employee_ID);
          this.employeeApiService.getSwapSlots(this.mechanic.service_CENTER_ID).subscribe((swapSlots: SwapSlot[]) => {
            this.swapSlots = swapSlots.filter(swapSlot => swapSlot.requested_employee_id == this.mechanic.employee_ID || swapSlot.requestor_employee_id == this.mechanic.employee_ID);
            this.loading = false;
          }, (err) => {
            console.log(err);
            this.loading = false;
          }
          );
        },
        error => {
          this.loading = false;
          console.error('Error occurred while retrieving list of leaves from the database. Error: ' + error);
        }
      );
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

  applyLeave() {
    this.router.navigate(['leave/new']);
  }

  applySwapSlot() {
    this.router.navigate(['swapSlot/new']);
  }

  approveSwap(slot: SwapSlot, status: number) {
    this.loading = true;
    slot.status = status;
    this.employeeApiService.updateSwapSlot(slot).subscribe((data) => {
      console.log(data);
      this.loading = false;
      this._snackBar.open('Swap slot approved successfully', 'Close', {
        duration: 2000,
      });
      this.ngOnInit();
    }, (err) => {
      console.log(err);
      this.loading = false;
    });
  }
}
