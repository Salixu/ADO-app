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
    this.router.navigate(['register']);
  }

  onLogIn() {
    this.router.navigate(['login']);
  }

  onAboutMe() {
    this.router.navigate(['about-me']);
  }

  logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }

  profile() {
    const id = this.tokenStorageService.getUser();
    this.router.navigate(['profile/' + id.id]);
  }

  description() {
    this.router.navigate(['description']);
  }
}
