import {Component, OnInit} from '@angular/core';
import { FileHandle } from './components/directives/dnd.directive';
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UploadFileService} from './services/upload-file.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'ADO-version-alpha';

  constructor() {}

  ngOnInit(): void {}

}
