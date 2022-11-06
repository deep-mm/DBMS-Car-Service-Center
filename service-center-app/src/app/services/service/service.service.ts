import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { Service } from 'src/app/models/Service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private apiUrl = environment.apiBaseUrl + "/service";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  public getServices(): Observable<Service[]> {
    return this.http.get(`${this.apiUrl}`).pipe(
      map((json: any) => {
        const services: Service[] = [];
        for (const service of json) {
          services.push(new Service(service));
        }
        return services;
      })
    );
  }

  public getServiceById(serviceId: number): Observable<Service> {
    return this.http.get(`${this.apiUrl}/${serviceId}`).pipe(
      map((json: any) => {
        return new Service(json);
      })
    );
  }

  public addService(service: Service): Observable<boolean> {
    return this.http.post<any>(`${this.apiUrl}`, service).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public updateService(service: Service): Observable<boolean> {
    return this.http.put<any>(`${this.apiUrl}`, service).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public deleteService(serviceId: number): Observable<boolean> {
    return this.http.delete<any>(`${this.apiUrl}/${serviceId}`).pipe(map((json: boolean) => {
      return json;
    }));
  }
  
}
