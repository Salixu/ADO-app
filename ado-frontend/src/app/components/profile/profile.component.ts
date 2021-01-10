import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../../services/token-storage.service';
import {DescriptedImageService} from '../../services/descripted-image.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  isLoggedIn = false;
  private profileServiceSub: Subscription;
  public imageObject: any;
  public image: any;


  constructor(
    private tokenStorage: TokenStorageService,
    private descriptedImage: DescriptedImageService
  ) {}

  ngOnInit(): void {
    const reader = new FileReader();
    this.profileServiceSub = this.descriptedImage.getImages().subscribe(
    (data) =>
    {
      this.imageObject = data;
      this.convertBlobToImage(this.imageObject.image);
    });
  }

  convertBlobToImage(image: Blob){
    const reader = new FileReader();
    reader.addEventListener(`load`,
      () => {
        this.image = reader.result;
      },
      false);

    if (image) {
      if (image.type !== `application/pdf`) {
        reader.readAsDataURL(image);
      }
    }
  }

}
