import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(
    private router: Router,
  ) { }

  ngOnInit(): void {
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
}
