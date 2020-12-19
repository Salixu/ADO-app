package com.bartosz.ado.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_image;

    @OneToMany(mappedBy = "user")
    private Set<image> id_user;

    private String image_name;

    @Lob
    private byte [] image;

    public image(int id_image, Set<image> id_user, String image_name, byte[] image) {
        this.id_image = id_image;
        this.id_user = id_user;
        this.image_name = image_name;
        this.image = image;
    }

    public image() {

    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public Set<com.bartosz.ado.model.image> getId_user() {
        return id_user;
    }

    public void setId_user(Set<image> id_user) {
        this.id_user = id_user;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
