package com.bartosz.ado.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class user_request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_user_request;

    @OneToMany(mappedBy = "user")
    private Set<user_request> id_user;

    @OneToMany(mappedBy = "image")
    private Set<user_request> id_image;

    private String request_date;
    private int requests_number;

    public user_request(int id_user_request, Set<user_request> id_user, Set<user_request> id_image, String request_date, int requests_number) {
        this.id_user_request = id_user_request;
        this.id_user = id_user;
        this.id_image = id_image;
        this.request_date = request_date;
        this.requests_number = requests_number;
    }

    public user_request() {

    }

    public int getId_user_request() {
        return id_user_request;
    }

    public void setId_user_request(int id_user_request) {
        this.id_user_request = id_user_request;
    }

    public Set<user_request> getId_user() {
        return id_user;
    }

    public void setId_user(Set<user_request> id_user) {
        this.id_user = id_user;
    }

    public Set<user_request> getId_image() {
        return id_image;
    }

    public void setId_image(Set<user_request> id_image) {
        this.id_image = id_image;
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
