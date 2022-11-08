import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { Invoice } from 'src/app/models/Invoice';
import { MaintenanceService } from 'src/app/models/MaintenanceService';
import { RepairService } from 'src/app/models/RepairService';
import { Service } from 'src/app/models/Service';
import { ServiceEvent } from 'src/app/models/ServiceEvent';
import { ServicesCar } from 'src/app/models/ServicesCar';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private apiUrl = environment.apiBaseUrl + "/service";
  private maintenanceServiceUrl = environment.apiBaseUrl + "/maintenanceService";
  private repairServiceUrl = environment.apiBaseUrl + "/repairService";
  private serviceCarUrl = environment.apiBaseUrl + "/servicesCar";
  private serviceEventUrl = environment.apiBaseUrl + "/serviceEvent";
  private invoiceApiUrl = environment.apiBaseUrl + "/invoice";
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

  public getServiceCars(carId: number): Observable<ServicesCar[]> {
    return this.http.get(`${this.serviceCarUrl}/${carId}`).pipe(
      map((json: any) => {
        const services: ServicesCar[] = [];
        for (const service of json) {
          services.push(new ServicesCar(service));
        }
        return services;
      })
    );
  }

  public addServiceCar(serviceCar: ServicesCar): Observable<boolean> {
    return this.http.post<any>(`${this.serviceCarUrl}`, serviceCar).pipe(map((json: boolean) => {
      return json;
    }));
  } 

  public getAvailableMechanic(serviceCenterId: number, date: string): Observable<number> {
    return this.http.get(`${this.serviceEventUrl}/getMechanic/${serviceCenterId}?date=${date}`).pipe(
      map((json: any) => {
        return json;
      })
    );
  }

  public addInvoice(invoice: Invoice): Observable<boolean> {
    return this.http.post<any>(`${this.invoiceApiUrl}`, invoice).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public addServiceEvent(serviceEvent: ServiceEvent): Observable<boolean> {
    return this.http.post<any>(`${this.serviceEventUrl}`, serviceEvent).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public addServiceEvents(serviceEvents: ServiceEvent[]): Observable<boolean> {
    return this.http.post<any>(`${this.serviceEventUrl}/all`, serviceEvents).pipe(map((json: boolean) => {
      return json;
    }));
  }

}
