package com.bartosz.ado.controllers;

import com.bartosz.ado.models.dtos.ImageDto;
import com.bartosz.ado.models.mappers.ImageMapper;
import com.bartosz.ado.services.ImageDbService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ImagesController {
    private final ImageDbService imageDbService;

    public ImagesController(ImageDbService imgDbService){
        this.imageDbService = imgDbService;
    }

    @GetMapping("/images/{id}")
    public ImageDto getImageById(@PathVariable("id") Integer idUser){
        return ImageMapper.mapToImageDto(this.imageDbService.getImageByUserId(idUser));
    }
}
