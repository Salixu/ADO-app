import {AuthGuardGuard} from './services/auth-guard.guard';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {UserhubComponent} from './components/user/userhub/userhub.component';
import {AboutMeComponent} from './components/about-me/about-me.component';
import {RegisterComponent} from './components/register/register.component';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {FrontPageComponent} from './components/front-page/front-page.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: 'user-hub',
    component: UserhubComponent,
    canActivate: [AuthGuardGuard],
  },
  { path: 'about-me', component: AboutMeComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', component: FrontPageComponent },
  { path: '**', component: NotFoundComponent },
];

export const AppRoutingModule = RouterModule.forRoot(routes);
