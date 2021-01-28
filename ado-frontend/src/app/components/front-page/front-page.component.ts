import { Component, OnInit } from '@angular/core';
import {trigger, state, style, animate, transition} from '@angular/animations';

@Component({
  selector: 'app-front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.css'],
  animations: [
    trigger('flyInOut', [
      transition('void => *', [
        style({
          height: '60vh',
        }),
        animate('1.2s')
      ]),
    ]),
  ]
})
export class FrontPageComponent implements OnInit {

  isOpen = false;
  constructor() { }

  ngOnInit(): void {
    this.toggle();
  }

  toggle(){
      this.isOpen = !this.isOpen;
  }
}
