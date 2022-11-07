import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { MaintenanceService } from '../models/MaintenanceService';
import { RepairService } from '../models/RepairService';
import { Service } from '../models/Service';
import { ServiceService } from '../services/service/service.service';

@Component({
  selector: 'app-admin-main',
  templateUrl: './admin-main.component.html',
  styleUrls: ['./admin-main.component.scss']
})
export class AdminMainComponent implements OnInit {

  loading: boolean = false;
  services: Service[] = [];
  maintenanceServices: MaintenanceService[] = [];
  repairServices: RepairService[] = [];

  constructor(public router: Router, public _apiService: ServiceService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loading = true;
    this._apiService.getServices().subscribe(
      (res: any) => {
        this.services = res;
        this._apiService.getMaintenanceServices().subscribe(
          (res: any) => {
            this.maintenanceServices = res;
            this._apiService.getRepairServices().subscribe(
              (res: any) => {
                this.repairServices = res;
                this.loading = false;
              },
              error => {
                this.loading = false;
                console.error('Error occurred while retrieving repair services from the database. Error: ' + error);
              }
            );
          },
          error => {
            this.loading = false;
            console.error('Error occurred while retrieving maintenance services from the database. Error: ' + error);
          }
        );
      },
      error => {
        this.loading = false;
        console.error('Error occurred while retrieving services from the database. Error: ' + error);
      }
    );
  }

  viewServiceCenters() {
    this.router.navigate(['serviceCenter']);
  }

  addService() {
    this.router.navigate(['service/new']);
  }

  checkIfServiceIsMaintenance(service: Service) {
    for (const element of this.maintenanceServices) {
      if (element.id == service.id) {
        return true;
      }
    }
    return false;
  }

  checkIfServiceIsRepair(service: Service) {
    for (const element of this.repairServices) {
      if (element.id == service.id) {
        return true;
      }
    }
    return false;
  }
}
