package com.bartosz.ado.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.sql.Blob;

@Getter
@Setter
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne()
//    @JoinColumn(name= "id_user")
    private int id_user;

    private String image_name;
    private String description;

    @Lob
    private byte[] image;

    public Image(int id_image, int id_user, String image_name, byte[] image, String image_description) {
        this.id= id_image;
        this.id_user = id_user;
        this.image_name = image_name;
        this.image = image;
        this.description = image_description;
    }
    public Image( int id_user, String image_name, byte[] image, String image_description) {
        this.id_user = id_user;
        this.image_name = image_name;
        this.image = image;
        this.description = image_description;
    }

    public Image() {

    }
}
