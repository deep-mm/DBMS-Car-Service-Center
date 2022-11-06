import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { ScheduleBundle } from '../models/ScheduleBundle';
import { ScheduleBundleService } from '../services/schedule-bundle/schedule-bundle.service';

@Component({
  selector: 'app-schedule-bundle',
  templateUrl: './schedule-bundle.component.html',
  styleUrls: ['./schedule-bundle.component.scss']
})
export class ScheduleBundleComponent implements OnInit {

  scheduleBundles: ScheduleBundle[] = [];
  loading: boolean = false;

  constructor(public router: Router, public _apiService: ScheduleBundleService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loading = true;
    this._apiService.getScheduleBundles().subscribe((scheduleBundles: ScheduleBundle[]) => {
      this.scheduleBundles = scheduleBundles;
      this.loading = false;
    },
      error => {
        this.loading = false;
        console.error('Error occurred while retrieving list of schedule bundles from the database. Error: ' + error);
      });
  }

  addScheduleBundle() {
    this.router.navigate(['scheduleBundle/new']);
  }

  deleteScheduleBundle(scheduleBundleId: number) {
    this.loading = true;
    this._apiService.deleteScheduleBundle(scheduleBundleId).subscribe((result: boolean) => {
      if (result) {
        this.scheduleBundles = this.scheduleBundles.filter(scheduleBundle => scheduleBundle.schedule_BUNDLE_ID !== scheduleBundleId);
        this._snackBar.open('Schedule bundle deleted successfully', 'Close', {
          duration: 2000,
        });
      }
      this.loading = false;
    },
      error => {
        this.loading = false;
        console.error('Error occurred while deleting schedule bundle from the database. Error: ' + error);
      });
  }

}
