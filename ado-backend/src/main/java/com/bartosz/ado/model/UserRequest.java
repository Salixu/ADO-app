package com.bartosz.ado.model;

import javax.persistence.*;

@Entity
public class UserRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user_request;

    @ManyToOne()
    @JoinColumn(name= "id_user")
    private User user;

    @ManyToOne()
    @JoinColumn(name="id_image")
    private Image image;

    private String request_date;
    private int requests_number;

    public UserRequest(int id_user_request, User user, Image image, String request_date, int requests_number) {
        this.id_user_request = id_user_request;
        this.user = user;
        this.image = image;
        this.request_date = request_date;
        this.requests_number = requests_number;
    }

    public UserRequest() {

    }

    public int getId_user_request() {
        return id_user_request;
    }

    public void setId_user_request(int id_user_request) {
        this.id_user_request = id_user_request;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getRequest_date() {
        return request_date;
    }

    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    public int getRequests_number() {
        return requests_number;
    }

    public void setRequests_number(int requests_number) {
        this.requests_number = requests_number;
    }
}
