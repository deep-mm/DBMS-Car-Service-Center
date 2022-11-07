import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { CustomerCar } from 'src/app/models/CustomerCar';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerCarService {

  private apiUrl = environment.apiBaseUrl + "/customerCar";
  static customerId: any;
  static serviceCenterId: any;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  public getCustomerCars(): Observable<CustomerCar[]> {
    return this.http.get(`${this.apiUrl}`).pipe(
      map((json: any) => {
        const customerCars: CustomerCar[] = [];
        for (const customerCar of json) {
          customerCars.push(new CustomerCar(customerCar));
        }
        return customerCars;
      })
    );
  }

  public getCustomerCarsByCustomerId(serviceCenterId: number, customerId: number): Observable<CustomerCar[]> {
    return this.http.get(`${this.apiUrl}/${serviceCenterId}/${customerId}`).pipe(
      map((json: any) => {
        const customerCars: CustomerCar[] = [];
        for (const customerCar of json) {
          customerCars.push(new CustomerCar(customerCar));
        }
        return customerCars;
      })
    );
  }

  public getCustomerCarById(customerCarId: number): Observable<CustomerCar> {
    return this.http.get(`${this.apiUrl}/${customerCarId}`).pipe(
      map((json: any) => {
        return new CustomerCar(json);
      })
    );
  }

  public addCustomerCar(customerCar: CustomerCar): Observable<boolean> {
    return this.http.post<any>(`${this.apiUrl}`, customerCar).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public updateCustomerCar(customerCar: CustomerCar): Observable<boolean> {
    return this.http.put<any>(`${this.apiUrl}`, customerCar).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public deleteCustomerCar(customerCarId: number): Observable<boolean> {
    return this.http.delete<any>(`${this.apiUrl}/${customerCarId}`).pipe(map((json: boolean) => {
      return json;
    }));
  }

}
