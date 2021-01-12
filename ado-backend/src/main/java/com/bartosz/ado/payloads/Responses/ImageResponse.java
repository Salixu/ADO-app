package com.bartosz.ado.payloads.Responses;

import com.bartosz.ado.models.dtos.ImageDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class ImageResponse {
    int totalItems;
    Set<ImageDto> images;
    int totalPages;
    int currentPage;
}
