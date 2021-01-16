package com.bartosz.ado.services;

import com.bartosz.ado.models.Image;
import com.bartosz.ado.models.dtos.ImageDto;
import com.bartosz.ado.models.mappers.ImageMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.bartosz.ado.repositories.ImageRepository;

import java.util.List;
import java.util.Set;

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

    public Page<Image> getImagesByUserId(int id, Pageable paging){
        return this.imageRepository.selectAllImages(id, paging);
    }

    public Page<Image> getImagesByUserIdFilter(Integer idUser, Pageable paging, String name) {
        return this.imageRepository.selectFilteredImages(idUser, paging, name);
    }
}
