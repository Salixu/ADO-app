import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UploadFilesComponent } from './components/upload-files/upload-files.component';
import {HttpClientModule} from '@angular/common/http';
import { NavigationComponent } from './components/navigation/navigation.component';
import { ApiResponseComponent } from './components/api-response/api-response.component';




@NgModule({
  declarations: [
    AppComponent,
    UploadFilesComponent,
    NavigationComponent,
    ApiResponseComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
