import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Customer } from '../models/Customer';
import { CustomerCar } from '../models/CustomerCar';
import { Invoice } from '../models/Invoice';
import { MaintenanceService } from '../models/MaintenanceService';
import { RepairService } from '../models/RepairService';
import { Service } from '../models/Service';
import { ServiceCenterProvidesService } from '../models/ServiceCenterProvidesService';
import { ServiceEvent } from '../models/ServiceEvent';
import { ServicesCar } from '../models/ServicesCar';
import { ServiceCenterProvidesServiceService } from '../services/service-center-provides-service/service-center-provides-service.service';
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
  serviceCars: ServicesCar[] = [];
  scps: ServiceCenterProvidesService[] = [];
  preferredDate: Date = new Date();
  date: Date = new Date();
  time = [8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19]
  preferredTime: number = 0;
  remainingTime: number = 11;
  mechanicId: number = 0;

  constructor(public router: Router, public _apiService: ServiceService, private _snackBar: MatSnackBar, public scpsApi: ServiceCenterProvidesServiceService) { }

  ngOnInit(): void {
    this.loading = true;
    this.customer = ServiceService.selectedCustomer;
    this.customerCar = ServiceService.selectedCustomerCar;
    this.nextScheduledService = this.customerCar.last_SCHEDULED_MAINTENANCE == 1 ? 'B' : (this.customerCar.last_SCHEDULED_MAINTENANCE == 2 ? 'C' : 'A');
    this.nextScheduledServiceId = this.customerCar.last_SCHEDULED_MAINTENANCE == 1 ? 2 : (this.customerCar.last_SCHEDULED_MAINTENANCE == 2 ? 3 : 1);
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
                this.scpsApi.getServiceCenterProvidesServices(this.customer.service_CENTER_ID).subscribe(
                  (res: any) => {
                    this.scps = res;
                    this._apiService.getServiceCars(this.customerCar.car_ID).subscribe(
                      (res: any) => {
                        this.serviceCars = res;
                        this.loading = false;
                      },
                      (err: any) => {
                        this.loading = false;
                        console.log(err);
                      }
                    );
                  },
                  (err: any) => {
                    this.loading = false;
                    console.log(err);
                  }
                );
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
    this.remainingTime = this.remainingTime - this.getServiceTime(service);
    this.time = this.time.slice(0, this.remainingTime + 1);
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
    this.remainingTime = 11 - this.getTotalTime();
    this.time = this.time.slice(0, this.remainingTime + 1);
  }

  getServiceTime(service: Service): number {
    for (const element of this.serviceCars) {
      if (element.id == service.id) {
        return element.time_ESTIMATED;
      }
    }
    return 0;
  }

  getServicePrice(service: Service) {
    for (const element of this.scps) {
      if (element.id == service.id) {
        return element.price;
      }
    }
    return 0;
  }

  getTotalTime() {
    let total = 0;
    for (const element of this.cartService) {
      total += this.getServiceTime(element);
    }
    return total;
  }

  getTotalPrice() {
    let total = 0;
    for (const element of this.cartService) {
      total += this.getServicePrice(element);
    }
    return total;
  }

  checkout() {
    this.loading = true;
    let datePipe = new DatePipe('en-US');
    let dateString = datePipe.transform(this.preferredDate, 'dd-MMM-yyyy')!.toString();
    let currentStartTime = this.preferredTime;
    this._apiService.getAvailableMechanic(this.customer.service_CENTER_ID, dateString).subscribe(
      (res: any) => {
        this.mechanicId = res;
        let invoiceId = Math.floor(Math.random() * 90000) + 10000;
        let invoice = new Invoice({
          invoice_ID: invoiceId,
          invoice_STATUS: 0,
          total_COST: this.getTotalPrice()
        });
        this._apiService.addInvoice(invoice).subscribe(
          (res: any) => {
            if (res) {
              let serviceEvents: ServiceEvent[] = [];
              this.cartService.forEach(element => {
                let start_TIME = currentStartTime > 12 ? currentStartTime - 12 : currentStartTime;
                let end_TIME = +currentStartTime + this.getServiceTime(element);
                end_TIME = end_TIME > 12 ? end_TIME - 12 : end_TIME;
                currentStartTime = end_TIME;
                let serviceEvent = new ServiceEvent({
                  service_ID: Math.floor(Math.random() * 90000) + 10000,
                  id: element.id,
                  mechanic_ID: this.mechanicId,
                  service_CENTER_ID: this.customer.service_CENTER_ID,
                  vin: this.customerCar.vin,
                  invoice_ID: invoiceId,
                  start_TIME: datePipe.transform(this.preferredDate, 'dd-MMM-yyyy')!.toString() + " " + start_TIME + ":00:00",
                  end_TIME: datePipe.transform(this.preferredDate, 'dd-MMM-yyyy')!.toString() + " " + end_TIME + ":00:00"
                });
                serviceEvents.push(serviceEvent);
              });
              this._apiService.addServiceEvents(serviceEvents).subscribe(
                (res: any) => {
                  if (res) {
                    this.loading = false;
                    this._snackBar.open('Service booked', 'Close', {
                      duration: 2000,
                    });
                    this.router.navigate(['customerHomePage']);
                  }
                },
                (err: any) => {
                  this.loading = false;
                  console.log(err);
                }
              );
            }
          },
          (err: any) => {
            this.loading = false;
            console.log(err);
          }
        );

      },
      (err: any) => {
        this.loading = false;
        console.log(err);
      }
    )
  };
}
