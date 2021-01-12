package com.bartosz.ado.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;


@Data
@Builder
public class ImageDto {
    private String imageName;
    private Map<String, String> description;
    private byte[] image;
//
//    private Set<String> imageName;
//    private Set<String> description;
//    private Set<byte[]> image;
}
