package com.bartosz.ado.controllers;

import com.bartosz.ado.models.Image;
import com.bartosz.ado.models.dtos.ImageDto;
import com.bartosz.ado.models.mappers.ImageMapper;
import com.bartosz.ado.services.GoogleTranslate;
import com.bartosz.ado.services.ImageDbService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//@CrossOrigin(origins = "http://ado-frontend.herokuapp.com", maxAge = 3600)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ImagesController {
    private final ImageDbService imageDbService;
    private final GoogleTranslate googleTranslate;

    public ImagesController(ImageDbService imgDbService, GoogleTranslate googleTranslate){
        this.imageDbService = imgDbService;
        this.googleTranslate = googleTranslate;
    }

    @GetMapping("/image/{id}")
    public ImageDto getImageById(@PathVariable("id") Integer idUser){
        return ImageMapper.mapToImageDto(this.imageDbService.getImageByUserId(idUser));
    }

    @DeleteMapping("/images")
    public void deleteImage(
            @RequestParam() int id)
    {
        this.imageDbService.deleteImageById(id);
    }


    @GetMapping("/images/{id}")
    public ResponseEntity<List<ImageDto>> getImagesById(@PathVariable("id") Integer idUser,
                                                       @RequestParam(required = false)String name,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "3") int size){
        try {
            Pageable paging = PageRequest.of(page, size);
            Page<Image> pageDtos;
            List<ImageDto> imagesDto = new ArrayList<ImageDto>();

            if (name == null){
                pageDtos = this.imageDbService.getImagesByUserId(idUser, paging);

            }else{
                pageDtos = this.imageDbService.getImagesByUserIdFilter(idUser, paging, name);
            }

            imagesDto = ImageMapper.mapToImagesDtos(pageDtos.getContent());

            Map<String, Object> response = new HashMap<>();
            response.put("images", imagesDto);
            response.put("currentPage", pageDtos.getNumber());
            response.put("totalItems", pageDtos.getTotalElements());
            response.put("totalPages", pageDtos.getTotalPages());
            return new ResponseEntity(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
