import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../../services/token-storage.service';
import {DescriptedImageService} from '../../services/descripted-image.service';
import {Subscription} from 'rxjs';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';



@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  srcData: SafeResourceUrl;
  isLoggedIn = false;
  private profileServiceSub: Subscription;
  public imageObject: any;
  public tableData;
  public image: any;


  constructor(
    private tokenStorage: TokenStorageService,
    private descriptedImage: DescriptedImageService,
    private sanitizer: DomSanitizer
  ) {}

  ngOnInit(): void {
    this.profileServiceSub = this.descriptedImage.getImages().subscribe(
    (data) =>
    {
      this.prepareData(data);
    });
  }


  prepareData(data: object){
    // const image = 'data:image;base64,' + data[1].image;
    // this.image = this.sanitizer.bypassSecurityTrustUrl(image);
    // this.tableData = data[1].description;
    console.log(data);
  }
}
