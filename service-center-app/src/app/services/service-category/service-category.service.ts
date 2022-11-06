import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { ServiceCategory } from 'src/app/models/ServiceCategory';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceCategoryService {

  private baseUrl = environment.apiBaseUrl + "/serviceCategory";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };


  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  public getServiceCategories(): Observable<ServiceCategory[]> {
    return this.http.get(`${this.baseUrl}`).pipe(
      map((json: any) => {
        const service_categories: ServiceCategory[] = [];
        for (const service_category of json) {
          service_categories.push(new ServiceCategory(service_category));
        }
        return service_categories;
      })
    );
  }

  public addServiceCategory(serviceCategory: ServiceCategory): Observable<boolean> {
    return this.http.post<any>(`${this.baseUrl}`, serviceCategory).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public updateServiceCategory(serviceCategory: ServiceCategory): Observable<boolean> {
    return this.http.put<any>(`${this.baseUrl}/${serviceCategory.category_id}`, serviceCategory).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public deleteServiceCategory(serviceCategoryId: number): Observable<boolean> {
    return this.http.delete<any>(`${this.baseUrl}/${serviceCategoryId}`).pipe(map((json: boolean) => {
      return json;
    })
    );
  }
}
