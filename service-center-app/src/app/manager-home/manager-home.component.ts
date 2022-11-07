import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Car } from '../models/Car';
import { Employee } from '../models/Employee';
import { Service } from '../models/Service';
import { ServiceCenter } from '../models/ServiceCenter';
import { ServiceCenterProvidesService } from '../models/ServiceCenterProvidesService';
import { CarService } from '../services/car/car.service';
import { EmployeeService } from '../services/employee/employee.service';
import { ServiceCenterProvidesServiceService } from '../services/service-center-provides-service/service-center-provides-service.service';
import { ServiceCenterService } from '../services/service-center/service-center.service';
import { ServiceService } from '../services/service/service.service';

@Component({
  selector: 'app-manager-home',
  templateUrl: './manager-home.component.html',
  styleUrls: ['./manager-home.component.scss']
})
export class ManagerHomeComponent implements OnInit {

  serviceCenter: ServiceCenter = new ServiceCenter();
  manager: Employee = new Employee();
  employees: Employee[] = [];
  services: Service[] = [];
  serviceCenterProvidesService: ServiceCenterProvidesService[] = [];
  cars: Car[] = [];
  loading: boolean = false;
  checkbox: boolean = false;

  constructor(public router: Router, public employeeApiService: EmployeeService, public serviceCenterApiService: ServiceCenterService, private _snackBar: MatSnackBar, public serviceCenterProvidesServiceApi: ServiceCenterProvidesServiceService) { }

  ngOnInit(): void {
    this.loading = true;
    this.employeeApiService.getManager().subscribe((manager: Employee) => {
      this.manager = manager;
      this.serviceCenterApiService.getServiceCenterById(manager.service_CENTER_ID).subscribe((serviceCenter: ServiceCenter) => {
        this.serviceCenter = serviceCenter;
        EmployeeService.serviceCenter = serviceCenter;
        this.checkbox = serviceCenter.weekend_WORKING == 1 ? true : false;
        EmployeeService.serviceCenterId = serviceCenter.service_CENTER_ID;
        this.employeeApiService.getEmployeesByServiceCenter(serviceCenter.service_CENTER_ID).subscribe((employees: Employee[]) => {
          this.employees = employees.filter(employee => employee.employee_ID != manager.employee_ID);
          this.serviceCenterProvidesServiceApi.getServiceCenterProvidesServices(this.serviceCenter.service_CENTER_ID).subscribe((serviceCenterProvidesService: ServiceCenterProvidesService[]) => {
            this.serviceCenterProvidesService = serviceCenterProvidesService;
            this.loading = false;
          },
            error => {
              console.error('Error occurred while retrieving list of service center provides services from the database. Error: ' + error);
            }
          );
        },
          error => {
            this.loading = false;
            console.error('Error occurred while retrieving list of employees from the database. Error: ' + error);
          });
      },
        error => {
          this.loading = false;
          console.error('Error occurred while retrieving service center from the database. Error: ' + error);
        });
    },
      error => {
        this.loading = false;
        console.error('Error occurred while retrieving manager from the database. Error: ' + error);
      });

  }

  updateServiceCenter() {
    this.loading = true;
    this.serviceCenter.weekend_WORKING = this.checkbox ? 1 : 0;
    this.serviceCenterApiService.updateServiceCenter(this.serviceCenter).subscribe((success: boolean) => {
      this.loading = false;
      if (success) {
        this._snackBar.open('Service center updated successfully.', '', {
          duration: 3000,
        });
      }
      else {
        this._snackBar.open('Error occurred while updating service center.', '', {
          duration: 3000,
        });
      }
    },
      error => {
        this.loading = false;
        console.error('Error occurred while updating service center. Error: ' + error);
      });
  }

  addEmployee() {
    EmployeeService.roles = ["Receptionist", "Mechanic"];
    this.router.navigate(['employee/new']);
  }

  deleteEmployee(employee: Employee) {
    this.loading = true;
    this.employeeApiService.deleteEmployee(employee.employee_ID).subscribe((success: boolean) => {
      this.loading = false;
      if (success) {
        this._snackBar.open('Employee deleted successfully.', '', {
          duration: 3000,
        });
        this.ngOnInit();
      }
      else {
        this._snackBar.open('Error occurred while deleting employee.', '', {
          duration: 3000,
        });
      }
    },
      error => {
        this.loading = false;
        console.error('Error occurred while deleting employee. Error: ' + error);
      });
  }


  getPrice(service: Service, car: Car) {
    if (this.serviceCenterProvidesService.length > 0) {
      return this.serviceCenterProvidesService.find(serviceCenterProvidesService => serviceCenterProvidesService.id == service.id && serviceCenterProvidesService.car_ID == car.car_ID)!.price;
    }
    else {
      return 0;
    }
  }

  trackByIndex(index: number, obj: any): any {
    return index;
  }

  getIndex(service: Service, car: Car) {
    return this.serviceCenterProvidesService.findIndex(serviceCenterProvidesService => serviceCenterProvidesService.id == service.id && serviceCenterProvidesService.car_ID == car.car_ID);
  }

  updateService(serviceCenterProvidesService: ServiceCenterProvidesService) {
    this.loading = true;
    this.serviceCenterProvidesServiceApi.updateServiceCenterProvidesService(serviceCenterProvidesService).subscribe((success: boolean) => {
      this.loading = false;
      if (success) {
        this._snackBar.open('Service updated successfully.', '', {
          duration: 3000,
        });
      }
      else {
        this._snackBar.open('Error occurred while updating service.', '', {
          duration: 3000,
        });
      }
    },
      error => {
        this.loading = false;
        console.error('Error occurred while updating service. Error: ' + error);
      });
  }
}
