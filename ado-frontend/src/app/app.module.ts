import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UploadFilesComponent } from './components/upload-files/upload-files.component';
import { HttpClientModule } from '@angular/common/http';
import { ApiResponseComponent } from './components/api-response/api-response.component';
import { DndDirective } from './components/directives/dnd.directive';
import { TestComponent } from './components/test/test.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { UserhubComponent } from './components/user/userhub/userhub.component';
import { AboutMeComponent } from './components/about-me/about-me.component';
import { AppRoutingModule } from './app.routing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {authInterceptorProviders} from './helpers/auth.interceptor';
import {MaterialModule} from './material';
import {FormsModule} from '@angular/forms';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { FrontPageComponent } from './components/front-page/front-page.component';
import { ProfileComponent } from './components/profile/profile.component';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    AppComponent,
    UploadFilesComponent,
    ApiResponseComponent,
    DndDirective,
    TestComponent,
    RegisterComponent,
    LoginComponent,
    UserhubComponent,
    AboutMeComponent,
    NotFoundComponent,
    FrontPageComponent,
    ProfileComponent
  ],
  exports:[
    MaterialModule,
  ],
    imports: [
        BrowserModule,
        MaterialModule,
        HttpClientModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        FormsModule,
        NgxPaginationModule
    ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
