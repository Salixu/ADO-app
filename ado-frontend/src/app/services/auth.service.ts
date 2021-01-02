import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {TokenStorageService} from './token-storage.service';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient,
    private token: TokenStorageService) { }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      name: credentials.name,
      password: credentials.password
    }, httpOptions);
  }

  register(user): Observable<any> {
    console.log('register');
    return this.http.post(AUTH_API + 'signup', {
      name: user.email,
      surname: user.surname,
      email: user.name,
      password: user.password
    }, httpOptions);
  }

  public isAuthenticated(): boolean{
    return !this.token.getToken();
  }
}
