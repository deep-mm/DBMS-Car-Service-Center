import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { ServiceCenter } from 'src/app/models/ServiceCenter';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceCenterService {

  private baseUrl = environment.apiBaseUrl + "/serviceCenter";
  static selectedServiceCenter: any;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  
  
  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  public getServiceCenters(): Observable<ServiceCenter[]> {
    return this.http.get(`${this.baseUrl}`).pipe(
      map((json: any) => {
        const service_centers: ServiceCenter[] = [];
        for (const service_center of json) {
          service_centers.push(new ServiceCenter(service_center));
        }
        return service_centers;
      })
    );
  }

  public getServiceCenterById(serviceCenterId: number): Observable<ServiceCenter> {
    return this.http.get(`${this.baseUrl}/${serviceCenterId}`).pipe(
      map((json: any) => {
        return new ServiceCenter(json);
      })
    );
  }

  public addServiceCenter(serviceCenter: ServiceCenter): Observable<boolean> {
    return this.http.post<any>(`${this.baseUrl}`, serviceCenter).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public updateServiceCenter(serviceCenter: ServiceCenter): Observable<boolean> {
    return this.http.put<any>(`${this.baseUrl}/${serviceCenter.service_CENTER_ID}`, serviceCenter).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public deleteServiceCenter(serviceCenterId: number): Observable<boolean> {
    return this.http.delete<any>(`${this.baseUrl}/${serviceCenterId}`).pipe(map((json: boolean) => {
      return json;
    })
    );
  }
}
