import { Component, HostListener, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {UploadFileService} from '../../services/upload-file.service';
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {FileHandle} from '../directives/dnd.directive';

@Component({
  selector: 'app-upload-files',
  templateUrl: './upload-files.component.html',
  styleUrls: ['./upload-files.component.css']
})
export class UploadFilesComponent implements OnInit {


  files: FileHandle = null;
  displayButton = true;
  isSuccess = true;

  public imagePath;
  imgURL: any;
  responseBody;

  fileInfos: Observable<any>;
  private message: any;

  constructor(
    private fileUploadService: UploadFileService,
  ) {}


  ngOnInit(): void {}


  filesDropped(files: FileHandle): void {
    this.displayButton = false;
    this.files = files;
  }

  handleFileInput(files: FileHandle): void {
    this.files = files;
  }

  upload(){
    const reader = new FileReader();
    const file = this.files.file;
    this.imagePath = file;
    reader.readAsDataURL(file);
    this.fileUploadService.upload(file).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress){
        }else if (event instanceof HttpResponse){
          this.message = event.body.message;
          this.imgURL = reader.result;
          this.responseBody = event.body;
          this.isSuccess = false;
        }
      },
      err => {
        this.message = 'Nie można przesłać pliku';
        this.files = undefined;
      });
  }

}
