import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { ScheduleBundle } from 'src/app/models/ScheduleBundle';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ScheduleBundleService {

  private baseUrl = environment.apiBaseUrl + "/scheduleBundle";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };


  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  public getScheduleBundles(): Observable<ScheduleBundle[]> {
    return this.http.get(`${this.baseUrl}`).pipe(
      map((json: any) => {
        const schedule_bundles: ScheduleBundle[] = [];
        for (const schedule_bundle of json) {
          schedule_bundles.push(new ScheduleBundle(schedule_bundle));
        }
        return schedule_bundles;
      })
    );
  }

  public addScheduleBundle(scheduleBundle: ScheduleBundle): Observable<boolean> {
    return this.http.post<any>(`${this.baseUrl}`, scheduleBundle).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public updateScheduleBundle(scheduleBundle: ScheduleBundle): Observable<boolean> {
    return this.http.put<any>(`${this.baseUrl}/${scheduleBundle.schedule_BUNDLE_ID}`, scheduleBundle).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public deleteScheduleBundle(scheduleBundleId: number): Observable<boolean> {
    return this.http.delete<any>(`${this.baseUrl}/${scheduleBundleId}`).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

}
