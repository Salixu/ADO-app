import { Component, HostListener, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {DescriptImageService} from '../../services/descript-image.service';
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {FileHandle} from '../directives/dnd.directive';
import {state, style, trigger} from '@angular/animations';

@Component({
  selector: 'app-upload-files',
  templateUrl: './upload-files.component.html',
  styleUrls: ['./upload-files.component.css'],
  animations: [
    trigger('loading',[
      state(
        'none',
        style({
          display: 'none'
        })
      )
    ])
  ]
})
export class UploadFilesComponent implements OnInit {


  files: FileHandle = null;
  displayButton = true;
  isSuccess = true;
  isFinish = false;

  public imagePath;
  imgURL: any;
  responseBody;
  error = false;
  fileInfos: Observable<any>;
  private message: any;

  constructor(
    private fileUploadService: DescriptImageService,
  ) {}


  ngOnInit(): void {}


  filesDropped(files: FileHandle): void {
    this.displayButton = false;
    this.files = files;
  }

  handleFileInput(files: FileHandle): void {
    this.displayButton = false;
    this.files = files;
  }

  upload(){
    this.isFinish = true;
    const reader = new FileReader();
    const file = this.files.file;
    this.imagePath = file;
    reader.readAsDataURL(file);
    this.fileUploadService.upload(file).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress){
        }else if (event instanceof HttpResponse){
          this.isFinish = false;
          this.message = event.body.message;
          this.imgURL = reader.result;
          this.responseBody = event.body;
          this.isSuccess = false;
          this.error = true;
        }
      },
      err => {
        this.error = true;
        this.message = 'Nie można przesłać pliku';
        this.files = undefined;
      });
  }

}
