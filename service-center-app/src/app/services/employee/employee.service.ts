import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';
import { Employee } from 'src/app/models/Employee';
import { Leave } from 'src/app/models/Leave';
import { MechanicSchedule } from 'src/app/models/MechanicSchedule';
import { SwapSlot } from 'src/app/models/SwapSlot';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = environment.apiBaseUrl + "/employee";
  public leaveUrl = environment.apiBaseUrl + "/leave";
  public swapslotsUrl = environment.apiBaseUrl + "/swapSlots";
  static serviceCenterId: any;
  static managerUsername: any;
  static employeeId: any;
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

  public getMechanicsSchedules(serviceCenterId: number): Observable<MechanicSchedule[]> {
    return this.http.get(`${this.baseUrl}/mechanic/${serviceCenterId}`).pipe(
      map((json: any) => {
        const employees: MechanicSchedule[] = [];
        for (const employee of json) {
          employees.push(new MechanicSchedule(employee));
        }
        return employees;
      })
    );
  }

  public getLeaves(serviceCenterId: number): Observable<Leave[]> {
    return this.http.get(`${this.leaveUrl}/${serviceCenterId}`).pipe(
      map((json: any) => {
        const leaves: Leave[] = [];
        for (const leave of json) {
          leaves.push(new Leave(leave));
        }
        return leaves;
      })
    );
  }

  public addLeave(leave: Leave): Observable<boolean> {
    return this.http.post<any>(`${this.leaveUrl}`, leave).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public getSwapSlots(serviceCenterId: number): Observable<SwapSlot[]> {
    return this.http.get(`${this.swapslotsUrl}/${serviceCenterId}`).pipe(
      map((json: any) => {
        const leaves: SwapSlot[] = [];
        for (const leave of json) {
          leaves.push(new SwapSlot(leave));
        }
        return leaves;
      })
    );
  }

  public addSwapSlot(swapSlot: SwapSlot): Observable<boolean> {
    return this.http.post<any>(`${this.swapslotsUrl}`, swapSlot).pipe(map((json: boolean) => {
      return json;
    }));
  }

  public updateSwapSlot(swapSlot: SwapSlot): Observable<boolean> {
    return this.http.put<any>(`${this.swapslotsUrl}/${swapSlot.requested_service_center_id}/${swapSlot.requestor_employee_id}/${swapSlot.requested_employee_id}`, swapSlot).pipe(map((json: boolean) => {
      return json;
    }));
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
