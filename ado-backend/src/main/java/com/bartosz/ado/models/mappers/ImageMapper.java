package com.bartosz.ado.models.mappers;

import com.bartosz.ado.models.Image;
import com.bartosz.ado.models.dtos.ImageDto;
import com.bartosz.ado.models.dtos.UserDto;

public class ImageMapper {

    public static ImageDto mapToImageDto(Image image){
        UserDto user = UserDto.builder()
                .id(image.getUser().getId())
                .build();
        return ImageDto.builder()
                .image_name(image.getImage_name())
                .description(image.getDescription())
                .image(image.getImage())
                .user(user)
                .build();
    }

}
