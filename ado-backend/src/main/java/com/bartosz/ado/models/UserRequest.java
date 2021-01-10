package com.bartosz.ado.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class UserRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name= "id_user")
    private User user;

    @ManyToOne()
    @JoinColumn(name="id_image")
    private Image image;

    private String request_date;
    private int requests_number;

    public UserRequest(int id_user_request, User user, Image image, String request_date, int requests_number) {
        this.id = id_user_request;
        this.user = user;
        this.image = image;
        this.request_date = request_date;
        this.requests_number = requests_number;
    }

    public UserRequest() {

    }

}
