import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { MaintenanceService } from '../models/MaintenanceService';
import { RepairService } from '../models/RepairService';
import { ScheduleBundle } from '../models/ScheduleBundle';
import { Service } from '../models/Service';
import { ServiceCategory } from '../models/ServiceCategory';
import { ScheduleBundleService } from '../services/schedule-bundle/schedule-bundle.service';
import { ServiceCategoryService } from '../services/service-category/service-category.service';
import { ServiceService } from '../services/service/service.service';

@Component({
  selector: 'app-add-service',
  templateUrl: './add-service.component.html',
  styleUrls: ['./add-service.component.scss']
})
export class AddServiceComponent implements OnInit {

  service: Service = new Service({
    id: 0,
    service_NAME: ""
  });

  repairService: RepairService = new RepairService({
    id: 0,
    category_ID: 0
  });

  maintenanceService: MaintenanceService = new MaintenanceService({
    id: 0,
    schedule_BUNDLE_ID: 0
  });

  loading: boolean = false;
  categories: ServiceCategory[] = [];
  scheduleBundles: ScheduleBundle[] = [];
  repairServiceCheck: boolean = false;
  maintenanceServiceCheck: boolean = false;

  constructor(public router: Router, public _apiService: ServiceService, private _snackBar: MatSnackBar, private categoryServce: ServiceCategoryService, private scheduleBundleService: ScheduleBundleService) { }

  ngOnInit(): void {
    this.loading = true;
    this.categoryServce.getServiceCategories().subscribe((data: ServiceCategory[]) => {
      this.categories = data;
      this.scheduleBundleService.getScheduleBundles().subscribe((data: ScheduleBundle[]) => {
        this.scheduleBundles = data;
        this.loading = false;
      },
        error => {
          this.loading = false;
          console.error('Error occurred while retrieving schedule bundles from the database. Error: ' + error);
        }
      );
    },
      error => {
        this.loading = false;
        console.error('Error occurred while retrieving service categories from the database. Error: ' + error);
      }
    );
  }

  submitForm() {
    this.loading = true;
    this._apiService.addService(this.service).subscribe((bool: boolean) => {
      if (bool) {
        if (this.repairService.category_ID != 0) {
          this.repairService.id = this.service.id;
          this._apiService.addRepairService(this.repairService).subscribe((result: boolean) => {
            if (result) {
              this._snackBar.open('Service added successfully', 'Close', {
                duration: 2000,
              });
              this.router.navigate(['adminHomePage']);
              this.loading = false;
            }
            this.loading = false;
          },
            error => {
              this.loading = false;
              console.error('Error occurred while adding repair service to the database. Error: ' + error);
            });
        }

        if (this.maintenanceService.schedule_BUNDLE_ID != 0) {
          this.maintenanceService.id = this.service.id;
          this._apiService.addMaintenanceService(this.maintenanceService).subscribe((result: boolean) => {
            if (result) {
              this._snackBar.open('Service added successfully', 'Close', {
                duration: 2000,
              });
              this.router.navigate(['adminHomePage']);
              this.loading = false;
            }
            this.loading = false;
          },
            error => {
              this.loading = false;
              console.error('Error occurred while adding maintenance service to the database. Error: ' + error);
            });
        }
      }
      else{
        this.loading = false;
      }
    }

    );

  }

}
