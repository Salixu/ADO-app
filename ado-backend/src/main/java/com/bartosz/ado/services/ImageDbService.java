package com.bartosz.ado.services;

import com.bartosz.ado.models.Image;
import org.springframework.stereotype.Service;
import com.bartosz.ado.repositories.ImageRepository;

@Service
public class ImageDbService {
    private final ImageRepository imageRepository;

    public ImageDbService(ImageRepository imgRep){
        this.imageRepository = imgRep;
    }
    public Image insertImage(Image image){
        return imageRepository.save(image);
    }

    public Image getImageByUserId(int id){
        return this.imageRepository.findById(id).orElseThrow();
    }
}
