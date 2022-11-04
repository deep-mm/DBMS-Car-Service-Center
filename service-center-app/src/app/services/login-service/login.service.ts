import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';
import { Login } from 'src/app/models/Login';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl = environment.apiBaseUrl + "/login";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  public login(login: Login): Observable<Login> {
    return this.http.post<any>(`${this.baseUrl}`, login).pipe(map((json: string) => {
      return new Login(json);
    })
    );
  }
}
