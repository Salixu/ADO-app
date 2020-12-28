package com.bartosz.ado.model;


import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_image;

    @ManyToOne()
    @JoinColumn(name= "id_user")
    private User user;

    private String image_name;

    @Lob
    private byte [] image;

    public Image(int id_image, User id_user, String image_name, byte[] image) {
        this.id_image = id_image;
        this.user = id_user;
        this.image_name = image_name;
        this.image = image;
    }

    public Image() {

    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
