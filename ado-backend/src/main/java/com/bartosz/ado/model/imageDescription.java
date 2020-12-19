package com.bartosz.ado.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class imageDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_description;

    @OneToMany(mappedBy = "image")
    private Set<imageDescription> id_image;

    private String description;

    public imageDescription(int id_description, Set<imageDescription> id_image, String description) {
        this.id_description = id_description;
        this.id_image = id_image;
        this.description = description;
    }

    public imageDescription() {

    }

    public int getId_description() {
        return id_description;
    }

    public void setId_description(int id_description) {
        this.id_description = id_description;
    }

    public Set<imageDescription> getId_image() {
        return id_image;
    }

    public void setId_image(Set<imageDescription> id_image) {
        this.id_image = id_image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
