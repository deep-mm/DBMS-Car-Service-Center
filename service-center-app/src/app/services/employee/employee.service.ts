import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { Employee } from 'src/app/models/Employee';
import { MechanicSchedule } from 'src/app/models/MechanicSchedule';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = environment.apiBaseUrl + "/employee";
  static serviceCenterId: any;
  static managerUsername: any;
  static roles: any;
  static serviceCenter: any;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  public getEmployeesByServiceCenter(serviceCenterId: number): Observable<Employee[]> {
    return this.http.get(`${this.baseUrl}/${serviceCenterId}`).pipe(
      map((json: any) => {
        const employees: Employee[] = [];
        for (const employee of json) {
          employees.push(new Employee(employee));
        }
        return employees;
      })
    );
  }

  public getMechanicSchedule(serviceCenterId: number, employeeId: number): Observable<MechanicSchedule[]> {
    return this.http.get(`${this.baseUrl}/mechanic/${serviceCenterId}/${employeeId}`).pipe(
      map((json: any) => {
        const employees: MechanicSchedule[] = [];
        for (const employee of json) {
          employees.push(new MechanicSchedule(employee));
        }
        return employees;
      })
    );
  }

  public getManager(): Observable<Employee> {
    return this.http.get(`${this.baseUrl}/manager/${EmployeeService.managerUsername}`).pipe(
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
    return this.http.put<any>(`${this.baseUrl}/${employee.employee_ID}`, employee).pipe(map((json: boolean) => {
      return json;
    })
    );
  }

  public deleteEmployee(employeeId: number): Observable<boolean> {
    return this.http.delete<any>(`${this.baseUrl}/${EmployeeService.serviceCenterId}/${employeeId}`).pipe(map((json: boolean) => {
      return json;
    })
    );
  }
}
