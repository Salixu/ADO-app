import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UploadFilesComponent } from './components/upload-files/upload-files.component';
import {HttpClientModule} from '@angular/common/http';
import { NavigationComponent } from './components/navigation/navigation.component';
import { ApiResponseComponent } from './components/api-response/api-response.component';
import { DndDirective } from './components/directives/dnd.directive';
import { TestComponent } from './components/test/test.component';




@NgModule({
  declarations: [
    AppComponent,
    UploadFilesComponent,
    NavigationComponent,
    ApiResponseComponent,
    DndDirective,
    TestComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
