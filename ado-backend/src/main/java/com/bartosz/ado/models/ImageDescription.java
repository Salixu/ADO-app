package com.bartosz.ado.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ImageDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne()
    @JoinColumn(name= "id_image")
    private Image image;

    private String description;

    public ImageDescription(int id_description, Image image, String description) {
        this.id = id_description;
        this.image = image;
        this.description = description;
    }

    public ImageDescription() {

    }

}
