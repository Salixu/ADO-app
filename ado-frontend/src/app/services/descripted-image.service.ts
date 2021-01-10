import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {TokenStorageService} from './token-storage.service';

const AUTH_API = 'http://localhost:8080/api/images/';


@Injectable({
  providedIn: 'root'
})
export class DescriptedImageService {

  constructor(
    private httpClient: HttpClient,
    private tokenStorage: TokenStorageService
  ) { }

  getImages(){
    return this.httpClient.get(AUTH_API + this.tokenStorage.getUser().id);
  }
}
