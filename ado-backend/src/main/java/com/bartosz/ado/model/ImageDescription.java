package com.bartosz.ado.model;

import javax.persistence.*;

@Entity
public class ImageDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_description;


    @ManyToOne()
    @JoinColumn(name= "id_image")
    private Image image;

    private String description;

    public ImageDescription(int id_description, Image image, String description) {
        this.id_description = id_description;
        this.image = image;
        this.description = description;
    }

    public ImageDescription() {

    }

    public int getId_description() {
        return id_description;
    }

    public void setId_description(int id_description) {
        this.id_description = id_description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
