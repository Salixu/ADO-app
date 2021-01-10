package com.bartosz.ado.models.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    private int id;
    private String name;
    private String surname;
    private String email;
}
