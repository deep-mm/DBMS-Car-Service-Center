import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { Employee } from 'src/app/models/Employee';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = environment.apiBaseUrl + "/employee";
  public serviceCenterId: number = 0;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };


  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  public getEmployees(): Observable<Employee[]> {
    return this.http.get(`${this.baseUrl}`).pipe(
      map((json: any) => {
        const employees: Employee[] = [];
        for (const employee of json) {
          employees.push(new Employee(employee));
        }
        return employees;
      })
    );
  }

  public getServiceCenterManager(): Observable<Employee> {
    return this.http.get(`${this.baseUrl}/manager/${this.serviceCenterId}`).pipe(
      map((json: any) => {
        return new Employee(json);
      })
    );
  }

  public addEmployee(employee: Employee): Observable<boolean> {
    return this.http.post<any>(`${this.baseUrl}`, employee).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public updateEmployee(employee: Employee): Observable<boolean> {
    return this.http.put<any>(`${this.baseUrl}/${employee.employee_id}`, employee).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public deleteEmployee(employeeId: number): Observable<boolean> {
    return this.http.delete<any>(`${this.baseUrl}/${employeeId}`).pipe(map((json: boolean) => {
      return json;
    })
    );
  }
}
