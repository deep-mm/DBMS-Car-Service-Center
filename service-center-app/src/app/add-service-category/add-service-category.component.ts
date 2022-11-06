import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { ServiceCategory } from '../models/ServiceCategory';
import { ServiceCategoryService } from '../services/service-category/service-category.service';

@Component({
  selector: 'app-add-service-category',
  templateUrl: './add-service-category.component.html',
  styleUrls: ['./add-service-category.component.scss']
})
export class AddServiceCategoryComponent implements OnInit {

  serviceCategory: ServiceCategory = new ServiceCategory({
    category_id: 0,
    category_name: ""
  });

  loading: boolean = false;

  constructor(public router: Router, public _apiService: ServiceCategoryService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  submitForm() {
    this.loading = true;
    console.log(this.serviceCategory);
    this._apiService.addServiceCategory(this.serviceCategory).subscribe(
      (data) => {
        console.log(data);
        this.loading = false;
        this._snackBar.open('Service category added successfully', 'Close', {
          duration: 2000,
        });
        this.router.navigate(['serviceCategories']);
      },
      (err) => {
        console.log(err);
        this.loading = false;
      }
    );
  }

}
