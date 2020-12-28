package com.bartosz.ado.model.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class userDto {
    private String name;
    private String surname;
    private String email;
}
