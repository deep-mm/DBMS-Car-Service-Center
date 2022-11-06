import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { ServiceCategory } from '../models/ServiceCategory';
import { ServiceCategoryService } from '../services/service-category/service-category.service';

@Component({
  selector: 'app-service-category',
  templateUrl: './service-category.component.html',
  styleUrls: ['./service-category.component.scss']
})
export class ServiceCategoryComponent implements OnInit {

  serviceCategories: ServiceCategory[] = [];
  loading: boolean = false;

  constructor(public router: Router, public _apiService: ServiceCategoryService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loading = true;
    this._apiService.getServiceCategories().subscribe((serviceCategories: ServiceCategory[]) => {
      this.serviceCategories = serviceCategories;
      this.loading = false;
    },
      error => {
        this.loading = false;
        console.error('Error occurred while retrieving list of service categories from the database. Error: ' + error);
      });
  }

  addServiceCategory() {
    this.router.navigate(['serviceCategory/new']);
  }

  deleteServiceCategory(serviceCategoryId: number) {
    this.loading = true;
    this._apiService.deleteServiceCategory(serviceCategoryId).subscribe((result: boolean) => {
      if (result) {
        this.serviceCategories = this.serviceCategories.filter(category => category.category_ID !== serviceCategoryId);
        this._snackBar.open('Service category deleted successfully', 'Close', {
          duration: 2000,
        });
      }
      this.loading = false;
    },
      error => {
        this.loading = false;
        console.error('Error occurred while deleting service category from the database. Error: ' + error);
      });
  }

}
