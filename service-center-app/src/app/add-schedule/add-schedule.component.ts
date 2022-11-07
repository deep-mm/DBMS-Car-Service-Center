import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Customer } from '../models/Customer';
import { CustomerCar } from '../models/CustomerCar';
import { MaintenanceService } from '../models/MaintenanceService';
import { RepairService } from '../models/RepairService';
import { Service } from '../models/Service';
import { ServiceService } from '../services/service/service.service';

@Component({
  selector: 'app-add-schedule',
  templateUrl: './add-schedule.component.html',
  styleUrls: ['./add-schedule.component.scss']
})
export class AddScheduleComponent implements OnInit {

  loading: boolean = false;
  services: Service[] = [];
  maintenanceServices: MaintenanceService[] = [];
  repairServices: RepairService[] = [];
  onlyRepairServices: Service[] = [];
  onlyMaintenanceServices: Service[] = [];
  cartService: Service[] = [];
  customer: Customer = new Customer();
  customerCar: CustomerCar = new CustomerCar();
  nextScheduledService: String = '';
  nextScheduledServiceId: number = 0;
  maintenanceServiceAdded: boolean = false;

  constructor(public router: Router, public _apiService: ServiceService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loading = true;
    this.customer = ServiceService.selectedCustomer;
    this.customerCar = ServiceService.selectedCustomerCar;
    this.nextScheduledService = this.customerCar.last_SCHEDULED_MAINTENANCE==1?'B':(this.customerCar.last_SCHEDULED_MAINTENANCE==2?'C':'A');
    this.nextScheduledServiceId = this.customerCar.last_SCHEDULED_MAINTENANCE==1?2:(this.customerCar.last_SCHEDULED_MAINTENANCE==2?3:1);
    this._apiService.getServices().subscribe(
      (res: any) => {
        this.services = res;
        this._apiService.getMaintenanceServices().subscribe(
          (res: any) => {
            this.maintenanceServices = res;
            this.onlyMaintenanceServices = this.services.filter(service => this.checkIfServiceIsMaintenance(service));
            this._apiService.getRepairServices().subscribe(
              (res: any) => {
                this.repairServices = res;
                this.onlyRepairServices = this.services.filter(service => this.checkIfServiceIsRepair(service));
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

  checkIfServiceIsMaintenance(service: Service) {
    for (const element of this.maintenanceServices) {
      if (element.id == service.id && element.schedule_BUNDLE_ID <= this.nextScheduledServiceId) {
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

  addToCart(service: Service) {
    this.cartService.push(service);
    this._snackBar.open('Service added to cart', 'Close', {
      duration: 2000,
    });
  }

  removeFromCart(service: Service) {
    this.cartService = this.cartService.filter(element => element.id != service.id);
    this._snackBar.open('Service removed from cart', 'Close', {
      duration: 2000,
    });
  }

  isServiceInCart(service: Service) {
    for (const element of this.cartService) {
      if (element.id == service.id) {
        return true;
      }
    }
    return false;
  }

  addMaintenanceServicesToCart() {
    this.cartService = this.cartService.concat(this.onlyMaintenanceServices);
    this.maintenanceServiceAdded = true;
    this._snackBar.open('Maintenance services added to cart', 'Close', {
      duration: 2000,
    });
  }

  checkout() {
    ServiceService.selectedServices = this.cartService;
    this.router.navigate(['/checkout']);
  }
}
