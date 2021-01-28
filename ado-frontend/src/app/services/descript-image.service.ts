import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpHeaders, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {TokenStorageService} from './token-storage.service';



const AUTH_API = 'http://localhost:8080/api/description';
// const AUTH_API = 'https://ado-live.herokuapp.com/api/description';

@Injectable({
  providedIn: 'root'
})
export class DescriptImageService {

  constructor(
    private http: HttpClient,
    private tokenStorageService: TokenStorageService) {}

  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();
    formData.append('File', file);
    formData.append('user_id', this.tokenStorageService.getUser().id);
    const req = new HttpRequest('POST', `${AUTH_API}/extractLabels`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }


}
