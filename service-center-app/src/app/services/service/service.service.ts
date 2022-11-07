import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { MaintenanceService } from 'src/app/models/MaintenanceService';
import { RepairService } from 'src/app/models/RepairService';
import { Service } from 'src/app/models/Service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private apiUrl = environment.apiBaseUrl + "/service";
  private maintenanceServiceUrl = environment.apiBaseUrl + "/maintenanceService";
  private repairServiceUrl = environment.apiBaseUrl + "/repairService";
  static selectedCustomer: any;
  static selectedCustomerCar: any;
  static selectedServices: any;

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

  public getMaintenanceServices(): Observable<MaintenanceService[]> {
    return this.http.get(`${this.maintenanceServiceUrl}/3`).pipe(
      map((json: any) => {
        const services: MaintenanceService[] = [];
        for (const service of json) {
          services.push(new MaintenanceService(service));
        }
        return services;
      })
    );
  }

  public addMaintenanceService(maintenanceService: MaintenanceService): Observable<boolean> {
    return this.http.post<any>(`${this.maintenanceServiceUrl}`, maintenanceService).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public getRepairServices(): Observable<RepairService[]> {
    return this.http.get(`${this.repairServiceUrl}`).pipe(
      map((json: any) => {
        const services: RepairService[] = [];
        for (const service of json) {
          services.push(new RepairService(service));
        }
        return services;
      })
    );
  }

  public addRepairService(repairService: RepairService): Observable<boolean> {
    return this.http.post<any>(`${this.repairServiceUrl}`, repairService).pipe(map((json: boolean) => {
      return json;
    }));
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
