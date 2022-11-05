import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AddServiceCenterComponent } from '../add-service-center/add-service-center.component';
import { ServiceCenter } from '../models/ServiceCenter';
import { ServiceCenterService } from '../services/service-center/service-center.service';

@Component({
  selector: 'app-service-center',
  templateUrl: './service-center.component.html',
  styleUrls: ['./service-center.component.scss']
})
export class ServiceCenterComponent implements OnInit {

  serviceCenters: ServiceCenter[] = [];
  loading: boolean = false;

  constructor(public router: Router, public _apiService: ServiceCenterService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loading = true;
    this._apiService.getServiceCenters().subscribe((serviceCenters: ServiceCenter[]) => {
      this.serviceCenters = serviceCenters;
      this.loading = false;
    },
      error => {
        this.loading = false;
        console.error('Error occurred while retrieving list of service centers from the database. Error: ' + error);
      });
  }

  addServiceCenter() {
    ServiceCenterService.selectedServiceCenter = null;
    this.router.navigate(['serviceCenter/new']);
  }

  editServiceCenter(serviceCenter: ServiceCenter) {
    ServiceCenterService.selectedServiceCenter = serviceCenter;
    this.router.navigate(['serviceCenter/new']);
  }

  deleteServiceCenter(serviceCenterId: number) {
    this.loading = true;
    this._apiService.deleteServiceCenter(serviceCenterId).subscribe((result: boolean) => {
      if (result) {
        this.serviceCenters = this.serviceCenters.filter(serviceCenter => serviceCenter.service_CENTER_ID !== serviceCenterId);
        this._snackBar.open('Service center deleted successfully', 'Close', {
          duration: 2000,
        });
      }
      this.loading = false;
    },
      error => {
        this.loading = false;
        console.error('Error occurred while deleting service center from the database. Error: ' + error);
      });
  }

}
