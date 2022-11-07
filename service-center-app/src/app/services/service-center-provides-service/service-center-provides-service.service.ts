import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { ServiceCenterProvidesService } from 'src/app/models/ServiceCenterProvidesService';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceCenterProvidesServiceService {

  private carApiUrl = environment.apiBaseUrl + "/serviceCenterProvidesService";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  public getServiceCenterProvidesServices(serviceCenterId: number): Observable<ServiceCenterProvidesService[]> {
    return this.http.get(`${this.carApiUrl}/${serviceCenterId}`).pipe(
      map((json: any) => {
        const serviceCenterProvidesServices: ServiceCenterProvidesService[] = [];
        for (const serviceCenterProvidesService of json) {
          serviceCenterProvidesServices.push(new ServiceCenterProvidesService(serviceCenterProvidesService));
        }
        return serviceCenterProvidesServices;
      })
    );
  }

  public getServiceCenterProvidesServiceById(serviceCenterProvidesServiceId: number): Observable<ServiceCenterProvidesService> {
    return this.http.get(`${this.carApiUrl}/${serviceCenterProvidesServiceId}`).pipe(
      map((json: any) => {
        return new ServiceCenterProvidesService(json);
      })
    );
  }

  public addServiceCenterProvidesService(serviceCenterProvidesService: ServiceCenterProvidesService): Observable<boolean> {
    return this.http.post<any>(`${this.carApiUrl}`, serviceCenterProvidesService).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public updateServiceCenterProvidesService(serviceCenterProvidesService: ServiceCenterProvidesService): Observable<boolean> {
    return this.http.put<any>(`${this.carApiUrl}/${serviceCenterProvidesService.service_CENTER_ID}/${serviceCenterProvidesService.car_ID}/${serviceCenterProvidesService.id}`, serviceCenterProvidesService).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public deleteServiceCenterProvidesService(serviceCenterProvidesServiceId: number): Observable<boolean> {
    return this.http.delete<any>(`${this.carApiUrl}/${serviceCenterProvidesServiceId}`).pipe(map((json: boolean) => {
      return json;
    }));
  }

}
