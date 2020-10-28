import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {UploadFileService} from '../../services/upload-file.service';
import {HttpEventType, HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-upload-files',
  templateUrl: './upload-files.component.html',
  styleUrls: ['./upload-files.component.css']
})
export class UploadFilesComponent implements OnInit {

  selectedFiles: FileList;
  currentFile: File;
  progress = 0;
  message = '';
  public imagePath;
  imgURL: any;
  responseBody;

  fileInfos: Observable<any>;

  constructor(private uploadService: UploadFileService) { }

  selectFile(event){
    this.selectedFiles = event.target.files;
  }

  upload(){
    this.progress = 0;
    this.currentFile = this.selectedFiles.item(0);
    // displaying image
    const reader = new FileReader();
    this.imagePath = this.currentFile;
    reader.readAsDataURL(this.currentFile);
    this.uploadService.upload(this.currentFile).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress){
          this.progress = Math.round(100 * event.loaded / event.total);
        }else if (event instanceof HttpResponse){
          this.message = event.body.message;
          this.imgURL = reader.result;
          this.responseBody = event.body;
          console.log(event.body);
        }
      },
      err => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = undefined;
      });
    this.selectedFiles = undefined;
  }

  ngOnInit(): void {
  }

}
