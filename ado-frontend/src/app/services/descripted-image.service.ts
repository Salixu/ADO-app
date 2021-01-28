import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';
import {Observable} from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/images/';
// const AUTH_API = 'https://ado-live.herokuapp.com/api/images/';

@Injectable({
  providedIn: 'root'
})
export class DescriptedImageService {

  constructor(
    private httpClient: HttpClient,
    private tokenStorage: TokenStorageService
  ) { }

  getImages(params: any): Observable<any>{
    return this.httpClient.get<any>(AUTH_API + this.tokenStorage.getUser().id, { params });
  }

  deleteImage(params: any): Observable<any>{
    return this.httpClient.delete(AUTH_API, { params } );
  }
}
