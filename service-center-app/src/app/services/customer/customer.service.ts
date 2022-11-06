import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { Car } from 'src/app/models/Car';
import { Customer } from 'src/app/models/Customer';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = environment.apiBaseUrl + "/customer";
  private carApiUrl = environment.apiBaseUrl + "/car";
  static serviceCenterId: any;
  static selectedCustomer: any;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  public getCustomersByServiceCenterId(): Observable<Customer[]> {
    return this.http.get(`${this.baseUrl}/${CustomerService.serviceCenterId}`).pipe(
      map((json: any) => {
        const customers: Customer[] = [];
        for (const customer of json) {
          customers.push(new Customer(customer));
        }
        return customers;
      })
    );
  }

  public getCustomersWithUnpaidInvoices(): Observable<Customer[]> {
    return this.http.get(`${this.baseUrl}/unpaidInvoices/${CustomerService.serviceCenterId}`).pipe(
      map((json: any) => {
        const customers: Customer[] = [];
        for (const customer of json) {
          customers.push(new Customer(customer));
        }
        return customers;
      })
    );
  }

  public addCustomer(customer: Customer): Observable<boolean> {
    return this.http.post<any>(`${this.baseUrl}`, customer).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public updateCustomer(customer: Customer): Observable<boolean> {
    return this.http.put<any>(`${this.baseUrl}/${customer.customer_ID}`, customer).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public deleteCustomer(serviceCenterId: number,customerId: number): Observable<boolean> {
    return this.http.delete<any>(`${this.baseUrl}/${serviceCenterId}/${customerId}`).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public getCars(): Observable<Car[]> {
    return this.http.get(`${this.carApiUrl}`).pipe(
      map((json: any) => {
        const cars: Car[] = [];
        for (const car of json) {
          cars.push(new Car(car));
        }
        return cars;
      })
    );
  }
}
