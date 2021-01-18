package com.bartosz.ado.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;


@Data
@Builder
public class ImageDto {
    private int id;
    private String imageName;
    private Map<String, String> description;
    private byte[] image;

}
