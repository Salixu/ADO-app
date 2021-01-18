import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../../services/token-storage.service';
import {DescriptedImageService} from '../../services/descripted-image.service';
import {Subscription} from 'rxjs';
import { DomSanitizer } from '@angular/platform-browser';
import {MatIconRegistry} from '@angular/material/icon';


const SEARCH_ICON = `
  <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="white" width="18px" height="18px"><path d="M0 0h24v24H0z" fill="none"/>
  <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91" +
   "3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01" +
    "5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"/>
    </svg>`;

const DELETE_ICON = `
  <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/>
  <path d="M12 2C6.47 2 2 6.47 2 12s4.47 10 10 10 10-4.47 10-10S17.53 2 12 2zm5 13.59L15.59 17 12 13.41 8.41 17 7" +
   "15.59 10.59 12 7 8.41 8.41 7 12 10.59 15.59 7 17 8.41 13.41 12 17 15.59z"/>
  </svg>`;

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {


  isLoggedIn = false;
  private profileServiceSub: Subscription;
  public image: any;
  images: any[] = [];
  currentImage?: any;
  currentIndex = -1;
  name = '';
  page = 1;
  count = 0;
  pageSize = 3;


  constructor(
    private tokenStorage: TokenStorageService,
    private descriptedImage: DescriptedImageService,
    private sanitizer: DomSanitizer,
    iconRegistry: MatIconRegistry
  ) {
    iconRegistry.addSvgIconLiteral('search_icon', sanitizer.bypassSecurityTrustHtml(SEARCH_ICON));
    iconRegistry.addSvgIconLiteral('delete_icon', sanitizer.bypassSecurityTrustHtml(DELETE_ICON));
  }

  ngOnInit(): void {
    this.getData();
  }

  getRequestParams(searchName: string, page: number, pageSize: number): any{
    // tslint:disable-next-line:prefer-const
    let params: any = {};
    if (searchName){
      params[`name`] = searchName;
    }
    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  getData(): void{
    const params = this.getRequestParams(this.name, this.page, this.pageSize);
    this.profileServiceSub = this.descriptedImage.getImages(params).subscribe(
      response =>
      {
        const{ images, totalItems } = response;
        this.images = images;
        this.prepareImages(images);
        this.count = totalItems;
        console.log(this.images);

      },
      error => {
        console.log(error);
      });
  }

  handlePageChange(event: number): void{
    this.page = event;
    window.scrollTo(0,0);
    this.getData();
  }



  setActiveImage(image: any, index: number): void {
    this.currentImage = image;
    this.currentIndex = index;
  }


  prepareImages(data: object): void{

    for ( let i=0; i<this.images.length; i++ ) {
      const image = 'data:image;base64,' + data[i].image;
      this.images[i].image = this.sanitizer.bypassSecurityTrustUrl(image);
      this.images[i].imageName = this.images[i].imageName.substring(0, this.images[i].imageName.indexOf('.'));
    }
  }

  deleteImage(id: number) {
    const params = {
      id,
      id_user: this.tokenStorage.getUser().id
    };
    this.descriptedImage.deleteImage(params).subscribe(
      data => {
        this.getData();
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  setPage() {
    this.page = 1;
    this.getData();
  }
}
