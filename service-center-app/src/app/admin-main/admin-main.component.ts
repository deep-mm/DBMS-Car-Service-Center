import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-main',
  templateUrl: './admin-main.component.html',
  styleUrls: ['./admin-main.component.scss']
})
export class AdminMainComponent implements OnInit {

  constructor(public router: Router) { }

  ngOnInit(): void {
  }

  viewServiceCenters() {
    this.router.navigate(['serviceCenter']);
  }

  viewRepairServiceCategories() {
    this.router.navigate(['serviceCategories']);
  }

  viewScheduleBundles() {
    this.router.navigate(['scheduleBundles']);
  }

}
