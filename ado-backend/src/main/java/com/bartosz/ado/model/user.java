package com.bartosz.ado.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_user;

    private String name;
    private String surname;
    private String email;
    private String salt;
    private String hash;
    private String date_created;


    public user(int id_user, String name, String surname, String email, String salt, String hash, String date_created) {
        this.id_user = id_user;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.salt = salt;
        this.hash = hash;
        this.date_created = date_created;
    }

    public user() {

    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }
}
