import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { Car } from 'src/app/models/Car';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  
  private carApiUrl = environment.apiBaseUrl + "/car";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

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

  public getCarById(carId: number): Observable<Car> {
    return this.http.get(`${this.carApiUrl}/${carId}`).pipe(
      map((json: any) => {
        return new Car(json);
      })
    );
  }

  public addCar(car: Car): Observable<boolean> {
    return this.http.post<any>(`${this.carApiUrl}`, car).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public updateCar(car: Car): Observable<boolean> {
    return this.http.put<any>(`${this.carApiUrl}`, car).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public deleteCar(carId: number): Observable<boolean> {
    return this.http.delete<any>(`${this.carApiUrl}/${carId}`).pipe(map((json: boolean) => {
      return json;
    }));
  }

}
