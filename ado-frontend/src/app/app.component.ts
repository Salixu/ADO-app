import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from './services/token-storage.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'ADO-version-alpha';
  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  username: string;

  constructor(
    private tokenStorageService: TokenStorageService,
    private router: Router) { }

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.username = user.username;
    }
  }

  isLogged(): boolean{
    return !!this.tokenStorageService.getToken();
  }

  onCreateAccount() {
    const clear = document.getElementsByClassName('active-nav');
    for (let i = 0; i < clear.length; i++){
      clear.item(i).className = ' ';
    }
    const element = document.getElementById('onCreateAccount');
    element.className = 'active-nav';
    this.router.navigate(['register']);
  }

  onLogIn() {
    const clear = document.getElementsByClassName('active-nav');
    for (let i = 0; i < clear.length; i++){
      clear.item(i).className = ' ';
    }
    const element = document.getElementById('onLogIn');
    element.className = 'active-nav';
    this.router.navigate(['login']);
  }

  onAboutMe() {
    const clear = document.getElementsByClassName('active-nav');
    for (let i = 0; i < clear.length; i++){
      clear.item(i).className = ' ';
    }
    const element = document.getElementById('onAboutMe');
    element.className = 'active-nav';
    this.router.navigate(['']);
  }

  logout() {
    const clear = document.getElementsByClassName('active-nav');
    for (let i = 0; i < clear.length; i++){
      clear.item(i).className = ' ';
    }
    const element = document.getElementById('logout');
    element.className = 'active-nav';
    this.tokenStorageService.signOut();
    window.location.reload();
  }

  profile() {
    const clear = document.getElementsByClassName('active-nav');
    for (let i = 0; i < clear.length; i++){
      clear.item(i).className = ' ';
    }
    const element = document.getElementById('profile');
    element.className = 'active-nav';
    const name = this.tokenStorageService.getUser();
    this.router.navigate(['profile/' + name.username]);
  }

  description() {
    const clear = document.getElementsByClassName('active-nav');
    for (let i = 0; i < clear.length; i++){
      clear.item(i).className = ' ';
    }
    const element = document.getElementById('description');
    element.className = 'active-nav';
    this.router.navigate(['description']);
  }
}
