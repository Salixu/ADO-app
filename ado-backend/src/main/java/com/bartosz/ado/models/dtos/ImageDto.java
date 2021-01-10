package com.bartosz.ado.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.File;


@Data
@Builder
public class ImageDto {
    private int id;
    private UserDto user;
    private String image_name;
    private String description;
    private byte[] image;
}
