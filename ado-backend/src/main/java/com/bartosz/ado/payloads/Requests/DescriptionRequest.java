package com.bartosz.ado.payloads.Requests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class DescriptionRequest {
    private int user_id;
    private MultipartFile image;
}
