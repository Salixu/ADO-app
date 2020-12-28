package com.bartosz.ado.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_role;

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role(ERole name) { this.name = name;}
}
