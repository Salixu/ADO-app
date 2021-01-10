package com.bartosz.ado.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String email;
    private String hash;
    private String date_created;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles = new HashSet<>();


    public User(int id_user, String name, String surname, String email, String hash, String date_created) {
        this.id = id_user;
        this.name = email;
        this.surname = surname;
        this.email = name;
        this.hash = hash;
        this.date_created = date_created;
    }

    public User() {

    }

    public User(String name, String surname,String email, String encode) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.hash = encode;
    }

}
